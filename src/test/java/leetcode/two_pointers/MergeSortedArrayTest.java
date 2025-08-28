package test.java.leetcode.two_pointers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import main.java.leetcode.two_pointers.MergeSortedArray;
import org.junit.jupiter.api.Test;

public class MergeSortedArrayTest {
    @Test
    public void optimal_twoArraysSameSize_printsSortedArray(){
        MergeSortedArray sol = new MergeSortedArray();
        int[]nums1 = {1,2,3,0,0,0};
        int[]nums2 = {2,5,6};
        sol.optimal(nums1, 3, nums2, 3);

        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
    }

    @Test
    public void optimal_nums1IsEmpty_printsSortedArray(){
        MergeSortedArray sol = new MergeSortedArray();
        int[]nums1 = {0};
        int[]nums2 = {1};
        sol.optimal(nums1, 0, nums2, 1);

        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void optimal_nums2IsEmpty_printsSortedArray(){
        MergeSortedArray sol = new MergeSortedArray();
        int[]nums1 = {1};
        int[]nums2 = {};
        sol.optimal(nums1, 1, nums2, 0);

        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void initial_twoArraysSameSize_printsSortedArray(){
        MergeSortedArray sol = new MergeSortedArray();
        int[]nums1 = {1,2,3,0,0,0};
        int[]nums2 = {2,5,6};
        sol.initial(nums1, 3, nums2, 3);

        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
    }

    @Test
    public void initial_nums1IsEmpty_printsSortedArray(){
        MergeSortedArray sol = new MergeSortedArray();
        int[]nums1 = {0};
        int[]nums2 = {1};
        sol.initial(nums1, 0, nums2, 1);

        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void initial_nums2IsEmpty_printsSortedArray(){
        MergeSortedArray sol = new MergeSortedArray();
        int[]nums1 = {1};
        int[]nums2 = {};
        sol.initial(nums1, 1, nums2, 0);

        assertArrayEquals(new int[]{1}, nums1);
    }
}
