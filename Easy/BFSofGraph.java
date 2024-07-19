class BFSofGraph {
    
    // Function to return Breadth First Traversal of given graph
    //The starting point is considered as 0
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] visited=new boolean[V];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int node=queue.poll();
            bfs.add(node);
            visited[node]=true;
            for(int x : adj.get(node)){
                if(!visited[x]){
                    visited[x]=true;
                    queue.add(x);
                }
            }
        }
        return bfs;
    }
}
