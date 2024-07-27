class Pair {
    int node;
    int parent;
    
    public Pair(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}
class usingBFS {
    // Function to detect cycle in an undirected graph.
    
    private boolean BFS(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[source]=true;
        
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(source,-1));
        
        while(!queue.isEmpty()) {
            int node=queue.peek().node;
            int parent=queue.peek().parent;
            
            queue.poll();
            
            for(int adjNode : adj.get(node)){
                if(!visited[adjNode]){
                    visited[adjNode]=true;
                    queue.add(new Pair(adjNode,node));
                }
                else if (parent!=adjNode)
                    return true;
            }
        }
        
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] visited=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(BFS(i,adj,visited))
                    return true;
            }
        }
        
        return false;
    }
}
