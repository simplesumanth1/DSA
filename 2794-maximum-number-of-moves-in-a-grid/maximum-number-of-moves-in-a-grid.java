class Solution {
    public int f(int row, int col, int currRow, int currCol, int[] drow, int n, int m, int[][] grid, int[][] dp) {
        // If out of bounds, return 0 as no moves can be made
        if (row < 0 || row >= n || col < 0 || col >= m) return 0;
        
        // If we have already computed the max moves from this cell, return the cached result
        if (dp[row][col] != -1) return dp[row][col];
        
        int maxMoves = 0;
        // Try moving in the three possible directions
        for (int i = 0; i < 3; i++) {
            int steps = 0;
            int nrow = row + drow[i];
            int ncol = col + 1;
            
            // Check if the next cell is within bounds and has a larger value
            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] > grid[currRow][currCol]) {
                steps = 1 + f(nrow, ncol, nrow, ncol, drow, n, m, grid, dp);
            }
            maxMoves = Math.max(maxMoves, steps);
        }
        
        // Store the result in dp array before returning
        return dp[row][col] = maxMoves;
    }

    public int maxMoves(int[][] grid) {
        int[] drow = {-1, 0, 1};
        int n = grid.length;
        int m = grid[0].length;
        
        // Initialize dp array with -1 (indicating uncomputed cells)
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        
        int max = 0;
        // Start from each cell in the first column
        for (int i = 0; i < n; i++) {
            int ans = f(i, 0, i, 0, drow, n, m, grid, dp);
            max = Math.max(max, ans);
        }
        
        return max;
    }
}
