import java.util.HashMap;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

    private LinkedList<Integer>[] adjacencyList;
    private LinkedList<Integer>[] weightedAdjacencyList;
    HashMap<String, Integer> weightMap = new HashMap<String, Integer>();
    private int numEdges;
    private int maxVal;


    public Graph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
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
                adjacencyList = new LinkedList[numVerticies];
                for (int i = 0; i < adjacencyList.length; i++) {
                    adjacencyList[i] = new LinkedList<>();
                }

                //create hellscape retard graph with retard code
                weightedAdjacencyList = new LinkedList[10000*numVerticies];
                for (int i = 0; i < weightedAdjacencyList.length; i++) {
                    weightedAdjacencyList[i] = new LinkedList<>();
                }

                //go thru rest of file, add edges from line of CSVs
                String line = scanner.nextLine();
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    String[] vals = line.split(",");
                    addEdge(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]),Integer.parseInt(vals[2]));
                    weightMap.put((vals[0] + "," + vals[1]),Integer.parseInt(vals[2]));
                    weightMap.put((vals[1] + "," + vals[0]),Integer.parseInt(vals[2]));
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

    public Integer getWeight(String edge){
        if(weightMap.containsKey(edge)){
            return weightMap.get(edge);
        }else{
            System.out.println("Edge does not exist");
            return null;
        }
    }

    public int getNumWeightedVertices() {
        return weightedAdjacencyList.length;
    }

    public int getNumVerticies(){
        return adjacencyList.length;
    }

    public int getMaxVal(){
        return maxVal-1;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void addEdge(int vertex1, int vertex2, int weight) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);

        int tempVert1 = vertex1;
        int tempVert2 = 1000 * tempVert1;
        for(int i=0;i<weight;i++){
            weightedAdjacencyList[tempVert1].add(tempVert2);
            weightedAdjacencyList[tempVert2].add(tempVert1);
            tempVert1 = tempVert2;
            tempVert2++;
        }
        tempVert2--;
        weightedAdjacencyList[tempVert2].add(vertex2);
        weightedAdjacencyList[vertex2].add(tempVert2);
        numEdges++;
    }
    public void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);

        numEdges++;
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (adjacencyList[vertex1].contains(vertex2)) {
            adjacencyList[vertex1].remove((Integer) vertex2);
            adjacencyList[vertex2].remove((Integer) vertex1);

            numEdges--;
        }
    }

    public LinkedList<Integer> getNeighbors(int vertex) {
        return weightedAdjacencyList[vertex];
    }
}
