package leetcode.arraystring;

public class GasStation {
    /**
     * LeetCode 134: Gas Station
     *  Givens:
     *      - n gas stations around a circular route
     *      - gas[i] - amount of gas at ith station
     *      - cost[i] - cost to travel from ith station to ith + 1 station
     *      - find which index we can start from to make one clockwise circuit or return -1
     *      - guaranteed unique solutions if they exist
     *---------------------------------------------------------------------------------------------------
     *  Notes:
     *      - Greedy
     *      - able to determine if the trip is possible [is this needed?]
     *          - calculate gas total and cost total
     *              - if the cost of the trip is greater than the gas available return -1
     *      - how to iterate?
     *          - solutions of index > 0 will need to loop around
     *      - brute force:
     *          - keep track of fuel
     *              - currFuel = 0
     *          - create a variable that represents the current stations being tracked
     *              - currrStation = 0
     *          - for loop that iterates by n (if a current station finishes the loop, it has visited all stations)
     *              - currFuel = currFuel + gas[currStation]
     *              -
     *
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) return -1;

        int start = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}
