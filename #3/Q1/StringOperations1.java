import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Operations {
    /**
     * this function logs errors in error.txt file
     * @param e exception
     */
    private void logError(Exception e) {
        try(FileWriter fw = new FileWriter("error.txt", true)) {
            fw.write(e.getMessage() + "\n");
        } catch(IOException ioException) {
            System.out.println("Failed to log the error!!");
        }
    }

    /**
     * checks if the two strings are equal or not
     * @param str1 first string
     * @param str2 second string
     * @return 1 if strings are equal and 0 if not equal
     */
    int equalStrings(String str1, String str2) {
        try {
            if(str1.length() != str2.length()) {
                return 0;
            }
            for(int index=0; index<str1.length(); index++) {
                if(str1.charAt(index) != str2.charAt(index)) {
                    return 0;
                }
            }
            return 1;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * reverse the gien string
     * @param str input string
     * @return reversed string
     */
    String reverseString(String str) {
        try {
            char[] charArr = str.toCharArray();
            for(int index=0; index<str.length()/2; index++) {
                char temp = charArr[index];
                charArr[index] = charArr[str.length()-index-1];
                charArr[str.length()-index-1] = temp;
            }
            return new String(charArr);
        } catch(Exception e) {
            logError(e);
            return "Error in reversing string!!";
        }
    }

    /**
     * converts uppercase to lowercase and vice versa
     * @param str input string
     * @return string with swapped case
     */
    String replaceCase(String str) {
        try {
            System.out.println("input string: "+ str);
            char[] charArr = str.toCharArray();
            for(int index=0; index<charArr.length; index++) {
                if(charArr[index] >= 'a' && charArr[index] <= 'z'){
                    charArr[index] = (char)(charArr[index]-32);
                } else if(charArr[index] >= 'A' && charArr[index] <= 'Z') {
                    charArr[index] = (char)(charArr[index]+32);
                }
            }
            return new String(charArr);
        } catch(Exception e) {
            logError(e);
            return "Error in replacing case!!";
        }
    }

    /**
     * finds the largest word in the string
     * @param str input string
     * @return largest word
     */
    String largestWord(String str) {
        try {
            String[] words = str.split(" ");
            String largest = "";
            for(String word : words) {
                if(word.length() >= largest.length()) {
                    largest = word;
                }
            }
            return largest;
        } catch(Exception e) {
            logError(e);
            return "Error in finding the largest word!!";
        }
    }
}

public class StringOperations1 {
    static String string;
    static Scanner sc = new Scanner(System.in);

    /**
     * takes user input for string
     */
    static void takeInput() {
        System.out.println("Enter the string: ");
        string = sc.nextLine();
    }
    public static void main(String[] args) {
        Operations obj = new Operations();

        while(true) {
            System.out.println("Enter your choice: \n1. Check Equal\n2. Reverse String\n3. Replace Uppercase to Lowercase and vice-versa\n4. Largest Word\n5. Use another String\n0. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) {
                System.out.println("Exiting...........\n");
                break;
            }

            String str1;
            if(choice == 1) {
                System.out.println("Enter the first String: ");
                str1 = sc.nextLine();
                string = str1;
                System.out.println("Enter the second String: ");
                String str2 = sc.nextLine();
                System.out.println("Result: " + obj.equalStrings(str1, str2));
                continue;
            }

            if(choice != 5) {
                System.out.println("Do you want to use the previous String? (1/0)");
                int usePrev = sc.nextInt();
                sc.nextLine();
                System.out.println("useprev: " + usePrev + " String: " + string);
                if(usePrev == 1 && string != null) {
                    str1= string;
                } else {
                    System.out.println("Enter the String: ");
                    str1 = sc.nextLine();
                    string = str1;
                }
            } else {
                takeInput();
                continue;
            }

            switch(choice) {
                case 2:
                    System.out.println("Reversed String: " + obj.reverseString(str1));
                    break;

                case 3:
                    System.out.println("New String: " + obj.replaceCase(str1));
                    break;

                case 4:
                    System.out.println("Largest Word: " + obj.largestWord(str1));
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