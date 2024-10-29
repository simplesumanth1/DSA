import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int row, col, move;
        
        public Pair(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }
    
    public int maxMoves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        // Initialize queue with all cells in the first column
        for (int i = 0; i < n; i++) {
            q.offer(new Pair(i, 0, 0));
        }
        
        int[] drow = {-1, 0, 1}; // Directions for rows (top-right, right, bottom-right)
        int[] dcol = {1, 1, 1};  // Directions for columns (always rightwards)
        int maxMove = 0;
        
        boolean[][] visited = new boolean[n][m];
        
        // BFS traversal
        while (!q.isEmpty()) {
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            int move = top.move;
            
            // Track the maximum moves
            maxMove = Math.max(maxMove, move);
            
            for (int i = 0; i < 3; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                
                // Check if the next cell is valid and hasn't been visited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                    grid[nrow][ncol] > grid[row][col] && !visited[nrow][ncol]) {
                    
                    visited[nrow][ncol] = true;  // Mark as visited
                    q.offer(new Pair(nrow, ncol, move + 1));
                }
            }
        }
        
        return maxMove;
    }
}
