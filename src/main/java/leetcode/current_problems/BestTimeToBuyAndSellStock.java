package main.java.leetcode.current_problems;

public class BestTimeToBuyAndSellStock {
    /**
     * 9/4/2025
     * LeetCode 121: Best Time To Buy and Sell Stock
     *     Array that contains price of stock on that day
     *     return max profit; or 0 if no profit can be made
     *     buy stock 1 day and sell at a future day; must buy before you can sell
     *
     *  Initial:
     *      (15:35.53 minutes)
     *      set a variable max
     *      brute force:
     *          two pointer,
     *              compare value curr to subsequent values
     *              if prices[curr] < prices[subsequent], calculate profit
     *              compare calculated to max variable
     *  runtime timeout with large inputs
     *  Time Complexity O(N^2)
     *
     * Optimal:
     *      can only sell after you buy; moves in one direction
     *          keep track of the lowest buy price, and check what you could sell it for
     *              if profits are greater than curr max_profit, then update max_profit
     *
     */
    public int initial(int[] prices){
        if (prices.length < 2) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int buy = prices[i];
            for(int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                if (buy < sell) {
                    int currProfit = sell - buy;
                    if (currProfit > max) {
                        max = currProfit;
                    }
                }
            }
        }
        return max;
    }

    public int optimal(int[] prices) {
        int currBuy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int currPrice : prices) {
            currBuy = Math.min(currBuy, currPrice);
            maxProfit = Math.max(maxProfit, currPrice - currBuy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int[] prices_2 = {7,6,4,3,1};
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();
        System.out.println(sol.initial(prices));
        System.out.println(sol.initial(prices_2));

        System.out.println(sol.optimal(prices));
        System.out.println(sol.optimal(prices_2));
    }
}
