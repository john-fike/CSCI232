public class MaximumSpanningTree {

    private Edge[] maxST;

    public MaximumSpanningTree(Graph graph) {
        // Create a copy of the graph where the edge weights are negated
        Graph negatedGraph = new Graph(graph.getNumVerticies());
        for (Edge edge : graph.getEdges()) {
            negatedGraph.addEdge(edge.getVerticies()[0], edge.getVerticies()[1], -edge.getWeight());
        }

        // Find the minimum spanning tree in the negated graph
        MinimumSpanningTree mst = new MinimumSpanningTree(negatedGraph);

        // Convert the edges in the minimum spanning tree back to the original graph
        maxST = new Edge[mst.getMST().size()];
        int i = 0;
        for (Edge edge : mst.getMST()) {
            int vertex1 = edge.getVerticies()[0];
            int vertex2 = edge.getVerticies()[1];
            double weight = -edge.getWeight();
            maxST[i] = new Edge(vertex1, vertex2, weight);
            i++;
        }
    }

    public Edge[] getMaxST() {
        return maxST;
    }
}