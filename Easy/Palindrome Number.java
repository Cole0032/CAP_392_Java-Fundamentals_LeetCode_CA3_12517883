//an integer x, return true if x is a palindrome, and false otherwise.

 
class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers cannot be palindromes (e.g., -121 -> 121-).
        // Numbers ending in 0 (except 0 itself) cannot be palindromes (e.g., 10 -> 01).
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Process digits until we reach or pass the midpoint of x
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + (x % 10);
            x /= 10;
        }

        // When the length is even, x == reversedHalf (e.g., 1221 -> x = 12, reversedHalf = 12).
        // When the length is odd, the middle digit can be ignored via reversedHalf / 10 
        // (e.g., 12321 -> x = 12, reversedHalf = 123 -> 123 / 10 = 12).
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
