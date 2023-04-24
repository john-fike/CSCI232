import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

    private LinkedList<Integer>[] adjacencyList;
    private int numEdges;
    
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
        Integer numVerticies = 0;
        try{
            Scanner scanner = new Scanner(new File(file));
            numVerticies =  scanner.nextInt();
            if(numVerticies>0){
                adjacencyList = new LinkedList[numVerticies];

                for (int i = 0; i < adjacencyList.length; i++) {
                    adjacencyList[i] = new LinkedList<>();
                }
                String line = scanner.nextLine();
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    String[] verticies = line.split(",");
                    addEdge(Integer.parseInt(verticies[0]),Integer.parseInt(verticies[1]));
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

    public int getNumVertices() {
        return adjacencyList.length;
    }

    public int getNumEdges() {
        return numEdges;
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
        return adjacencyList[vertex];
    }
}
