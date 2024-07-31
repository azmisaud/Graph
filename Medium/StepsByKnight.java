class Triplet{
    int row;
    int col;
    int steps;
    
    public Triplet(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
class StepsByKnight
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        
        if(KnightPos[0]==TargetPos[0] && KnightPos[1]==TargetPos[1]) 
            return 0;
            
        
        int[] delRow={-2,-2,2,2,-1,-1,1,1};
        int[] delCol={-1,1,-1,1,-2,2,-2,2};
        
        boolean[][] visited=new boolean[N+1][N+1];
        
        int sRow=KnightPos[0];
        int sCol=KnightPos[1];
        
        int dRow=TargetPos[0];
        int dCol=TargetPos[1];
        
        Queue<Triplet> queue=new LinkedList<>();
        queue.add(new Triplet(sRow,sCol,0));
        
        visited[sRow][sCol]=true;
        
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            int steps=queue.peek().steps;
            
            queue.poll();
            
            for(int i=0;i<8;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                
                if(nRow>=1 && nRow<=N && nCol>=1 && nCol<=N && !visited[nRow][nCol]){
                    visited[nRow][nCol]=true;
                    if(nRow==dRow && nCol==dCol) return steps+1;
                    queue.add(new Triplet(nRow,nCol,steps+1));
                }
            }
        }
        
        return -1;
    }
}
