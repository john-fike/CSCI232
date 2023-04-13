
import java.util.LinkedList;

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
    //////////////////////////////////////////////////////////////////
    ///////////////////printConnectedComponents///////////////////////
    //call an initial depth search on first vertex
    //grab the visited verticies
    //keep depth searching & updating visited array until all verticies visited
    //////////////////////////////////////////////////////////////////
    public void printConnectedComponents(){
        System.out.print("{");
        DepthFirstSearch dfs = new DepthFirstSearch(this, 0);
        System.out.println("}");
        boolean[] visited = dfs.getVisited();
        for(int i=0; i< visited.length; i++){
            if(!visited[i]){
                System.out.print("{");
                dfs = new DepthFirstSearch(this, i,visited);
                System.out.println("}");
                visited = dfs.getVisited();
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
        Graph graph = new Graph(20);

        //example graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 8);

        //more test verticies
        graph.addEdge(12, 4);
        graph.addEdge(3,17);
        graph.addEdge(19,4);
        graph.addEdge(14,15);
        graph.addEdge(18,14);
        graph.addEdge(16,9);
        graph.addEdge(6,9);
        graph.addEdge(6,9);
        graph.addEdge(6,9);

        return graph;
    }
}
