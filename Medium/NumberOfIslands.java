class Pair {
    int row;
    int col;
    
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class NumberOfIslands {
    // Function to find the number of islands.
    
    private void bfs(int r,int c,boolean[][] visited,char[][] grid){
        int[] delRow={-1, 1, 0, 0, -1, -1, 1, 1};
        int[] delCol={0, 0, -1, 1, -1, 1, -1, 1};
        
        int n=grid.length;
        int m=grid[0].length;
        
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(r,c));
        
        visited[r][c]=true;
        
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            
            queue.poll();
            
            for(int i=0;i<8;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && grid[nRow][nCol]=='1'){
                    visited[nRow][nCol]=true;
                    queue.add(new Pair(nRow,nCol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] visited=new boolean[n][m];
        
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    bfs(i,j,visited,grid);
                }
            }
        }
        
        return count;
    }
}
