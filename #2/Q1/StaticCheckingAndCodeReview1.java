import java.util.Scanner;

class HexCalc {
    /* this function converts hexadecimal number to decimal number */
    int hexToDecimal(String hex) {
        int decimal = 0;
        try {
            int length = hex.length();
            for (int index = 0; index < length; index++) {
                char hexChar = hex.charAt(length - index - 1);
                int value;
                if (hexChar >= '0' && hexChar <= '9') { // if char is a number
                    value = hexChar - '0';
                } else if (hexChar >= 'A' && hexChar <= 'F') { // if char is an alphabet from A-F
                    value = hexChar - 'A' + 10;
                } else {
                    throw new IllegalArgumentException("Invalid character!\n"); // if the hex string has a character other
                                                                                // than 0-9 or A-F, throw error
                }
                decimal += value * Math.pow(16, index);
            }
        } catch(Exception e) {
            System.out.println("Error in converting Hexadecimal to Decimal: " + e.getMessage());
        }
        return decimal;
    }

    /* this function converts decimal number to hexadecimal number */
    String decimalToHex(int decimal) {
        if (decimal < 0) { // this code is only for positive integers according to assignment
                           // specifications
            throw new IllegalArgumentException("Only postitive integers!!");
        }

        StringBuilder hex = new StringBuilder(); // StringBuilder for the new hexadecimal string
        try {
            while (decimal > 0) {
                int rem = decimal % 16;
                char hexChar;
                if (rem < 10) { // if rem is less than 10 it will be represented by a number in hexadecimal
                                // string
                    hexChar = (char) ('0' + rem);
                } else { // if rem is greater then or equal to 10 it will be represented by an alpabet
                        // (A-F) in hexadecimal string
                    hexChar = (char) ('A' + (rem - 10));
                }
                hex.insert(0, hexChar);
                decimal = decimal / 16;
            }
        } catch (Exception e) {
            System.out.println("Error in converting Decimal to Hexadecimal: " + e.getMessage());
        }
        return hex.length() > 0 ? hex.toString() : "0"; // converting StringBuilder hex to string before returning
    }

    /*
     * this function adds the 2 hexadecimal strings
     * it converts the hex strings to decimals
     * then perform the arithmatic operation on the decimals
     * and finally converts the resultant decimal to hexadecimal string and returns
     * it
     */
    String add(String hex1, String hex2) {
        String result = null;
        try {
            int dec1 = hexToDecimal(hex1);
            int dec2 = hexToDecimal(hex2);
            int decResult = dec1 + dec2;
            result = decimalToHex(decResult);
        } catch (Exception e) {
            System.out.println("Error in adding Hexadecimal Strings: " + e.getMessage());
        }
        return result;
    }

    /*
     * this function subtracts the 2 hexadecimal strings
     * it converts the hex strings to decimals
     * then perform the arithmatic operation on the decimals
     * and finally converts the resultant decimal to hexadecimal string and returns
     * it
     */
    String subtract(String hex1, String hex2) {
        String result = null;
        try {
            int dec1 = hexToDecimal(hex1);
            int dec2 = hexToDecimal(hex2);
            if (dec1 < dec2) {
                throw new ArithmeticException("-ve number can't compute");
            }
            int decResult = dec1 - dec2;
            result = decimalToHex(decResult);
        } catch (Exception e) {
            System.out.println("Error in subtracting Hexadecimal Strings: " + e.getMessage());
        }
        return result;
    }

    /*
     * this function multiplies the 2 hexadecimal strings
     * it converts the hex strings to decimals
     * then perform the arithmatic operation on the decimals
     * and finally converts the resultant decimal to hexadecimal string and returns
     * it
     */
    String multiply(String hex1, String hex2) {
        String result = null;
        try {
            int dec1 = hexToDecimal(hex1);
            int dec2 = hexToDecimal(hex2);
            int decResult = dec1 * dec2;
            result = decimalToHex(decResult);
        } catch (Exception e) {
            System.out.println("Error in multiplying Hexadecimal Strings: " + e.getMessage());
        }
        return result;
    }

    /*
     * this function divides the 2 hexadecimal strings
     * it converts the hex strings to decimals
     * then perform the arithmatic operation on the decimals
     * and finally converts the resultant decimal to hexadecimal string and returns
     * it
     */
    String divide(String hex1, String hex2) {
        String result = null;
        try {
            int dec1 = hexToDecimal(hex1);
            int dec2 = hexToDecimal(hex2);
            if (dec2 == 0) {
                throw new ArithmeticException("Cannot divide by Zero!!\n");
            }
            if(dec1%dec2 != 0) {
                throw new ArithmeticException("Result must be an Integer!!\n");
            }
            int decResult = dec1 / dec2;
            result = decimalToHex(decResult);
        } catch(Exception e) {
            System.out.println("Error in dividing Hexadecimal Strings: " + e.getMessage());
        }
        return result;
    }

