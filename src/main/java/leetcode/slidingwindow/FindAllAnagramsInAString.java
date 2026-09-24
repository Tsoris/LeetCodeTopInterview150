package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    /**
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "cbaebabacd", p = "abc"
     * Output: [0,6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     *
     * Input: s = "abab", p = "ab"
     * Output: [0,1,2]
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     *
     *
     * Constraints:
     *
     * 1 <= s.length, p.length <= 3 * 10^4
     * s and p consist of lowercase English letters.
     */

    // Recount each candidate window: O(s.length() * p.length()) time and O(p.length()) auxiliary space.
    // Time: O(m + max(0, n - m + 1) * m); Auxiliary space: O(m), excluding O(r) output.
    // n = s.length(), m = p.length(), r = matches; copies and recounts each window.
    public List<Integer> initialFindAnagrams(String s, String p) {
        ArrayList<Integer> indices = new ArrayList<>();

        int[] charFrequency = new int[26];
        for (char curr : p.toCharArray()) {
            charFrequency[curr - 'a'] ++;
        }

        String key = Arrays.toString(charFrequency);

        int left = 0;

        for (int right = p.length(); right <= s.length(); right++) {
            int[] subCharFrequency = new int[26];
            String currSub = s.substring(left, right);
            for (char curr : currSub.toCharArray()) {
                subCharFrequency[curr - 'a'] ++;
            }
            String subKey = Arrays.toString(subCharFrequency);
            if (key.equals(subKey)) {
                indices.add(left);
            }
            left++;
        }
        return indices;
    }

    // Maintain pattern counts minus window counts; all zeros means an anagram.
    // O(s.length() + p.length()) time; p.toCharArray() adds O(p.length()) auxiliary space.
    // Time: O(n + m); Auxiliary space: O(m), excluding O(r) output.
    // n = s.length(), m = p.length(), r = matches; counters use O(1), but p.toCharArray() allocates O(m).
    public List<Integer> optimizeFindAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> indices = new ArrayList<>();

        int[] charFrequency = new int[26];
        for (char curr : p.toCharArray()) {
            charFrequency[curr - 'a'] ++;
        }


        for (int i = 0; i < p.length(); i ++) {
            charFrequency[s.charAt(i) - 'a'] --;
        }

        boolean isValid = true;
        for (int count: charFrequency) {
            if (count != 0) {
                isValid = false;
            }
        }

        if (isValid) {
            indices.add(0);
        }

        int left = 0;

        for (int right = p.length(); right < s.length(); right++) {
            //keep added and removed characters mechanics consistent
                //characters being now considered are decremented
                //characters no longer being considered are incremented
            charFrequency[s.charAt(right) - 'a'] --;
            charFrequency[s.charAt(left) - 'a'] ++;

            isValid = true;
            for (int count: charFrequency) {
                if (count != 0) {
                    isValid = false;
                }
            }

            if (isValid) {
                indices.add(left + 1);
            }
            left ++;
        }


        return indices;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString sol = new FindAllAnagramsInAString();

        System.out.println(sol.initialFindAnagrams("cbaebabacd", "abc"));
        System.out.println(sol.initialFindAnagrams("abab", "ab"));

        System.out.println(sol.optimizeFindAnagrams("cbaebabacd", "abc"));
        System.out.println(sol.optimizeFindAnagrams("abab", "ab"));
        System.out.println(sol.optimizeFindAnagrams("baa", "aa"));
    }
}
