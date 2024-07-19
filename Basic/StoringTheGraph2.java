import java.util.ArrayList;
import java.util.Scanner;

public class StoringTheGraph2 {
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
        //Space complexity will be O(2*Number of edges) [near about]
        ArrayList<ArrayList<Integer>> adjacency=new ArrayList<>();
        for(int i=0;i<=nV;i++){
            adjacency.add(i,new ArrayList<>());
        }
        System.out.println("Enter the adjacent vertices for each edge : ");
        for (int i=0;i<=nV;i++){
            System.out.print("First : ");
            int f=scanner.nextInt();
            System.out.print("Second : ");
            int s=scanner.nextInt();
            adjacency.get(f).add(s);
            adjacency.get(s).add(f);
        }
        //print all the edges
        System.out.println(adjacency);

        //if it is directed graph, we will remove adjacency.get(s).add(f) from the loop.

    }
}
