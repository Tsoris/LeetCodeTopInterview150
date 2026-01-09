package main.java.leetcode.ArrayString;

public class JumpGame {
    /**
     * 9/11/2025
     * LeetCode 55: Jump Game
     *      - given an int array nums - each value is the max jump distance from that spot[index]
     *      - start at the first index
     *      - return true if you can reach the last index, false if not
     *----------------------------------------------------------------------------------------------------------
     * Notes:
     *      - Topics:
     *              - array
     *              - dynamic programming
     *              - greedy
     *      - Can start from the last index [solution steps]
     *          - determine if that index can be reached
     *              - look at the previous index, and determine if there is enough jumps to make it to the final index
     *              - continue until an index can make it to the final index
     *              - update that index to currentIndex to be reached
     *              - continue until index 0 is reached and verified that it can reach the previous designated index
     *                  - return true
     *
     *
     */

    public boolean canJump(int[] nums) {
        int currSpot = nums.length - 1;
        int i = currSpot - 1;
        while (i >= 0){
            if(nums[i] + i >= currSpot) {
                currSpot = i;
                if(i == 0) {
                    return true;
                }
            }
            i--;
        }
        return false;
    }

    public boolean canJumpFor(int[]nums) {
        int currSpot = nums.length - 1;
        for (int i = currSpot - 1; i >= 0; i--) {
            if(nums[i] + i >= currSpot) {
                currSpot = i;
                if(i == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] set = {2,3,1,1,4};
        JumpGame sol = new JumpGame();
        System.out.println(sol.canJumpFor(set));
    }
}
