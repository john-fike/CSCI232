
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
        for(int i=0; i<adjacencyList.length; i++){
            if(!adjacencyList[i].contains(i)){
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < adjacencyList[i].size(); j++) {
                    int current = adjacencyList[j].get(j);
                    if (set.contains(current)) {
                        return false;
                    } else {
                        set.add(current);
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
