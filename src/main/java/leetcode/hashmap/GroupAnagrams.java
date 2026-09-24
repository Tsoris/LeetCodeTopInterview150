package leetcode.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *
     *
     * Example 1:
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     *
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * Explanation:
     *
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
     * Example 2:
     *
     * Input: strs = [""]
     *
     * Output: [[""]]
     *
     * Example 3:
     *
     * Input: strs = ["a"]
     *
     * Output: [["a"]]
     *
     * Constraints:
     *      - 1 <= strs.length <= 10^4
     *      - 0 <= strs[i].length <= 100
     *      - strs[i] consists of lowercase English letters.
     */

    // Time: O(n^2 * (k + 1)); Auxiliary space: O(n), excluding O(n) output references.
    // n = string count, k = maximum length; validated array and fixed 26-letter counters.
    public List<List<String>> initialGroupAnagrams(String[] strs) {
        /**
         * Determine whether two strings are anagrams:
         *  1. If their lengths differ, return false.
         *  2. Build a HashMap containing each character's frequency in the first string.
         *  3. Iterate through the second string:
         *      - If the character is absent or its remaining count is 0, return false.
         *      - Otherwise, decrement its count.
         *  4. Return true.
         *
         * Because the strings have equal lengths, successfully consuming every character
         * in the second string means every frequency matches.
         */

        /**
         * Possible brute force approach.
         *      double for loop solution where we compare a string with every other string
         *          can use the above or similar method to validate if anagram
         *
         *      need to mark if an index is determined to be an anagram to the current comparing value to prevent unnecessary rechecks
         *
         *
         *
         */

        ArrayList<List<String>> result = new ArrayList<>();
        boolean[] validated = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (!validated[i]) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);

                for (int j = i + 1; j < strs.length; j++) {
                    if (initialGroupAnagramsHelper(strs[i], strs[j])) {
                        anagrams.add(strs[j]);
                        validated[j] = true;
                    }
                }

                result.add(anagrams);
            }
        }

        // Worst-case time: O(n^2 * (k + 26)), where n is the number of strings
        // and k is the maximum string length. There can be 10,000 strings,
        // each up to 100 characters, so prefer optimizedGroupAnagrams at scale.

        return result;
    }

    // Time: O(k + 1); Auxiliary space: O(1).
    // k = common string length; unequal lengths return immediately; 26 counters.
    private boolean initialGroupAnagramsHelper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a'] ++;
            charCount[t.charAt(i) - 'a'] --;
        }

        for (int val: charCount) {
            if (val != 0){
                return false;
            }
        }

        // time complexity: O(n)
        return true;
    }

    // Time: O(n * (k + 1)) expected; Auxiliary space: O(n + k), excluding O(n) output references.
    // n = string count, k = maximum length; keys use 26 fixed-width int counts; toCharArray allocates O(k).
    public List<List<String>> optimizedGroupAnagrams(String[] strs) {
        // When items need to be grouped, consider a HashMap: use a shared property
        // as the key and collect matching items in a list. Here, that property is character frequency.
        // O(n * (k + 26)) time: count each string and build a 26-entry key.
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            int[] charFreq = new int[26];

            for (char curr : str.toCharArray()) {
                charFreq[curr - 'a']++;
            }

            String key = Arrays.toString(charFreq);

            List<String> group = groups.getOrDefault(key, new ArrayList<>());
            group.add(str);
            groups.put(key, group);

            //groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }


        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args){
        GroupAnagrams sol = new GroupAnagrams();
        String[] rating = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(sol.initialGroupAnagrams(rating));

        System.out.println(sol.optimizedGroupAnagrams(rating));
    }

}
