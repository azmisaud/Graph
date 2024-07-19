import java.util.Scanner;

public class StoringTheGraph1 {
    public static void main(String[] args) {
        //For Undirected Graph
        //Number of edges and number of vertices will be given.
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter number of vertices : ");
        int nV=scanner.nextInt();
        System.out.print("Enter number of edges : ");
        int nE= scanner.nextInt();
        //Next the input will be a set of lines with the vertices which are adjacent.
        //The graph will be stored in the form of adjacency matrix.
        //Space complexity will be O(N*N)
        int[][] adjacency=new int[nV+1][nV+1];
        System.out.println("Enter the adjacent vertices for each edge : ");
        for (int i=0;i<nE;i++){
            System.out.print("First : ");
            int f=scanner.nextInt();
            System.out.print("Second : ");
            int s=scanner.nextInt();
            adjacency[f][s]=1;
            adjacency[s][f]=1;
        }
        //Printing the adjacency matrix.
        System.out.println();
        for(int[] j : adjacency){
            for(int x : j){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
