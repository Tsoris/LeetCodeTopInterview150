package main.java.leetcode.current_problems;


import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    /**
     * 9/3/2025
     * LeetCode 80: Remove Duplicates from Sorted Array II
     * Given:
     *  array nums; non-decreasing order
     *  unique elements can appear TWICE
     *
     *  initial approach:
     *      start at index 0 and compare to the next index
     *
     * Optimal solution:
     *
     */

    public int initial(int[] nums) {
        int i = 0;
        int uniqueCount;
        int currCount;

        for(int j = 1; j< nums.length; j++) {

        }
        return 0;
    }

    public int optimal(int[] nums) {
        if (nums.length < 3) return nums.length;

        int currValidIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[currValidIndex-2]){
                nums[currValidIndex] = nums[i];
                currValidIndex++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return currValidIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII sol = new RemoveDuplicatesFromSortedArrayII();
        int attempt = sol.optimal(new int[]{1,1,1,2,2,3});
        System.out.println(attempt);
    }
}
