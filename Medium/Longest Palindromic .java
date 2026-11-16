/*
Longest Palindrome in the given array
*/

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindrome (center is s[i])
            int len1 = expandAroundCenter(s, i, i);
            // Case 2: Even-length palindrome (center is between s[i] and s[i + 1])
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            // If a longer palindrome is found, update the boundary indices
            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Length of valid palindrome found between (left + 1) and (right - 1)
        return right - left - 1;
    }
}
