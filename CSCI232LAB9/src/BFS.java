import java.util.LinkedList;

public class BFS{
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java MyProgram <file> <a> <b>");
            return;
        }

        //parse input from args
        String fileName = args[0];
        int startingVertex =  Integer.parseInt(args[1]);
        int endingVertex = Integer.parseInt(args[2]);

        //create new graph from file, search using BFS, grab path from BFS obj
        Graph Graph = new Graph(fileName);
        BreadthFirstSearch breakfastfirst = new BreadthFirstSearch(Graph,startingVertex);
        LinkedList<Integer>  path = breakfastfirst.getPathTo(endingVertex);

        //build string representing path linkedlist
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append(" -> ");
            }
        }
        System.out.println(sb.toString());
    }
}
