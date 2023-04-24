/*
AUTHORS: JOHN FIKE & SARAH DOLAN
 */
public class Driver {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        System.out.println(g.getDegree(4));
        System.out.println(g.getMaxDegree());
        System.out.println(g.isSimple());

        g.addEdge(5, 3);
        System.out.println(g.isSimple());
    }
}
