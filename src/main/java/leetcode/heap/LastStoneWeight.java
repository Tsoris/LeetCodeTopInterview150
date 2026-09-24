package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    // Time: O(n log n); Auxiliary space: O(n).
    // n = stones.length; repeated heap offers, then each smash reduces heap size.
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int weights : stones) {
            stoneQueue.offer(weights);
        }

        while (stoneQueue.size() > 1) {
            int heaviestStone = stoneQueue.poll();
            int nextHeaviestStone = stoneQueue.poll();

            if (heaviestStone != nextHeaviestStone) {
                stoneQueue.add(heaviestStone - nextHeaviestStone);
            }
        }

        return stoneQueue.isEmpty() ? 0 : stoneQueue.poll();
    }
}
