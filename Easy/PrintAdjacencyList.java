class PrintAdjacencyList {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
      
        List<List<Integer>> adjacencyList=new ArrayList<>();
      
        for(int i=0;i<V;i++) adjacencyList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }
        return adjacencyList;
    }
}

//Import the classes when you are using it in your IDE
