package main.java.leetcode.current_problems;

import java.util.HashMap;

public class MajorityElement {
    /**
     * 9/4/2025
     * LeetCode 169: Majority Element
     *  - majority element the element that appears more than n/2 times
     *  - majority element guaranteed
     *
     *  initial:
     *      find threshold nums.length/2
     *      iterate through the array and add elements and count to a hashmap
     *      check count with each addition
     *      if element count is greater than threshold return element
     *
     *      Time Complexity : O(n)
     *      Space Complexity : 0(n)
     *
     *  optimized:
     *      Used cleaner methods to populate and manipulate hashmap(getOrDefault)
     *      Bypass nums check and return nums[0] at the end
     *      Time Complexity : O(n)
     *      Space Complexity : 0(n)
     *
     *  optimal solution:
     *  Boyer-Moore Majority Vote
     *      When Count = 0, set candidate = x
     *      check next numbers if == count++ if != count --
     *  no need to verify that candidate is greater than nums.length/2; majority element guaranteed
     *
     *  Time Complexity : O(n)
     *  Space Complexity : O(1) - no extra space
     */

    public int initial(int[] nums) {
        if(nums.length < 2) {
            return nums[0];
        }
        int threshold = nums.length/2;
        HashMap<Integer, Integer> elementCounter = new HashMap<>();

        for (int num : nums) {
            if (!elementCounter.containsKey(num)) {
                elementCounter.put(num, 1);
            } else {
                elementCounter.put(num, elementCounter.get(num) + 1);
                if (elementCounter.get(num) > threshold) {
                    return num;
                }
            }
        }

        return 0;
    }

    public int optimized(int[] nums) {
        int threshold = nums.length >>> 1;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num: nums) {
            int curr = freq.getOrDefault(num, 0) + 1;
            if (curr > threshold) return num;
            freq.put(num, curr);
        }
        return nums[0];
    }

    public int optimal(int[] nums) {
        int candidate = 0, count = 0;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement();
        int[] set_1 = {3,2,3};
        int attempt = sol.initial(set_1);
        System.out.println(attempt);

        int attempt_Optimized = sol.optimized(set_1);
        System.out.println(attempt_Optimized);

        int attempt_Optimal = sol.optimal(set_1);
        System.out.println(attempt_Optimal);
    }
}
