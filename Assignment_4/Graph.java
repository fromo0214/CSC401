import java.util.*;
public class Graph {
    int vertices;
    LinkedList<Edge>[] adjacencyList;

    Graph(int verticies){
        this.vertices = verticies;
        adjacencyList = new LinkedList[verticies];
        //initialize adjacency lists for all the vertices

        for(int i = 0; i < verticies; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }


    public void addEdge(int src, int dst, int weight){
        Edge edge = new Edge(src, dst, weight);
        adjacencyList[src].addFirst(edge);
        //add dst to src because it is an undirected graph
        edge = new Edge(dst, src, weight);
        adjacencyList[dst].addFirst(edge); 
    }

    public boolean checkEdge(int src, int dst){
        LinkedList<Edge> list = adjacencyList[src];
        for(Edge edge: list){
            if(edge.destination == dst){
                return true;
            }
        }
       return false;
    }

    public void printGraph(){
        for(int i = 0; i < vertices; i++){
            LinkedList<Edge> list = adjacencyList[i];
            for(int j = 0; j < list.size(); j++){
                //to avoid printing duplicate edges, only prints edges where the source vertex
                // is less than the destination vertex
                if(i < list.get(j).destination)
                System.out.println("vertex- "+ i+ " is connected to " +list.get(j).destination + " with weight " + list.get(j).weight);
            }
        }
    }
}
