
import java.util.LinkedList;

/**
 *graph class
 */
public class Graph {

    private LinkedList<Integer>[] adjacencyList;
    private int numEdges,numVerticies;
    
    public Graph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];
        this.numVerticies = numVertices;
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void printConnectedComponents(){
        System.out.print("{");
        DepthFirstSearch dfs = new DepthFirstSearch(this, 0);
        System.out.println("}");
        boolean[] visited = dfs.visited;
        for(int i=0; i< visited.length; i++){
            if(!visited[i]){
                System.out.print("{");
                dfs = new DepthFirstSearch(this, i,visited);
                System.out.println("}");
                visited = dfs.visited;
            }
        }
    }


    public int getNumVertices() {
        return adjacencyList.length;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);

        numEdges++;
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (adjacencyList[vertex1].contains(vertex2)) {
            adjacencyList[vertex1].remove((Integer) vertex2);
            adjacencyList[vertex2].remove((Integer) vertex1);

            numEdges--;
        }
    }

    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjacencyList[vertex];
    }
    
    public static Graph defaultGraph() {
        Graph graph = new Graph(9);
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 8);

        return graph;
    }
}
