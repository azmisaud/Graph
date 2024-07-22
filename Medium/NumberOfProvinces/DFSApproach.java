class DFSApproach {

// Method to convert adjacency matrix into adjacency list.
static ArrayList<ArrayList<Integer>> convertMatrixToList(ArrayList<ArrayList<Integer>> adjacencyMatrix, int V) {
  ArrayList<ArrayList<Integer>> adjacencyList=new ArrayList<>();

  // Considering the graph to be 0-based indexed.

  for(int i=0;i<V;i++)
    adjacencyList.add(new ArrayList<>());

  for(int i=0;i<V;i++) {
    for(int j=0;j<V;j++) {
      if(adjacencyMatrix.get(i).get(j)==1 && i!=j) {
        adjacencyList.get(i).add(j);
        adjacencyList.get(j).add(i);
      }
    }
  }

  return adjacencyList;
}

//Using DFS to find the connected component, 1 connected component=1 province

static void dfs(int startingNode, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList) {
  visited[startingNode]=true;

  for(int i : adjacencyList.get(i)) {
    if(!visited[i])
      dfs(i,visited,adjacencyList);
  }
}

//Method to find the number of province

static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
  ArrayList<ArrayList<Integer>> adjacencyList=convertMatrixToList(adj,V);

  int count=0;

  boolean[] visited=new int[V];

  for(int i=0;i<V;i++) {
    if (!visited[i]) {
      count++;
      dfs(i,visited,adjacencyList);
    }
  }
}
