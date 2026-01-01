package main.java.leetcode.ArrayString;

import java.util.Arrays;

public class HIndex {
    /**
     * H-index - maximum value of h such that h papers have been cited h times
     *
     * initialSort:
     *      sort the array
     *      iterate each index until the index matches the remaining number of papers
     *          there will be at least n papers with a score of n
     *          Time Complexity: O(nlogn)
     *          Space Complexity: O(1)
     * bucket:
     *      create frequency array[n+1] of the number of papers with n citations
     *          when a paper with this x number of citations if seen add 1 to that index
     *          if the number of citations exceeds the number of papers "Clamp" them the largest Index
     *      scan downward on the frequency array
     *          keep track of the number of papers seen
     *          when the number of papers match or exceeds the index return index (i)
     *              indicates there are at least i number of papers with i citations
     *              Time Complexity: 0(n)
     *              Space Complexity: O(n) - extra space
     */

    public int initialSort(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            int currPaperICitation = citations.length - i;
            if(citations[i]>=currPaperICitation) {
                return currPaperICitation;
            }
        }
        return 0;
    }

    public int initialFrequency(int[] citations) {
        int n = citations.length;

        int[] frequency = new int[n + 1];
        for(int citation : citations) {
            if(citation >= n) {
                frequency[n]++;
            } else {
                frequency[citation]++;
            }
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count+=frequency[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        HIndex sol = new HIndex();
        int[] set = {3,0,6,1,5};
        int[] set2 = {1,3,1};
        int[] set3 = {1,1,2,3};

        System.out.println(sol.initialSort(set));
        System.out.println(sol.initialSort(set2));
        System.out.println(sol.initialSort(set3));

        System.out.println(sol.initialFrequency(set));
        System.out.println(sol.initialFrequency(set2));
        System.out.println(sol.initialFrequency(set3));
    }
}
