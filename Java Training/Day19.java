import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day19 {
    static class Edge {
        int end;
        int weight;

        Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class GraphList
    {
        static List<List<Integer>> graph;
        static boolean[] visited;
        static int totalVertices;
        static boolean directed;

        public static void addEdge(int start, int end)
        {
            graph.get(start).add(end);

        }

        public static void dfsSearch(int current)
        {
            visited[current] = true;
            System.out.println(current + " ");
            for (int neighbor : graph.get(current))
            {
                if (!visited[neighbor])
                {
                    dfsSearch(neighbor);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of vertices ");
        int totalVertices = input.nextInt();

        System.out.println("Is the graph directed? ");
        boolean directed = input.nextBoolean();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<totalVertices;i++)
        {
            graph.add(new ArrayList<>());
        }
        System.out.print("Enter number of edges: ");
        int totalEdges = input.nextInt();

        System.out.println("Enter edges (start end): ");
        for(int i = 0;i<totalEdges;i++)
        {
            int start = input.nextInt();
            int end = input.nextInt();
            addEdge(start,end);
        }
        visited = new boolean[totalVertices];

        System.out.println("\n DFS Traversal");
        for(int vertex = 0;vertex<totalVertices;vertex++)
        {
            if(!visited[vertex])
            {
                dfsSearch(vertex);
            }
        }
    }
}
