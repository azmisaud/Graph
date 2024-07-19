import java.util.ArrayList;
import java.util.Scanner;

public class StoringTheDirectedGraph {
    public static void main(String[] args) {
        //For Undirected Graph
        //Number of edges and number of vertices will be given.
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter number of vertices : ");
        int nV=scanner.nextInt();
        System.out.print("Enter number of edges : ");
        int nE= scanner.nextInt();
        //Next the input will be a set of lines with the vertices which are adjacent.
        //The graph will be stored in the form of adjacency list.
        //Space complexity will be O(Number of edges) [near about]
        ArrayList<ArrayList<Integer>> adjacency=new ArrayList<>();
        for(int i=0;i<=nV;i++){
            adjacency.add(i,new ArrayList<>());
        }
        System.out.println("Enter the adjacent vertices for each edge(in the order of direction) : ");
        for (int i=0;i<=nV;i++){
            System.out.print("First : ");
            int f=scanner.nextInt();
            System.out.print("Second : ");
            int s=scanner.nextInt();
            adjacency.get(f).add(s);
        }
        //print all the edges
        System.out.println(adjacency);
    }
}
