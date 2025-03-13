package A6.Q2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Poly {
    private final int[][] terms;

    public Poly(int[][] terms) {
        this.terms = terms;
    }

    public int[][] getTerms() {
        return this.terms;
    }

    /**
     * this function logs errors in error.txt file
     * @param e exception
     */
    private static void logError(Exception e) {
        try(FileWriter fw = new FileWriter("error.txt", true)) {
            fw.write(e.getMessage() + "\n");
        } catch(IOException ioException) {
            System.out.println("Failed to log the error!!");
        }
    }

    /**
     * this function prints the polynomial expression
     */
    public void printPoly() {
        try {
            for(int[] term : terms) {
                System.out.print(term[0] + "x^" + term[1] + " + ");
            }
            return;
        } catch (Exception e) {
            logError(e);
            return;
        }
    }

    /**
     * this function evaluates the polynomial expression based on the value of x
     * @param x value for which the polynomial has to be evaluated
     * @return evaluated result of the polynomial
     */
    public float evaluate(float x) {
        try {
            float sum=0;
            for(int[] term:terms) {
                sum += term[0] * Math.pow(x, term[1]);
            }
            return sum;
        } catch(Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * this function finds the highest degree present in the polynomail
     * @return highest degree in the polynomial
     */
    public int degree() {
        try {
            int maxDegree=0;
            for(int[] term:terms) {
                if(term[1] > maxDegree) {
                    maxDegree = term[1];
                }
            }
            return maxDegree;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * this function add the two polynomials
     * @param p1 first polynomial
     * @param p2 second polynomial
     * @return sum of two polynomials
     */
    public static Poly addPoly(Poly p1, Poly p2) {
        try {
            Set<Integer> exponents = new HashSet<>();
            for(int[] term : p1.terms) {
                exponents.add(term[1]);
            }
            for(int[] term : p2.terms) {
                exponents.add(term[1]);
            }
            int[][] result = new int[exponents.size()][2];
            int index=0;
            for(int exp : exponents) {
                int coef=0;
                for(int[] term : p1.terms) {
                    if(term[1] == exp) coef += term[0]; 
                }
                for(int[] term : p2.terms) {
                    if(term[1] == exp) coef += term[0]; 
                }
                result[index++] = new int[]{coef, exp};
            }
            return new Poly(result);
        } catch (Exception e) {
            logError(e);
            return new Poly(new int[][]{});
        }
    }

    /**
     * this function multiples the two polynomials
     * @param p1 first polynomial
     * @param p2 second polynomial 
     * @return product of two polynomials
     */
    public static Poly multiplyPoly(Poly p1, Poly p2) {
        try {
            int[][] product = new int[p1.terms.length * p2.terms.length][2];
            int index=0;
            for(int[] term1 : p1.terms) {
                for(int[] term2 : p2.terms) {
                    product[index++] = new int[]{term1[0] * term2[0], term1[1] + term2[1]};
                }
            }
            Set<Integer> exponents = new HashSet<>();
            for(int[] prod : product) {
                exponents.add(prod[1]);
            }
            int[][] result = new int[exponents.size()][2];
            index=0;
            for(int exp : exponents) {
                int coef = 0;
                for(int[] prod : product) {
                    if(prod[1] == exp) coef += prod[0]; 
                }
                result[index++] = new int[]{coef, exp};
            }
            return new Poly(result);
        } catch (Exception e) {
            logError(e);
            return new Poly(new int[][]{});
        }
    }
}

public class Abstract2 {
    public static void main(String[] args) {
        // int[][] terms ={{1,1}, {3,2}, {5,3}};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of entries: ");
        int num = sc.nextInt();
        int[][] temp = new int[num][2];
        for(int index=0; index<num; index++) {
            System.out.print("Coefficient: ");
            int coef = sc.nextInt();
            System.out.print("Exponent: ");
            int exp = sc.nextInt();

            temp[index][0] = coef;
            temp[index][1] = exp;
        }
        Poly obj1 = new Poly(temp);

        while(true) {
            System.out.println("\nEnter your choice what you want to do: \n1. Evaluate\n2. Find highest degree\n3. Add 2 polynomials\n4. Multiply 2 polynomials\n0. Exit\n");
            int choice = sc.nextInt();

            if(choice == 0) {
                System.out.println("Exiting..........\n");
                break;
            }

            switch(choice) {
                case 1:
                    System.out.println("Enter the value of x for which you want to evaluate: ");
                    int x = sc.nextInt();

                    System.out.println("Evaluated result: " + obj1.evaluate(x));
                    break;

                case 2:
                    System.out.println("Highest degree present in the polynomail is: " + obj1.degree());
                    break;

                case 3:
                    System.out.println("Enter the number of entries for the 2nd polynomial: ");
                    num = sc.nextInt();
                    temp = new int[num][2];
                    for(int index=0; index<num; index++) {
                        System.out.print("Coefficient: ");
                        int coef = sc.nextInt();
                        System.out.print("Exponent: ");
                        int exp = sc.nextInt();
            
                        temp[index][0] = coef;
                        temp[index][1] = exp;
                    }
                    Poly obj2 = new Poly(temp);

                    Poly sum = Poly.addPoly(obj1, obj2);
                    System.out.print("Resultant polygon after adding : ");
                    obj1.printPoly();
                    System.out.print(" and ");
                    obj2.printPoly();
                    System.out.println(" is: ");
                    sum.printPoly();
                    break;

                case 4:
                    System.out.println("Enter the number of entries for the 2nd polynomial: ");
                    num = sc.nextInt();
                    temp = new int[num][2];
                    for(int index=0; index<num; index++) {
                        System.out.print("Coefficient: ");
                        int coef = sc.nextInt();
                        System.out.print("Exponent: ");
                        int exp = sc.nextInt();
            
                        temp[index][0] = coef;
                        temp[index][1] = exp;
                    }
                    obj2 = new Poly(temp);

                    Poly product = Poly.multiplyPoly(obj1, obj2);
                    System.out.print("Resultant polygon after multiplying : ");
                    obj1.printPoly();
                    System.out.print(" and ");
                    obj2.printPoly();
                    System.out.println(" is: ");
                    product.printPoly();
                    break;

                default:
                    System.out.println("Enter a valid input!!\n");
                    break;
            }
        }

        System.out.println(obj1.degree());
        sc.close();
    }
}
