package leetcode.twopointers;

public class ContainerWithMostWater {
    /**
     *You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     *
     * Example 1:
     *
     *
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     *
     * Example 2:
     *
     * Input: height = [1,1]
     * Output: 1
     *
     *
     * Constraints:
     *
     * n == height.length
     * 2 <= n <= 10^5
     * 0 <= height[i] <= 10^4
     */

    /**
     * Too slow to pass LeetCode test
     */
    public int initialMaxArea(int[] height) {
        //Area is calculated by using the min height of the 2 walls multiplied by the distance between them
        //can use 2 pointers to move the walls
            // left and right pointer
                // when to increment left pointer??? brute force would be to just try every single combo right? can try that

        int maxArea = 0;
        for (int left = 0; left < height.length -1; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int minHeight = Math.min(height[left], height[right]);
                maxArea = Math.max(minHeight * (right - left), maxArea);
            }
        }
        return maxArea;
    }

    public int optimizeInitialMaxArea(int[] height) {
        //Area is calculated by using the min height of the 2 walls multiplied by the distance between them
        //can use 2 pointers to move the walls
        // left and right pointer
        // when to increment left pointer??? we can try to move it when a forward value is greater than the current left, this would be greedy

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(currHeight * (right - left), maxArea);

            if (height[right] > height[left]) {
                left ++;
            } else {
                right --;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();

        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1, 1};
        int[] height3 = {1, 2, 1};

        System.out.println(sol.initialMaxArea(height));
        System.out.println(sol.initialMaxArea(height2));
        System.out.println(sol.initialMaxArea(height3));

        System.out.println(sol.optimizeInitialMaxArea(height));
        System.out.println(sol.optimizeInitialMaxArea(height2));
        System.out.println(sol.optimizeInitialMaxArea(height3));
    }
}
