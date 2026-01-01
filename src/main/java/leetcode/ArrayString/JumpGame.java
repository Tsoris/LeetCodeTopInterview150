package main.java.leetcode.ArrayString;

public class JumpGame {
    /**
     * 9/11/2025
     * LeetCode 55: Jump Game
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

    public static void main(String[] args) {
        int[] set = {2,3,1,1,4};
        JumpGame sol = new JumpGame();
        System.out.println(sol.canJump(set));
    }
}
