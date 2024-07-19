class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited=new boolean[V];
        ArrayList<Integer> df=new ArrayList<>();
        dfs(0,visited,adj,df);
        return df;
    }
    public void dfs(int startingNode, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> df){
      
        visited[startingNode]=true;
        df.add(startingNode);
      
        for(int x : adj.get(startingNode)){
            if(!visited[x]){
                dfs(x,visited,adj,df);
            }
        }
    }
}
