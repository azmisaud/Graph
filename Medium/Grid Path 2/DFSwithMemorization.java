class DFSwithMemorization {
    
    private int dfs(int sRow,int sCol,int N,int M,int[][] grid,Integer[][] memo){
        
        if(sRow==N || sCol==M || grid[sRow][sCol]==1)
            return 0;
            
        if(sRow==N-1 && sCol==M-1)
            return 1;
            
        if(memo[sRow][sCol]!=null)
            return memo[sRow][sCol];
        
        int mod = (int) (1e9 + 7);
        
        int rightWays=dfs(sRow,sCol+1,N,M,grid,memo);
        int downWays=dfs(sRow+1,sCol,N,M,grid,memo);
        
        memo[sRow][sCol]=(rightWays+downWays)%mod;
        
        return memo[sRow][sCol];
    }
    public int totalWays(int N, int M, int grid[][]) {
        // Code here
        
        if(grid[0][0]==1)
            return 0;
            
        Integer[][] memo=new Integer[N][M];
        
        return dfs(0,0,N,M,grid,memo);
    }
}
