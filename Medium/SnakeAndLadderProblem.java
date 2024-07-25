class Pair {
    int position;
    int steps;
    
    public Pair(int position,int steps){
        this.position=position;
        this.steps=steps;
    }
}
class SnakeAndLadderProblem{
    static int minThrow(int N, int arr[]){
        // code here
        int[] board=new int[31];
        boolean[] visited=new boolean[31];
        
        for(int i=0;i<31;i++)
            board[i]=i;
            
        for(int i=0;i<2*N-1;i+=2)
            board[arr[i]]=arr[i+1];
        
        int[] dice={1,2,3,4,5,6};
        
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(1,0));
        
        visited[1]=true;
        
        while(!queue.isEmpty()) {
            int position=queue.peek().position;
            int steps=queue.peek().steps;
            
            queue.poll();
            
            for(int i=0;i<6;i++){
                int newPosition=position+dice[i];
                
                if(newPosition==30) return steps+1;
                
                if(!visited[newPosition]){
                    visited[newPosition]=true;
                    queue.add(new Pair(board[newPosition],steps+1));
                }
            }
        }
        
        return -1;
    }
}
