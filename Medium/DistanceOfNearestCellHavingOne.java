class Tuple {
    int row;
    int col;
    int near;
    
    public Tuple(int row,int col,int near){
        this.row=row;
        this.col=col;
        this.near=near;
    }
}
class DistanceOfNearestCellHavingOne
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] result=new int[n][m];
        
        Queue<Tuple> queue=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) {
                    result[i][j]=0;
                    queue.add(new Tuple(i,j,0));
                }
            }
        }
        
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            int near=queue.peek().near;
            
            queue.poll();
            
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && result[nRow][nCol]==0 && grid[nRow][nCol]==0){
                    result[nRow][nCol]=near+1;
                    queue.add(new Tuple(nRow,nCol,near+1));
                }
            }
        }
        
        return result;
    }
}
