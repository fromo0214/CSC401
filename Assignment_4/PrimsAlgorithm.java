import java.util.*;
import java.util.ArrayList;

public class PrimsAlgorithm{
    //number of nodes/vertices in the graph;
    static int n = 4;
    
    public static List<Edge> Prims(Graph graph){
       List<Edge> mst = new ArrayList<>();
       boolean[] visited = new boolean[n];
       int totalWeight = 0;
       int startingVertex = 0;

       visited[startingVertex] = true;
        //this integer makes sure that the edges are less than 1 to the nodes
        //to ensure the spanning tree is complete; number of edges in MST
      
        while(!allVerticesVisited(visited)){
            Edge edge = findMinimumEdgeThatConnectsVisitedToUnvisited(visited, graph);
            mst.add(edge);
            totalWeight += edge.weight;

            visited[edge.destination] = true;
        }
        System.out.println("Total sum of the Minimum Spanning Tree: " + totalWeight);
        return mst;
    }


    private static Edge findMinimumEdgeThatConnectsVisitedToUnvisited(boolean[] visited, Graph graph) {
        Edge minEdge = null;
        int minWeight = Integer.MAX_VALUE;

        for(int i = 0; i < graph.vertices; i++){
            if(visited[i]){
                for(Edge edge : graph.adjacencyList[i]){
                    if(!visited[edge.destination] && edge.weight < minWeight){
                        minEdge = edge;
                        minWeight = edge.weight;
                    }
                }
            }
        }
        return minEdge;   
    }


    private static boolean allVerticesVisited(boolean[] visited) {
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(n);

        graph.addEdge(0, 1, 9);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 3, 9);
        graph.addEdge(0, 3, 4);
        graph.addEdge(0, 2, 3);

        List<Edge> minimumSpanningTree = Prims(graph);
        
        System.out.println("Minimum Spanning Tree Edges: ");
        for(Edge edge : minimumSpanningTree){
            System.out.println("Vertex " + edge.source + " - Vertex " + edge.destination +
            " (Weight " + edge.weight + ")");
        }

        
    }
}