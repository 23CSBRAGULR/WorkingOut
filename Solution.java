package WorkingOut;

import java.util.Scanner;

public class Solution {

    static String conversions(String str) {
        StringBuilder result = new StringBuilder();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) { // includes both letters and digits
                result.append(Character.toLowerCase(ch));
            }
        }
        return result.toString();
    }

    static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
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