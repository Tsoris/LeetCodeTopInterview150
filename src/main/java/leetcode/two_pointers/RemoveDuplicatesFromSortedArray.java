package main.java.leetcode.two_pointers;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    /**
     * 8/27/2025
     * LeetCode 26: Remove Duplicates from Sorted Array
     *
     * Given:
     * - sorted array, nums
     * - remove duplicates in-place
     *      - each unique number shows up once
     *      - order of each unique number should be kept the same
     * Return:
     * - number of unique elements
     *---------------------------------------------------------------------------
     * initial thoughts:
     * - two-pointer &/or sliding window
     * - maybe use a hashmap or  hashset
     *      - determine if the variable has been seen
     *      - caveat(s):
     *          - extra space: O(n)
     *          - can probably just use a counter variable***
     * - steps:
     *      - 3 pointers
     *          - first object i (i = 0)
     *          - next object j (i + 1)
     *          - last index k
     *      - compare the first object i to the next object j
     *          if they are unique, slide i to j
     *          if they are not unique, increment i and j by 1
     *              increment until j is on a unique number then switch values at index i and j
     *                  also increment j if the current value is less than the value at i
     *---------------------------------------------------------------------------
     * optimal solution:
     *  - two-pointers
     *      - slow and fast pointer
     *          - slow pointer i = 0; moves when a different int is found; then the value at this index gets replaced by the new int
     *          - fast pointer j = 1; moves though iterating through a for loop
     *
     *  - ensure that unique ints are in order, everything after is irrelevant
     *  -
     */
    public int initial(int[] nums) {
        int i = 0;
        int j = 1;
        int uniqueElements = 1;
        //not correct stopping point, oob error occurs
        while(i < nums.length - 1) {
            if(nums[i] >= nums[j]) {
                j++;
            } else {
                i++;
                int curr = nums[i];
                nums[i] = nums[j];
                nums[j] = curr;
                j = i + 1;
                uniqueElements++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return uniqueElements;
    }

    public int optimal(int[] nums) {
        int i = 0;
        int counter = 1;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                counter ++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return counter;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();
        int attempt = sol.optimal(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(attempt);
    }
}
