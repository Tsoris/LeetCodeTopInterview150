package leetcode.arraystring;

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
     *          Space Complexity: O(n) worst case for Java sorting; scan alone O(1)
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

    // Time: O(n log n); Auxiliary space: O(n) worst case for Java sorting.
    // n = citations.length; scan uses O(1). See README sorting note. hIndex remains an incorrect attempt.
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

    // Time: O(n); Auxiliary space: O(n).
    // n = citations.length; n + 1 buckets.
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


    /** 8/25/2026
     *  Attempt with prior awareness of a Frequency map implementation
     *  Goal: Derive and build intuition for a frequency map
     *  hint 1: suggested sorting
     */
    // Time: O(n log n); Auxiliary space: O(n) worst case for Java sorting.
    // n = citations.length; scan uses O(1). See README sorting note. hIndex remains an incorrect attempt.
    public int hIndex(int[] citations) {
        // h-index - maximum value of h such that at least h papers have been cited at least h times
        // [3, 0, 6, 1, 5]
        // so this means
        // paper 1 - 3 citations
        // paper 2 - 0 citations
        // paper 3 - 6 citations
        // paper 4 - 1 citation
        // paper 5 - 5 citations
        Arrays.sort(citations);
        // [0, 1, 3, 5, 6] what does this mean?
        // so which paper has which number of citation is irrelevant
        // we can start from the back

        for (int i = citations.length - 1; i >= 0; i--) {
            int numberOfPapers = citations.length - i;
            int currCitations = citations[i];

            if (numberOfPapers >= currCitations) {
                return numberOfPapers;
            }
        }
        // placeholder, reevaluate
        return 0;
    }

    public static void main(String[] args) {
        HIndex sol = new HIndex();
        int[] set = {3,0,6,1,5};
        int[] set2 = {1,3,1};
        int[] set3 = {1,1,2,3};
        int[] set4 = {100};

        System.out.println("Initial Sort Run");
        System.out.println(sol.initialSort(set));
        System.out.println(sol.initialSort(set2));
        System.out.println(sol.initialSort(set3));

        System.out.println("Initial Frequency Run");
        System.out.println(sol.initialFrequency(set));
        System.out.println(sol.initialFrequency(set2));
        System.out.println(sol.initialFrequency(set3));


        System.out.println("HIndex Run");
        System.out.println(sol.hIndex(set));
        System.out.println(sol.hIndex(set2));
        System.out.println(sol.hIndex(set3));
        System.out.println(sol.hIndex(set4));
    }
}
