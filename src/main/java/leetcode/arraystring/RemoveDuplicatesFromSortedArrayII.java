package leetcode.arraystring;


import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    /**
     * 9/3/2025
     *
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

    // Time: O(n); Auxiliary space: O(1).
    // n = nums.length; unfinished empty-loop attempt, measured at source level.
    public int initial(int[] nums) {
        int i = 0;
        int uniqueCount;
        int currCount;

        for(int j = 1; j< nums.length; j++) {

        }
        return 0;
    }

    // Time: O(n); Auxiliary space: O(n) including debug formatting.
    // n = nums.length; compaction alone uses O(1); Arrays.toString creates O(n) temporary storage.
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
