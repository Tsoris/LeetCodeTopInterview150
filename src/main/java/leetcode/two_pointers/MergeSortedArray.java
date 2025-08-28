package main.java.leetcode.two_pointers;

import java.util.Arrays;

public class MergeSortedArray{

    /**
     * LeetCode 88: Merge Sorted Array
     * Givens:
     * - two sorted int arrays, nums1 and nums2, and their valid lengths
     * - nums 1 has a length of m+n, with extra space/placeholders at the end to hold nums 2
     * - merge nums2 into nums 1 as one sorted array (non-decreasing order)
     * ----------------------------------------------------------------------------------------
     * Initial Idea:
     * - given sizes of both arrays; m & n
     *  - can create a new array to represent viable elements in first array; m
     *  - steps :
     *      iterate through array 1
     *      ->1 pointer at new array and 1 pointer on second array
     *      ->compare values to determine which value to insert in current array 1 index
     *      ->increment pointer related to selected array
     *  - caveat(s):
     *      - requires O(m) extra space
     * - Time Complexity: O(m+n)
     * - Space Complexity: O(m)
     * ----------------------------------------------------------------------------------------
     * Optimal:
     * - Use two pointers from the end of nums1 (i = m-1) and nums2 (j = n-1)
     * - Place the larger of nums1[i] or nums2[j] at the end of nums 1 (k = m + n - 1)
     * - Decrement pointers accordingly until nums2 is exhausted.
     *      - once nums2 is exhausted, given the parameters - sorted arrays -, the rest of nums1 will be sorted
     * - nums1 has enough trailing space to accommondate nums2.
     * - Time Complexity: O(m+n)
     * - Space Complexity: O(1)
     */
    public void initial(int[] nums1, int m, int[] nums2, int n) {
        int[] mArray = new int[m];
        for (int i = 0; i < m; i++) {
            mArray[i] = nums1[i];
        }
        int pointerM = 0;
        int pointerN = 0;

        for (int i = 0; i < m + n; i++) {
            int currM = Integer.MAX_VALUE;
            int currN = Integer.MAX_VALUE;

            if(pointerM < m) {
                currM = mArray[pointerM];
            }
            if(pointerN < n) {
                currN = nums2[pointerN];
            }

            if(currM >= currN && pointerN < n) {
                nums1[i] = currN;
                pointerN++;
            } else if(currM < currN && pointerM < m) {
                nums1[i] = currM;
                pointerM++;
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    public void optimal(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0){
            if(i >=0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        MergeSortedArray sol = new MergeSortedArray();
        sol.initial(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        sol.initial(new int[]{1}, 1, new int[]{}, 0);
        sol.initial(new int[]{0}, 0, new int[]{1}, 1);
        sol.optimal(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        sol.optimal(new int[]{1}, 1, new int[]{}, 0);
        sol.optimal(new int[]{0}, 0, new int[]{1}, 1);
    }
}
