/**
 * depth first search for graph class
 */
public class DepthFirstSearch {

    public boolean[] visited;

    public DepthFirstSearch(Graph graph, int startVertex) {
        visited = new boolean[graph.getNumVertices()];
        dfs(graph, startVertex);
    }

    public DepthFirstSearch(Graph graph, int startVertex, boolean[] visited) {
        this.visited = visited;
        dfs(graph, startVertex);
    }

    private void dfs(Graph graph, int vertex) {
        System.out.print(vertex + ",");
        visited[vertex] = true;

        for (int neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor);
            }
        }
    }
}
