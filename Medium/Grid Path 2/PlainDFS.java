class Solution {
    //Time Limit Exceeded
    static int dfs(int sRow,int sCol,int[][] grid,boolean[] visited){
        
        int n=grid.length;
        int m=grid[0].length;
        
        int node=sRow*m+sCol;
        
        visited[node]=true;
        
        int count=0;
        
        if(sRow==n-1 && sCol==m-1 && grid[sRow][sCol]==0){
            count++;
            visited[sRow*m+sCol]=false;
            return count;
        }
        
        
        int[] delRow={0,1};
        int[] delCol={1,0};
        
        for(int i=0;i<2;i++){
            int nRow=sRow+delRow[i];
            int nCol=sCol+delCol[i];
            
            if(nRow<n && nCol<m && grid[nRow][nCol]==0){
                count+=dfs(nRow,nCol,grid,visited);
            }
        }
        
        visited[sRow*m+sCol]=false;
        return count;
    }
    public int totalWays(int N, int M, int grid[][]) {
        if(grid[0][0]==1) return 0;
        
        boolean[] visited=new boolean[N*M];
        
        return dfs(0,0,grid,visited);
    }
}
