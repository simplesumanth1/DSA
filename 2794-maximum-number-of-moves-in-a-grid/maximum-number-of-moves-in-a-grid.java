class Solution {
    // class Pair{
    //     int row;
    //     int col;
    //     int move;
    //     public Pair(int row,int col,int move){
    //         this.row = row;
    //         this.col = col;
    //         this.move = move;
    //     }
    // }
    public int f(int row,int col,int currRow,int currCol,int[]drow,int n,int m,int[][]grid,Integer[][]dp){
        if(row<0 || row>=n || col<0 || col>=m)return 0;
        if(dp[row][col]!=null)return dp[row][col];
        int maxMoves = 0;
        for(int i=0;i<3;i++){
            int steps = 0;
            int nrow = row+drow[i];
            int ncol = col+1;
            if( nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]>grid[currRow][currCol]){
                steps = 1+f(nrow,ncol,nrow,ncol,drow,n,m,grid,dp);
            }
            maxMoves = Math.max(maxMoves,steps);
        }
        return dp[row][col]=maxMoves;
        
    }
    public int maxMoves(int[][] grid) {
         int[]drow = {-1,0,1};
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        Integer[][]dp = new Integer[n][m];
        for(int i=0;i<grid.length;i++){
           
            int ans = f(i,0,i,0,drow,grid.length,grid[0].length,grid,dp);
            max = Math.max(max,ans);
        }
        return max;
        
        // Queue<Pair>q = new LinkedList<>();
        // int n = grid.length;
        // int m = grid[0].length;
        // for(int i=0;i<n;i++){
        //     q.offer(new Pair(i,0,0));
        // }
        // int[]drow = {-1,0,1};
        // int[]dcol = {1,1,1};
        // int maxMove = 0;
        // while(!q.isEmpty()){
        //     Pair top = q.poll();
        //     int row = top.row;
        //     int col = top.col;
        //     int move = top.move;
        //     maxMove = Math.max(maxMove,move);
        //     for(int i=0;i<3;i++){
        //         int nrow = row+drow[i];
        //         int ncol = col+dcol[i];
        //         if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]>grid[row][col]){
        //             q.offer(new Pair(nrow,ncol,move+1));
        //         }
        //     }
        // }
        // return maxMove;
        
    }
}