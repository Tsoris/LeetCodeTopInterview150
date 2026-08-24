package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSums = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int currValue = nums[i];
            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;
            while(leftPointer < rightPointer){
                int currSum = currValue + nums[leftPointer] + nums[rightPointer];
                if (currSum == 0){
                    threeSums.add(new ArrayList<>(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer])));

                    leftPointer++;
                    rightPointer--;

                    while(leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer - 1]){
                        leftPointer ++;
                    }
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer + 1]) {
                        rightPointer --;
                    }
                }
                else if (currSum > 0) {
                    rightPointer --;
                }
                else {
                    leftPointer++;
                }
            }
        }
        return threeSums;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        int[] input = {-1,0,1,2,-1,-4};

        //initial runs

        System.out.println(sol.threeSum(input));
    }
}