    /*
     * this function compares the 2 hexadecimal strings
     * it converts the hex strings to decimals
     * then perform the comparison operation on the decimals
     * and finally converts the resultant decimal to hexadecimal string and returns
     * it
     */
    Boolean equal(String hex1, String hex2) {
        if (hex1 == hex2) {
            return true;
        }
        return false;
    }

    /*
     * this function compares the 2 hexadecimal strings
     * it converts the hex strings to decimals
     * then perform the comparison operation on the decimals
     * and finally converts the resultant decimal to hexadecimal string and returns
     * it
     */
    Boolean greaterThan(String hex1, String hex2) {
        int dec1 = hexToDecimal(hex1);
        int dec2 = hexToDecimal(hex2);
        if (dec1 > dec2) {
            return true;
        }
        return false;
    }

    /*
     * this function compares the 2 hexadecimal strings
     * it converts the hex strings to decimals
     * then perform the comparison operation on the decimals
     * and finally converts the resultant decimal to hexadecimal string and returns
     * it
     */
    Boolean lessThan(String hex1, String hex2) {
        int dec1 = hexToDecimal(hex1);
        int dec2 = hexToDecimal(hex2);
        if (dec1 < dec2) {
            return true;
        }
        return false;
    }
}

public class StaticCheckingAndCodeReview1 {
    public static void main(String[] args) {
        HexCalc calculator = new HexCalc();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "Choose an option: \n1. Addition\n2. Subtraction\n3. Multiplication\n4. Divition\n5. Equals\n6. Greater\n7. Lesser\n8. Convert HexaDecimal to Decimal\n9. Convert Decimal to HexaDecimal\n0. Exit");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Exiting.......\n");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter the first HexaDecimal String: ");
                    String hex1 = sc.next();
                    System.out.println("Enter the Second HexaDecimal String: ");
                    String hex2 = sc.next();

                    System.out.println("The sum of " + hex1 + " and " + hex2 + " is: " + calculator.add(hex1, hex2));
                    break;

                case 2:
                    System.out.println("Enter the first HexaDecimal String: ");
                    hex1 = sc.next();
                    System.out.println("Enter the Second HexaDecimal String: ");
                    hex2 = sc.next();

                    System.out.println("The difference of " + hex1 + " and " + hex2 + " is: " + calculator.subtract(hex1, hex2));
                    break;

                case 3:
                    System.out.println("Enter the first HexaDecimal String: ");
                    hex1 = sc.next();
                    System.out.println("Enter the Second HexaDecimal String: ");
                    hex2 = sc.next();

                    System.out.println("The product of " + hex1 + " and " + hex2 + " is: " + calculator.multiply(hex1, hex2));
                    break;

                case 4:
                    System.out.println("Enter the first HexaDecimal String: ");
                    hex1 = sc.next();
                    System.out.println("Enter the Second HexaDecimal String: ");
                    hex2 = sc.next();

                    System.out.println("The division of " + hex1 + " and " + hex2 + " is: " + calculator.divide(hex1, hex2));
                    break;

                case 5:
                    System.out.println("Enter the first HexaDecimal String: ");
                    hex1 = sc.next();
                    System.out.println("Enter the Second HexaDecimal String: ");
                    hex2 = sc.next();

                    System.out.println(calculator.equal(hex1, hex2) ? hex1 + " is equal to " + hex2 : hex1 + " is not equal to " + hex2);
                    break;

                case 6:
                    System.out.println("Enter the first HexaDecimal String: ");
                    hex1 = sc.next();
                    System.out.println("Enter the Second HexaDecimal String: ");
                    hex2 = sc.next();

                    System.out.println(calculator.greaterThan(hex1, hex2) ? hex1 + " is greated than " + hex2 : hex1 + " is not greater than " + hex2);
                    break;

                case 7:
                    System.out.println("Enter the first HexaDecimal String: ");
                    hex1 = sc.next();
                    System.out.println("Enter the Second HexaDecimal String: ");
                    hex2 = sc.next();

                    System.out.println(calculator.lessThan(hex1, hex2) ? hex1 + " is less than " + hex2 : hex1 + " is not less than " + hex2);
                    break;

                case 8:
                    System.out.println("Enter the HexaDecimal String: ");
                    hex1 = sc.next();

                    System.out.println("Decimal value of " + hex1 + " is: " + calculator.hexToDecimal(hex1));
                    break;

                case 9:
                    System.out.println("Enter the Decimal positive Integer: ");
                    int val = sc.nextInt();

                    System.out.println("Decimal value of " + val + " is: " + calculator.decimalToHex(val));
                    break;
                    
                default:
                    System.out.println("Enter a valid input!!\n");
                    break;
            }
        }
        sc.close();
    }
}