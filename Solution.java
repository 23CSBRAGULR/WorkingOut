package WorkingOut;
import java.util.Scanner;

public class Solution {

    static String conversions(String str) {
        String result = "";
        char ch;
        for(int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if((ch >=0 && ch <=9) || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                result += ch;
            }
            else {
                continue;
            }
        }
        result = result.toLowerCase();
        return result;
    }

    static boolean isPalindrome(String str) {
        String reversed = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        if(str.equals(reversed)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        System.out.print("Enter the word(s) : ");
        String str = inputs.nextLine();
        String conv = conversions(str);
        boolean isPali = isPalindrome(conv);
        System.out.println(isPali);
        inputs.close();
    }
}