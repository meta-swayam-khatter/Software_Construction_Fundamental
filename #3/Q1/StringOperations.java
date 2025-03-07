import java.util.Scanner;

class Operations {
    int equalStrings(String str1, String str2) {
        if(str1 == str2) {
            return 1;
        }
        return 0;
    }

    String reverseString(String str) {
        char[] charArr = str.toCharArray();
        for(int index=0; index<str.length()/2; index++) {
            charArr[index] = charArr[str.length()-index-1];
        }
        return new String(charArr);
    }

    String replaceCase(String str) {
        char[] charArr = str.toCharArray();
        for(char ch : charArr) {
            if(ch >= 97 && ch <= 122) {
                ch = (char)(ch - 32);
            } else if(ch >= 65 && ch<=90) {
                ch = (char)(ch + 32);
            }
        }
        return new String(charArr);
    }

    /*
        String largestWord(String str) {
            
        }
    */
}

public class StringOperations {
    static String string;
    static Scanner sc = new Scanner(System.in);
    static void takeInput() {
        System.out.println("Enter the string: ");
        string = sc.nextLine();
    }
    public static void main(String[] args) {
        Operations obj = new Operations();
        // takeInput();

        while(true) {
            System.out.println("Enter your choice: \n1. Check Equal\n2. Reverse String\n3. Replace Uppercase to Lowercase and vice-versa\n4. Largest Word\n5. Use another String\n0. Exit");
            int choice = sc.nextInt();

            if(choice == 0) {
                System.out.println("Exiting...........\n");
                break;
            }

            switch(choice) {
                case 1:
                    System.out.println("Enter the first String: ");
                    String str1 = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter the second String: ");
                    String str2 = sc.nextLine();
                    System.out.println("str1: " + str1 + " str2: " + str2);
                    System.out.println(obj.equalStrings(str1, str2));
                    break;

                case 2:
                    System.out.println("Enter the String: ");
                    str1 = sc.nextLine();
                    System.out.println("Reversed String: " + obj.reverseString(str1));
                    break;

                case 3:
                    System.out.println("Enter the String: ");
                    str1 = sc.nextLine();
                    System.out.println("New String: " + obj.replaceCase(str1));
                    break;

                case 4:
                    break;
                    
                case 5:
                    takeInput();
                    break;

                default:
                    System.out.println("Enter a valid choice!!\n");
                    break;
            }
        }
        sc.close();
    }
}