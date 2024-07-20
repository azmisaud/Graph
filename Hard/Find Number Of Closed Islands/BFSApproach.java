class Pair{
    int row;
    int col;
    
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class BFSApproach
{
    private void BFS(int sRow,int sCol,int N,int M,int[][] matrix,boolean[][] visited){
        
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(sRow,sCol));
        
        visited[sRow][sCol]=true;
        
        
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            
            queue.poll();
            
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                
                if(nRow>=0 && nRow<N && nCol>=0 && nCol<M && !visited[nRow][nCol] && matrix[nRow][nCol]==1){
                    visited[nRow][nCol]=true;
                    queue.add(new Pair(nRow,nCol));
                }
            }
        }
        
    }
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        boolean[][] visited=new boolean[N][M];
        
        for(int j=0;j<M;j++){
            if(matrix[0][j]==1 && !visited[0][j])
                BFS(0,j,N,M,matrix,visited);
                
            if(matrix[N-1][j]==1 && !visited[N-1][j])
                BFS(N-1,j,N,M,matrix,visited);
        }
        
        for(int i=0;i<N;i++){
            if(matrix[i][0]==1 && !visited[i][0])
                BFS(i,0,N,M,matrix,visited);
                
            if(matrix[i][M-1]==1 && !visited[i][M-1])
                BFS(i,M-1,N,M,matrix,visited);
        }
        
        int count=0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                    
                if(!visited[i][j] && matrix[i][j]==1){
                    BFS(i,j,N,M,matrix,visited);
                    count++;
                }
            }
        }
        
        return count;
    }
}
