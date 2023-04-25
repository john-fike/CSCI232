import java.util.LinkedList;

public class IntegerShortestPath {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please format input like so: <file> <vertex 1> <vertex 2>");
            return;
        }

        //parse input from args
        String fileName = args[0];
        int startingVertex =  Integer.parseInt(args[1]);
        int endingVertex = Integer.parseInt(args[2]);

//        String fileName = "C:\\Users\\John Fike\\CSCI232\\CSCI232\\CSCI232LAB9\\src\\graph.txt";
//        int startingVertex =  0;
//        int endingVertex = 3;


        //create new graph from file, search using BFS, grab path from BFS obj
        Graph Graph = new Graph(fileName);

        BreadthFirstSearch breakfastfirst = new BreadthFirstSearch(Graph,startingVertex);
        LinkedList<Integer> path = breakfastfirst.getPathTo(endingVertex);

        //build string representing path linkedlist
        StringBuilder pathStr = new StringBuilder();
        Integer totalWeight = 0;
        int jumps=0;
        for (int i = 0; i < path.size(); i++) {
//            if(path.get(i)<Graph.getMaxVal()){                 //?????????????????????
                pathStr.append(path.get(i));
//            }
            if(i>0 && Graph.getWeight(path.get(i) + "," + path.get(i-1)) != null){
                totalWeight += Graph.getWeight(path.get(i) + "," + path.get(i-1));
            }

            if (i < path.size() - 1) {
                pathStr.append(" -> ");
                jumps++;
            }
        }
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Num jumps: " + jumps);
        System.out.println(pathStr.toString());

    }
}

//print no work, if statement somehow not needed 