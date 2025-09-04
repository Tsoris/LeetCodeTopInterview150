package main.java.leetcode.current_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RotateArray {
    /**
     * 9/2/2025
     * LeetCode 189: Rotate Array
     * rotate nums[] to the right k times
     *
     * Challenges :
     *  in-place with O(1) space complexity
     *
     * initial (28:06.64 minutes):
     *      Use a hashmap to keep track of index and value @ index
     *
     * revised:
     *      determine edge cases and return
     *          nums.length =< 1
     *          k % nums.length == 0
     *
     *      create and populate hashmap
     *      for loop by nums.length
     *          determine rotate index = i+k % n
     *              can be used whether i + k is greater than nums.length or not
     *          set values at nums[rotate index] to current value of loop of HashMap
     *  optimal(reverse)
     *      array[] example = {1,2,3,4,5,6,7,}; k = 3
     *      reverse entire array; example = {7,6,5,4,3,2,1}
     *      reverse array from start to k element (k-1); example = {5,6,7,4,3,2,1}
     *          restores order of this block; negative  * negative = positive
     *      reverse rest of the array (k to nums.length - 1); example = {5,6,7,1,2,3,4}
     *          same concept as before
     */

    public void initial(int[] nums, int k) {
        HashMap<Integer, Integer> index_value = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            index_value.put(i, nums[i]);
        }
        index_value.forEach((index, value) -> {
            int rotateValue = index + k;
            if (rotateValue < nums.length) {
                nums[rotateValue] = value;
            } else {
                nums[rotateValue % nums.length] = value;
            }
        });
    }

    public void revise(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return;

        k %= n;
        if (k == 0) return;

        Map<Integer, Integer> index_value = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            index_value.put(i, nums[i]);
        }

        for(int i = 0; i < n; i++) {
            int target = (i + k) % n;
            nums[target] = index_value.get(i);
        }
    }

    public void optimal_reverse(int[] nums, int k) {
        int length = nums.length;

        if(length == 1) return;
        k %= length;

        if(k%length == 0) return;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        RotateArray sol = new RotateArray();
        int[] set_1 = {1,2,3,4,5,6,7};
        int[] set_2 = {-1};
        int[] set_3 = {1,2};

        int[] set_1_reverse = {1,2,3,4,5,6,7};
        int[] set_2_reverse = {-1};
        int[] set_3_reverse = {1,2};

        //initial runs
        sol.initial(set_1, 3);
        System.out.println(Arrays.toString(set_1));

        sol.initial(set_2, 3);
        System.out.println(Arrays.toString(set_2));

        sol.initial(set_3, 7);
        System.out.println(Arrays.toString(set_3));

        //optimal reverse runs
        sol.optimal_reverse(set_1_reverse, 3);
        System.out.println(Arrays.toString(set_1_reverse));

        sol.optimal_reverse(set_2_reverse, 3);
        System.out.println(Arrays.toString(set_2_reverse));

        sol.optimal_reverse(set_3_reverse, 7);
        System.out.println(Arrays.toString(set_3_reverse));
    }
}
