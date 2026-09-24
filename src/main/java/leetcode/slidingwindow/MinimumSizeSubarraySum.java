package leetcode.slidingwindow;

public class MinimumSizeSubarraySum {
    // Time: O(n); Auxiliary space: O(1).
    // n = nums.length; positive values let both endpoints move only forward.
    public int minSubArrayLen(int target, int[] nums) {

        /**
         * we can start with 2 pointers
        1 on the first index 1 on the second index
        if the value is greater than or equal to the target
            we can reduce the number of values by incrementing the left pointer
         if the value is less than the target
            we can increase the number of values by incrementing the right pointer

         what if 1 value is greater than or equal to the target?
            that would mean both pointers are on the same index, which we can allow
            use a conditional if left == right and currspot is greater than or equal to target
                we can just return 1 then, nothing is going to beat that
            we can let the indices match but don't let the left go past the right

         how do we know when to stop?
         if the right index is greater than the size and the target has not been reached
         when else do we stop?
            when left is greater than right?
                shouldn't happen because that would be the case where there's an index greater than or equal to the target [handled already]
         **/
        int minSubArrayLength = Integer.MAX_VALUE;
        int leftPointer = 0;
        int rightPointer = 0;
        int currValue = nums[leftPointer];

        while(rightPointer < nums.length) {
            if (currValue >= target) {
                minSubArrayLength = Math.min(minSubArrayLength, rightPointer - leftPointer + 1);
                currValue = currValue - nums[leftPointer];
                leftPointer ++;
            }
            else {
                rightPointer++;
                if (rightPointer < nums.length) {
                    currValue = currValue + nums[rightPointer];
                }
            }
        }

        return (minSubArrayLength == Integer.MAX_VALUE) ? 0 : minSubArrayLength;
    }

    public static void main(String[] args){
        MinimumSizeSubarraySum sol = new MinimumSizeSubarraySum();

        int[] nums = {10,2,3};

        System.out.println(sol.minSubArrayLen(6, nums));
    }
}
