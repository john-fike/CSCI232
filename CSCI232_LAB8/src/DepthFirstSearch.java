
/**
 *
 * @author yaw
 */
public class DepthFirstSearch {

    private boolean[] visited;

    public DepthFirstSearch(Graph graph, int startVertex) {
        visited = new boolean[graph.getNumVertices()];
        dfs(graph, startVertex);
    }

    private void dfs(Graph graph, int vertex) {
        System.out.println(vertex);
        visited[vertex] = true;

        for (int neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor);
            }
        }
    }
}
