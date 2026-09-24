package leetcode.arraystring;

public class Candy {
    /**
     * There are n children standing in a line.
     *
     * Each child is assigned a rating value given in the integer array ratings.
     *
     * You are giving candies to these children subjected to the following requirements:
     *      Each child must have at least one candy.
     *      Children with a higher rating get more candies than their neighbors.
     *
     * Return the minimum number of candies you need to have to distribute the candies to the children.
     *
     *
     *
     * Example 1:
     *
     * Input: ratings = [1,0,2]
     * Output: 5
     * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
     * Example 2:
     *
     * Input: ratings = [1,2,2]
     * Output: 4
     * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
     * The third child gets 1 candy because it satisfies the above two conditions.
     *
     *
     * Constraints:
     *
     * 1 <= n == ratings.length <= 5 * 104
     * 0 <= ratings[i] <= 5 * 104
     */

    // Time: O(1); Auxiliary space: O(1).
    // Unfinished constant-return stub, not a completed solution.
    public int candy(int[] ratings) {
        //each child gets at least 1 candy
        // [1, 3, 4, 2]

        return 0;
    }

    public static void main(String[] args){
        Candy sol = new Candy();
        int[] rating = {1, 0, 2};

        System.out.println(sol.candy(rating));
    }
}
