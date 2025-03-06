class HexCalc {
    int hexToDecimal(String hex) {
        int decimal = 0;
        int length = hex.length();
        for(int index=0; index<length; index++) {
            char hexChar = hex.charAt(length-index-1);
            int value;
            if(hexChar >= '0' && hexChar <= '9') {
                value = hexChar - '0';
            } else if(hexChar >= 'A' && hexChar <= 'F'){
                value = hexChar - 'A' + 10;
            } else {
                throw new IllegalArgumentException("Invalid character!\n");
            }
            decimal += value * Math.pow(16, index);
        }
        return decimal;
    }

    String decimalToHex(int decimal) {
        if(decimal < 0) {
            throw new IllegalArgumentException("Only postitive integers!!");
        }

        StringBuilder hex = new StringBuilder();
        while(decimal > 0) {
            int rem = decimal % 16;
            char hexChar;
            if(rem<10) {
                hexChar = (char)('0' + rem);
            } else {
                hexChar = (char)('A' + (rem - 10));
            }
            hex.insert(0,hexChar);
            decimal = decimal / 16;
        }
        return hex.length() > 0 ? hex.toString() : "0";
    }

    String add(String hex1, String hex2) {
        int dec1 = hexToDecimal(hex1);
        int dec2 = hexToDecimal(hex2);
        int decResult = dec1 + dec2;
        String result = decimalToHex(decResult);
        return result;
    }

    String subtract(String hex1, String hex2) {
        int dec1 = hexToDecimal(hex1);
        int dec2 = hexToDecimal(hex2);
        if(dec1 < dec2) {
            return "-ve number can't compute";
        }
        int decResult = dec1 - dec2;
        String result = decimalToHex(decResult);
        return result;
    }

    String multiply(String hex1, String hex2) {
        int dec1 = hexToDecimal(hex1);
        int dec2 = hexToDecimal(hex2);
        int decResult = dec1 * dec2;
        String result = decimalToHex(decResult);
        return result;
    }

    String divide(String hex1, String hex2) {
        int dec1 = hexToDecimal(hex1);
        int dec2 = hexToDecimal(hex2);
        int decResult = dec1 / dec2;
        String result = decimalToHex(decResult);
        return result;
    }

    Boolean equal(String hex1, String hex2) {
        if(hex1 == hex2) {
            return true;
        }
        return false;
    }

    Boolean greaterThan(String hex1, String hex2) {
        int dec1 = hexToDecimal(hex1);
        int dec2 = hexToDecimal(hex2);
        if(dec1 > dec2) {
            return true;
        }
        return false;
    }

    Boolean lessThan(String hex1, String hex2) {
        int dec1 = hexToDecimal(hex1);
        int dec2 = hexToDecimal(hex2);
        if(dec1 < dec2) {
            return true;
        }
        return false;
    }
}

public class StaticCheckingAndCodeReview1 {
    public static void main(String[] args) {
        String hex1 = "1A4";
        String hex2 = "1A3";
        int value = 100;
        HexCalc calculator = new HexCalc();

        System.out.println("Sum of " + hex1 + " and " + hex2 + " is: " + calculator.add(hex1, hex2));
        System.out.println("Difference of " + hex1 + " and " + hex2 + " is: " + calculator.subtract(hex1, hex2));
        System.out.println("Product of " + hex1 + " and " + hex2 + " is: " + calculator.multiply(hex1, hex2));
        System.out.println("Divition of " + hex1 + " and " + hex2 + " is: " + calculator.divide(hex1, hex2));

        System.out.println(calculator.equal(hex1, hex2) ? hex1 + " is equal to " + hex2 : hex1 + " is not equal to " + hex2);
        System.out.println(calculator.greaterThan(hex1, hex2) ? hex1 + " is greater than " + hex2 : hex1 + " is not greater than " + hex2);
        System.out.println(calculator.lessThan(hex1, hex2) ? hex1 + " is less than " + hex2 : hex1 + " is not less than " + hex2);

        System.out.println("Decimal of " + hex1 + " is: " + calculator.hexToDecimal(hex1));

        System.out.println("Hexadecimal of " + value + " is: " + calculator.decimalToHex(value));

    }
}