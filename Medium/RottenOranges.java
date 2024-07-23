class Triplet {
    int row;
    int col;
    int time;
    
    public Triplet(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class RottenOranges
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        
        Queue<Triplet> queue=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        
        int countFresh=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    queue.add(new Triplet(i,j,0));
                }
                if(grid[i][j]==1)
                    countFresh++;
            }
        }
        
        int count=0;
        int minTime=0;
        
        while(!queue.isEmpty()){
            
            int row=queue.peek().row;
            int col=queue.peek().col;
            minTime=queue.peek().time;
            
            queue.poll();
            
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && !visited[nRow][nCol]){
                    visited[nRow][nCol]=true;
                    queue.add(new Triplet(nRow,nCol,minTime+1));
                    count++;
                }
            }
        }
        
        if(count!=countFresh) return -1;
        return minTime;
    }
}
