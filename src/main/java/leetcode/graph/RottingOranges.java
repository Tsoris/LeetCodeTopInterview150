package leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {
    // Time: O(rows * cols); Auxiliary space: O(rows * cols).
    // Every cell is scanned once, and each fresh orange enters the breadth-first queue at most once.
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshCount = 0;

        Deque<int[]> rottenOranges = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.addLast(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    freshCount ++;
                }
            }
        }

        while (!rottenOranges.isEmpty()) {
            int currRotten = rottenOranges.size();
            for (int i = 0; i < currRotten; i++) {
                int[] currLocation = rottenOranges.poll();

                //rot neighbors
                int[][] directions = {
                        {-1, 0},
                        {1, 0},
                        {0, -1},
                        {0, 1}
                };

                for (int[] direction : directions) {
                    int row = currLocation[0] + direction[0];
                    int col = currLocation[1] + direction[1];
                    if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] != 1) {
                        continue;
                    } else {
                        grid[row][col] = 2;
                        freshCount --;
                        rottenOranges.addLast(new int[] {row, col});
                    }
                }

            }
            if (!rottenOranges.isEmpty()) {
                minutes++;
            }
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

    }
}
