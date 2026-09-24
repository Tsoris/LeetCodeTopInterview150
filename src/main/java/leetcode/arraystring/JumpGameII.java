package leetcode.arraystring;

public class JumpGameII {
    /**
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
     *
     * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
     *
     * 0 <= j <= nums[i] and
     * i + j < n
     */

    // Time: O(n); Auxiliary space: O(1).
    // n = nums.length; unfinished attempt returns zero after a scan.
    public int sol(int[] nums) {
        int furthest = 0;
        int jumps = 0;
        for(int i = 0; i < nums.length; i++) {
            int currJump = i + nums[i];
            furthest = Math.max(currJump, furthest);
            if(i == furthest) {
                jumps++;
            }
            if (furthest > nums.length){
                jumps++;
                break;
            }
        }

        return 0;
    }

    // Time: O(n); Auxiliary space: O(1).
    // n = nums.length; one forward scan.
    public int optimal(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int furthest = 0;
        int currEnd = 0;

        for (int i = 0; i<nums.length - 1; i++) {
            int currDistance = nums[i] + i;
            furthest = Math.max(furthest, currDistance);

            if (i == currEnd){
                jumps ++;
                currEnd = furthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII sol = new JumpGameII();

        int[] set = {2,3,1,1,4};
        int[] set2 = {1,5,2};

        System.out.println(sol.optimal(set));
        System.out.println(sol.optimal(set2));

    }
}
