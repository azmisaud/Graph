import java.util.ArrayList;
import java.util.Scanner;

class Pair{
    int adjacentVertex;
    int weight;
    public Pair(int adjacentVertex,int weight){
        this.adjacentVertex=adjacentVertex;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "(A:"+adjacentVertex+",W:"+weight+")";
    }
}
public class StoringTheWeightedGraph {
    public static void main(String[] args) {
        //nV=5,nE=6
        //1st Edge : (1,2) weight 3
        //2nd Edge : (1,4) weight 4
        //3rd Edge : (2,3) weight 7
        //4th Edge : (3,4) weight 10
        //5th Edge : (4,5) weight 9
        //6th Edge : (3,5) weight 8
        //ArrayList<ArrayList<Pair>> adjacency=new ArrayList<>();
        //for(int i=0;i<=nV;i++) adjacency.add(i,new ArrayList<>());
        //adjacency.get(1).add(new Pair(2,3));
        //adjacency.get(1).add(new Pair(4,4));
        //adjacency.get(2).add(new Pair(3,7));
        //adjacency.get(3).add(new Pair(4,10));
        //adjacency.get(4).add(new Pair(5,9));
        //adjacency.get(3).add(new Pair(5,8));
        //adjacency.get(2).add(new Pair(1,3));
        //adjacency.get(4).add(new Pair(1,4));
        //adjacency.get(3).add(new Pair(2,7));
        //adjacency.get(4).add(new Pair(3,10));
        //adjacency.get(5).add(new Pair(4,9));
        //adjacency.get(5).add(new Pair(3,8));
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int nV=scanner.nextInt();
        System.out.print("Enter the number of edges : ");
        int nE=scanner.nextInt();
        //In weighted graph, we store the adjacent vertex and weight for each vertex in the adjacency list.
        ArrayList<ArrayList<Pair>> adjacency=new ArrayList<>();
        for(int i=0;i<=nV;i++){
            adjacency.add(i,new ArrayList<>());
        }
        System.out.println("Enter the adjacent vertices for each edge and the weight also : ");
        for (int i=0;i<=nV;i++) {
            System.out.print("First : ");
            int f = scanner.nextInt();
            System.out.print("Second : ");
            int s = scanner.nextInt();
            System.out.print("Weight : ");
            int w = scanner.nextInt();
            adjacency.get(f).add(new Pair(s, w));
            adjacency.get(s).add(new Pair(f, w));
        }
        //printing the adjacency list
        System.out.println(adjacency);
    }
}
