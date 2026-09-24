package leetcode.heap;

import java.util.*;

public class KthLargestElementInAnArray {
    // Time: O(n log n + k log n) = O(n log n); Auxiliary space: O(n).
    // n = nums.length; n individual max-heap insertions then k removals (1 <= k <= n).
    public int maxHeapFindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> numPrioQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            numPrioQueue.offer(num);
        }

        int currNum = numPrioQueue.poll();

        for (int i = 1; i < k; i++) {
            currNum = numPrioQueue.poll();
        }

        return currNum;
    }

    // Time: O(n log k); Auxiliary space: O(k).
    // n = nums.length; the min-heap retains only the k largest values seen.
    public int minHeapFindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    // Expected time: O(n); Worst-case time: O(n^2).
    // Expected auxiliary space: O(n); Worst-case auxiliary space: O(n^2).
    // Copies the input into lists; randomized partitions may recurse O(n) levels in the worst case.
    public int quickSelectFindKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }


        return quickSelect(numList, k);
    }

    // Expected time: O(n); Worst-case time: O(n^2); Auxiliary space: O(n) expected, O(n^2) worst case.
    // Partition lists from active recursive calls can coexist until recursion unwinds.
    private int quickSelect(List<Integer> numList, int k) {
        if (numList.size() == 1) {
            return numList.get(0);
        }

        int listIndex = new Random().nextInt(numList.size());
        int pivot = numList.get(listIndex);

        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int num : numList) {
            if (pivot > num) {
                less.add(num);
            } else if(pivot == num) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        // k = 2
        //organize lists like:
        //  greater -> equal -> less

        //kth element is somewhere in greater; no offset needed
        if (greater.size() >= k) {
            return quickSelect(greater, k);
        }
        //kth element is somewhere in less; offset to determine the place in less
        else if (k > greater.size() + equal.size()) {
            return quickSelect(less, k - greater.size() - equal.size());
        }
        //kth element is the pivot
        else {
            return pivot;
        }
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray sol = new KthLargestElementInAnArray();

        int[] nums = {3, 2, 1, 5, 6, 4};

        System.out.println(sol.minHeapFindKthLargest(nums, 2));

    }

}
