package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Solution1 {


    public static int myAtoi(String s) {
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j < numbers.length; j++) {
                if (s.charAt(i) == numbers[j])
                    sum = sum * 10 + Character.getNumericValue(numbers[j]);
            }
        }
        return sum;
    }

    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num/2; i++) {
            if (num % i == 0)
                sum += i;
        }
        return num == sum;
    }

    public static void reverseString(char[] s) {
        String[] arr = new String[s.length];
        int index = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            arr[index] = Character.toString(s[i]);
            index++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static boolean isPowerOfTwo(int n) {
        boolean checked = false;
        for (int i = 0; i < Math.sqrt(n) + 1; i++) {
            if (Math.pow(2, i) == n) {
                checked = true;
                break;
            }
        }
        return checked;
    }

    public int finalPositionOfSnake(int n, List<String> commands) {

        int row = 0, col = 0;

        for (String command : commands) {
            switch (command) {
                case "UP":
                    row -= 1;
                    break;
                case "DOWN":
                    row -= 1;
                    break;
                case "LEFT":
                    col -= 1;
                    break;
                case "RIGHT":
                    col -= 1;
                    break;
            }
        }

        return row * n + col;
    }

    public static String restoreString(String s, int[] indices) {
        char[] shuffled = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            shuffled[indices[i]] = s.charAt(i);
        }
        return new String(shuffled);
    }


    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return -1;
        }
        for (int i = 0; i <= needle.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int climbStairs(int n) {
        int allAttempts = 0;

        return allAttempts;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            arr[i + nums.length] = nums[i];
        }
        return arr;
    }

    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] dslafk = {{1, 2}, {2, 1}};
        return dslafk;
    }

    public static int triangleSol(int x) {
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum = sum + (2 * i + 1);
        }
        sum += x;
        sum += x * 2;


        return sum + 1;
    }

    public static int[] getSneakyNumbers(int[] nums) {
        int[] newArray = new int[2];

        int n = 0;
        for (int i = 0; i < nums.length && n < 2; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count += 1;
                }
            }
            if (count >= 2) {
                boolean alreadyAdded = false;
                for (int k = 0; k < n; k++) {
                    if (newArray[k] == nums[i]) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    newArray[n] = nums[i];
                    n += 1;
                }
            }
        }
        return newArray;
    }

    public static int[] removeDuplicates(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int duplicateCounter = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    duplicateCounter += 1;
                }
            }
            if (duplicateCounter >= 2) {
                arr[i] = nums[i];
            }
        }
        return arr;
    }

    public static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public static int reverse(int x) {
        int reversedInt = 0;
        while (x % 10 != 0 || x / 10 != 0) {
            int checkedValue = x % 10;
            x /= 10;
            if (reversedInt > Integer.MAX_VALUE / 10 || (reversedInt == Integer.MAX_VALUE / 10 && checkedValue > 7)) {
                return 0;
            }
            if (reversedInt < Integer.MIN_VALUE / 10 || (reversedInt == Integer.MIN_VALUE / 10 && checkedValue < -8)) {
                return 0;
            }


            reversedInt = reversedInt * 10 + checkedValue;

        }
        return reversedInt;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String substring = s.substring(i, j);
                String reverseSubstring = new StringBuilder(substring).reverse().toString();
                if (substring.equals(reverseSubstring) && substring.length() > result.length()) {
                    result = substring;

                }
            }
        }
        return result.isEmpty() ? "not palindrome" : result;

    }


    public static int[] plusOne(int[] digits) {
        for (int i = digits.length; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] end = new int[digits.length + 1];
        end[0] = 1;
        return end;
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 1) {
            return 1;
        }
        int lengthOfLastWord = 0;
        for (int i = s.length(); i > 1; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else lengthOfLastWord += 1;
        }
        return lengthOfLastWord;
    }

    public static boolean isValid(String s) {
        char[] arr = new char[s.length()];
        boolean trust = false;
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    trust = true;
                } else if (arr[i] != arr[j])
                    trust = false;
            }
        }
        return trust;
    }

    public static void main(String[] args) {
        String n = "1337c0d3";
        System.out.println(myAtoi(n));

    }
}

