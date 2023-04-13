
/**
 *
 * @author yaw
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph graph = Graph.defaultGraph();
        
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
    }
}
