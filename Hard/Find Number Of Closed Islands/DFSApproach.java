class DFSApproach
{
    private void DFS(int sRow,int sCol,int N,int M,int[][] matrix,boolean[][] visited){
        visited[sRow][sCol]=true;

        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nRow=sRow+delRow[i];
            int nCol=sCol+delCol[i];

            if(nRow>=0 && nCol>=0 && nRow<N && nCol<M && matrix[nRow][nCol]==1 && !visited[nRow][nCol]){
                DFS(nRow,nCol,N,M,matrix,visited);
            }
        }
    }
    public int closedIslands(int[][] matrix, int N, int M)
    {
        boolean[][] visited = new boolean[N][M];

        int count = 0;

        for(int j=0;j<M;j++){
            if(matrix[0][j]==1 && !visited[0][j])
                DFS(0,j,N,M,matrix,visited);

            if(matrix[N-1][j]==1 && !visited[N-1][j])
                DFS(N-1,j,N,M,matrix,visited);
        }

        for(int i=0;i<N;i++){
            if(matrix[i][0]==1 && !visited[i][0])
                DFS(i,0,N,M,matrix,visited);

            if(matrix[i][M-1]==1 && !visited[i][M-1])
                DFS(i,M-1,N,M,matrix,visited);
        }

        for (int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]==1 && !visited[i][j]){
                    count++;
                    DFS(i,j,N,M,matrix,visited);
                }
            }
        }

        return count;
    }
}
