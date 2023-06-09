import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

    private LinkedList<Integer>[] invertedAdjacencyList;
    private LinkedList<Integer>[] weightedAdjacencyList;
    private int numEdges;


    public Graph(int numVertices) {
//        adjacencyList = new LinkedList[numVertices];
//
//        for (int i = 0; i < adjacencyList.length; i++) {
//            adjacencyList[i] = new LinkedList<>();
//        }
    }
    
    public Graph(String file) {
        loadGraph(file);
    }

    private void loadGraph(String file) {
        int numVerticies = 0;
        try{
            Scanner scanner = new Scanner(new File(file));

            //first int in file is number of verticies
            numVerticies =  scanner.nextInt();
            if(numVerticies>0){

                //create graph using yaw code
                invertedAdjacencyList = new LinkedList[numVerticies];
                for (int i = 0; i < invertedAdjacencyList.length; i++) {
                    invertedAdjacencyList[i] = new LinkedList<>();
                }

                //create hellscape retard graph with retard code
                weightedAdjacencyList = new LinkedList[10000*numVerticies];
                for (int i = 0; i < weightedAdjacencyList.length; i++) {
                    weightedAdjacencyList[i] = new LinkedList<>();
                }

                //go thru rest of file, add edges from line of CSVs, add weights to weightMap
                String line = scanner.nextLine();
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    String[] vals = line.split(",");
                    addEdge(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]),Integer.parseInt(vals[2]),weightedAdjacencyList);
                    addEdge(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]),Integer.parseInt(vals[2]) * -1,invertedAdjacencyList);
                }

                System.out.println("Graph of size " + numVerticies + " created");

            }else{
                System.out.println("Bad File Format");
            }
            scanner.close();
        }catch (FileNotFoundException f){
            System.out.println("File not found: " + file);
        }
    }

    public int getNumWeightedVertices() {
        return weightedAdjacencyList.length;
    }

    public int getNumVerticies(){
        return invertedAdjacencyList.length;
    }

    public int getMaxVal(){
        return getNumVerticies()-1;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void addEdge(int vertex1, int vertex2, int weight, LinkedList<Integer>[] inputGraph) {
                                                                //if edge being created has weight, create synthetic nodes representing weight
        if(weight>1){
            int tempVert1 = vertex1;
            int tempVert2 = 1000 * tempVert1;
                                                                //for every unit of weight, add another node way out yonder
            for(int i=0;i<weight-1;i++){
                inputGraph[tempVert1].add(tempVert2);
                inputGraph[tempVert2].add(tempVert1);
                tempVert1 = tempVert2;
                tempVert2++;
            }
                                                                //connect yonder nodes to "real" node
            tempVert2--;
            inputGraph[tempVert2].add(vertex2);
            inputGraph[vertex2].add(tempVert2);
        }else{
            //else if not weighted just connect regularly
            inputGraph[vertex1].add(vertex2);
            inputGraph[vertex2].add(vertex1);
        }

        numEdges++;
    }

    public LinkedList<Integer>[] getInvertedGraph(void) {
        return invertedAdjacencyList;
    }

    public LinkedList<Integer> getNeighbors(int vertex) {
        return weightedAdjacencyList[vertex];
    }
}
