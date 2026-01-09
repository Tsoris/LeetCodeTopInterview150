package main.java.leetcode.ArrayString;

public class ProductofArrayExceptSelf {
    /**
     * LeetCode 238: Product of Array Except Self
     * Givens:
     *  - takes in an int array of nums
     *  - returns an array where each index is the product of all the values nums excluding the current index
     *  - solution must run in 0(n) time
     *  - no using division
     *  --------------------------------------------------------------------------------------------------------------------
     * Hints:
     *  - Think how you can efficiently utilize prefix and suffix products to calculate the product of all elements except self for each index.
     *     Can you pre-compute the prefix and suffix products in linear time to avoid redundant calculations?
     *
     *  - Can you minimize additional space usage by reusing memory or modifying the input array to store intermediate results?
     *  -----------------------------------------------------------------------------------------------------------------------------------------
     * Solution 1 (2 arrays): prefix + suffix arrays
     * Steps:
     *      1) Create two arrays leftSide and rightSide of length nums.length.
     *
     *      2) Build leftSide (product of all elements strictly left of i):
     *          leftSide[0] = 1
     *          for i = 1..n-1:
     *              leftSide[i] = leftSide[i-1] * nums[i-1]
     *          Example nums=[1,2,3,4] → leftSide=[1,1,2,6]
     *
     *      3) Build rightSide (product of all elements strictly right of i):
     *          rightSide[n-1] = 1
     *          for i = n-2..0:
     *              rightSide[i] = rightSide[i+1] * nums[i+1]
     *          Example nums=[1,2,3,4] → rightSide=[24,12,4,1]
     *
     *      4) Answer:
     *          ans[i] = leftSide[i] * rightSide[i]
     *
     * Trade-off: O(n) extra space.
     *
     * --------------------------------------------------------------------------------------------------------------------------------------------------------
     Solution 2 (O(1) extra space): output array + running suffix product
        Steps:
            1) Create ans array of length nums.length.

            2) Prefix pass (store prefix products in ans):
            ans[0] = 1
            for i = 1..n-1:
                ans[i] = ans[i-1] * nums[i-1]

            3) Suffix pass (multiply by suffix product on the fly):
            suffixProduct = 1
            for i = n-1..0:
                ans[i] *= suffixProduct
            suffixProduct *= nums[i]
     * --------------------------------------------------------------------------------------------------------------------------------------------------------
     * notes:
     *      - Prefix and suffix product problem
     *          - prefix sum alternative
     */
    public int[] productExceptSelf2Arrays(int[] nums){
        int numsLength  = nums.length;
        int[] leftSideProducts = new int[numsLength];
        int[] rightSideProducts = new int[numsLength];

        leftSideProducts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftSideProducts[i] = leftSideProducts[i - 1] * nums[i - 1];
        }

        rightSideProducts[numsLength - 1] = 1;
        for (int i = numsLength - 2; i >= 0; i --) {
            rightSideProducts[i] = rightSideProducts[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < numsLength; i++) {
            leftSideProducts[i] = leftSideProducts[i] * rightSideProducts[i];
        }

        return leftSideProducts;
    }

    public int[] productExceptSelf(int[] nums) {
        int nums_length = nums.length;
        int[] solution = new int[nums_length];

        //prefix pass
        solution[0] = 1;
        for (int i = 1; i < nums_length; i++) {
           solution[i] = solution[i - 1] * nums[i - 1];
        }

        //suffix pass
        int suffix = 1;
        for (int i = nums_length - 1; i >= 0; i--) {
            solution[i] = solution[i] * suffix;
            suffix *= nums[i];
        }
        return solution;
    }
 }
