
import java.util.HashSet;
import java.util.LinkedList;


/**
 *
 * @author yaw
 */
public class Graph {
    private LinkedList<Integer>[] adjacencyList;
    private int numEdges;
    
    public Graph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];
        
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
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
    
    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjacencyList[vertex];
    }
    
    // Return the degree value of the provided vertex.
    public int getDegree(int vertex){
        return adjacencyList[vertex].toArray().length;
    }
    
    // Return the degree value of the vertex with the largest degree value in the graph.
    public int getMaxDegree() {
        int maxDegree=0;
        for(int i=0; i<adjacencyList.length; i++){
            if(getDegree(i)>maxDegree){
                maxDegree = getDegree(i);
            }
        }
        return maxDegree;
    }

    // Return wheather or not the graph is a simple graph.
    public boolean isSimple() {
        HashSet<String> edgeSet = new HashSet<>();

        for (int i = 0; i < adjacencyList.length; i++) {
            LinkedList<Integer> neighbors = getNeighbors(i);
            for (Integer neighbor : neighbors) {
                String edge1 = i + "," + neighbor;
                String edge2 = neighbor + "," + i;
                if (!edgeSet.contains(edge1) && !edgeSet.contains(edge2)) {
                    edgeSet.add(edge1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }



}
