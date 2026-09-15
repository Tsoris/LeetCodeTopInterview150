package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    /**
     * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
     * If there is no future day for which this is possible, keep answer[i] == 0 instead.
     *
     *
     *
     * Example 1:
     *
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     * Example 2:
     *
     * Input: temperatures = [30,40,50,60]
     * Output: [1,1,1,0]
     * Example 3:
     *
     * Input: temperatures = [30,60,90]
     * Output: [1,1,0]
     *
     *
     * Constraints:
     *
     * 1 <= temperatures.length <= 10^5
     * 30 <= temperatures[i] <= 100
     */

    public int[] dailyTemperatures(int[] temperatures) {
        // Maybe we can start from the back??
        // Monotonic Stack - stack that moves in one direction
        //      useful pattern for keeping track/counting of the next biggest/smallest value
        // we add tuples to the stack (temp value, index)
        //      the index is enough to persists and reference the actual temperatures

        int[] result = new int[temperatures.length];

        Deque<Integer> monoTemps = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i ++) {
            while (!monoTemps.isEmpty() && temperatures[monoTemps.peek()] < temperatures[i]){
                int prevColderDay = monoTemps.pop();
                result[prevColderDay] = i - prevColderDay;
            }
            monoTemps.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();

        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

    }

}
