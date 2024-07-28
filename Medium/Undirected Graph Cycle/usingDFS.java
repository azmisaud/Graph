class usingDFS {

  private boolean DFS(int source,int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
    visited[source]=true;

    for(int adjNode : adj.get(source)) {
      if(!visited[adjNode]){
        if(DFS(adjNode,source,adj,visited))
          return true;
      }
      else if (adjNode != parent) 
        return true;
    }

    return false;
  }

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] visited=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(DFS(i,-1,adj,visited))
                    return true;
            }
        }
        
        return false;
    }
}
}
