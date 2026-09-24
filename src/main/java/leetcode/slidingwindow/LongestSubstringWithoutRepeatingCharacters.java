package leetcode.slidingwindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given a string s, find the length of the longest substring without duplicate characters.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     *
     * Constraints:
     *
     * 0 <= s.length <= 10^5
     * s consists of English letters, digits, symbols and spaces.
     */


    /**
     * Brute force: start a fresh set at each index and extend until a duplicate.
     * Rechecking overlapping substrings repeats work: O(n^2) time in the worst
     * case, O(min(n, k)) extra space, where k is the number of possible characters.
     * The single-character guard handles the last-start-only case; for longer
     * inputs, the final index can only produce length 1 and cannot improve the best.
     * Empty input naturally returns 0.
     */
    // Time: O(n * min(n, a)) expected, at most O(n^2); Auxiliary space: O(min(n, a)).
    // n = string length, a = alphabet size; restarts a HashSet scan at each position.
    public int initialLengthOfLongestSubString(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int longest = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            HashSet<Character> seen = new HashSet<>();
            int curr = i;

            while (curr < s.length() && !seen.contains(s.charAt(curr))) {
                seen.add(s.charAt(curr));
                curr++;
            }

            longest = Math.max(curr - i, longest);
        }

        return longest;
    }

    /**
     * Sliding window: reuse the set instead of restarting from each index.
     * Before each iteration, seen contains the unique characters in [left, right).
     * If the next character is already present, remove from the left and retry
     * the SAME right index until its earlier occurrence leaves the window.
     * Each character enters and leaves the set at most once: O(n) expected time
     * with HashSet operations, O(min(n, k)) extra space.
     */
    // Time: O(n) expected; Auxiliary space: O(min(n, a)).
    // n = string length, a = alphabet size; each character enters and leaves the HashSet at most once.
    public int optimizedLengthOfLongestSubString(String s) {
        int left = 0;
        int right = 0;

        int longest = 0;

        HashSet<Character> seen = new HashSet<>();
        while (right < s.length()) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                longest = Math.max(right - left + 1, longest);
                right ++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }


        return longest;
    }

    /**
     * Same sliding window, with the right pointer advanced by the for loop.
     * Use while, not if: one removal may not remove the duplicate. For "abba",
     * the second 'b' requires removing both 'a' and the earlier 'b'.
     * After shrinking and adding, [left, right] is duplicate-free, so its length
     * is right - left + 1. Update the best only after restoring that invariant.
     * The nested loop is still O(n) expected time: left only moves forward across
     * the string once. Extra space is O(min(n, k)).
     * Review cases: "" -> 0, "a" -> 1, "bbbbb" -> 1, "abba" -> 2,
     * "abcabcbb" -> 3, and "pwwkew" -> 3. Spaces count as characters too.
     */
    // Time: O(n) expected; Auxiliary space: O(min(n, a)).
    // n = string length, a = alphabet size; each character enters and leaves the HashSet at most once.
    public int cleanedOptimizedLengthOfLongestSubString(String s) {
        int longest = 0;
        int left = 0;

        HashSet<Character> seen = new HashSet<>();

        for(int right = 0; right < s.length(); right++) {
            while(seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left ++;
            }

            seen.add(s.charAt(right));
            longest = Math.max(right - left + 1, longest);

        }

        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(sol.initialLengthOfLongestSubString("abcabcbb"));
        System.out.println(sol.initialLengthOfLongestSubString("bbbbb"));
        System.out.println(sol.initialLengthOfLongestSubString("pwwkew"));

        System.out.println(sol.optimizedLengthOfLongestSubString("pwwkew"));
        System.out.println(sol.optimizedLengthOfLongestSubString("bbbbb"));
        System.out.println(sol.optimizedLengthOfLongestSubString("abcabcbb"));

        System.out.println(sol.optimizedLengthOfLongestSubString("a"));

        System.out.println(sol.optimizedLengthOfLongestSubString(""));

        System.out.println(sol.cleanedOptimizedLengthOfLongestSubString("abcabcbb"));
        System.out.println(sol.cleanedOptimizedLengthOfLongestSubString("a"));
    }
}
