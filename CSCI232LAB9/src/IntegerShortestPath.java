import java.util.LinkedList;

public class IntegerShortestPath {
    public static void main(String[] args) {
//        if (args.length != 3) {
//            System.out.println("Please format input like so: <file> <vertex 1> <vertex 2>");
//            return;
//        }

        //parse input from args
//        String fileName = args[0];
//        int startingVertex =  Integer.parseInt(args[1]);
//        int endingVertex = Integer.parseInt(args[2]);

        String fileName = "C:\\Users\\John Fike\\CSCI232\\CSCI232\\CSCI232LAB9\\src\\graph.txt";
        int startingVertex =  4;
        int endingVertex = 1;


        //create new graph from file, search using BFS, grab path from BFS obj
        Graph Graph = new Graph(fileName);

        BreadthFirstSearch breakfastfirst = new BreadthFirstSearch(Graph,startingVertex);
        LinkedList<Integer> path = breakfastfirst.getPathTo(endingVertex);

        //build string representing path linkedlist
        StringBuilder pathStr = new StringBuilder();
        Integer totalWeight = 0;
        int jumps=0;
        for (int i = 0; i < path.size(); i++) {
            if(path.get(i)<=Graph.getMaxVal()){                 //?????????????????????
                pathStr.append(path.get(i));
            }
//            if(i>0){
//                totalWeight += Graph.getWeight(path.get(i) + "," + path.get(i-1)) + Graph.getWeight(path.get(i-1) + "," + path.get(i));
//            }
            jumps++;
            if (i < path.size() - 1 && path.get(i)<=Graph.getMaxVal()) {
                pathStr.append(" -> ");
            }
        }
        System.out.println("Total Weight: " + jumps);
        System.out.println(pathStr.toString());
    }
}

//

/*
5
0,2,1
0,1,2
1,3,5
2,3,1
3,4,10
2,4,5

EDGE DNE FIND 1 - 4
 */