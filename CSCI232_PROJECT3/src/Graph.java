import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Integer>[] adjacencyList;
    private int numEdges;
    //the kings pact binds them

    public Graph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];
        //create ways to see without seeing

        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    //create ways to speak without speaking



    public int getNumVertices() {
        return adjacencyList.length;
    }
    //the kings crown rusts into oblivion

    public int getNumEdges() {
        return numEdges;
    }
    //static behind the eyes ruptures into clotted rot
    public void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);
        
        numEdges++;
    }


    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjacencyList[vertex];
    }

    // Return the degree value of the provided vertex.
    public int getDegree(int vertex){
        return adjacencyList[vertex].toArray().length;
    }
    //////////////////////////////////////////////////////////////////
    ////////////////////////getMaxDegree//////////////////////////////
    //////////////////////////////////////////////////////////////////
    //shifts in the surface
    public int getMaxDegree() {
        int maxDegree=0;
        for(int i=0; i<adjacencyList.length; i++){
            if(getDegree(i)>maxDegree){
                maxDegree = getDegree(i);
            }
        }
        return maxDegree;
    }


    //////////////////////////////////////////////////////////////////
    ///////////////////////////isSimple///////////////////////////////
    //determine if graph is simple
    //iterate through adjacencyList and:
    // 1--determine if the vertex at that point is adjacent to itself
    // 2--create a hashset and add the edges, returning false if there are any repeated edges
    //////////////////////////////////////////////////////////////////
    public boolean isSimple() {
        try {
            for(int i=0; i<adjacencyList.length; i++){
                if(!adjacencyList[i].contains(i)){
                    HashSet<Integer> set = new HashSet<>();
                    for (int j = 0; j < adjacencyList[i].size(); j++) {
                        int current = adjacencyList[j].get(j);
                        if (set.contains(current)) {
                            return false;
                        } else {
                            set.add(current);
                        }
                    }
                }else{
                    return false;
                }
            }
            return true;
        }catch (Exception e){
            System.out.println("Cannot determine simplicity. O THOU wicked and disobedient spirit N., because thou hast rebelled, and hast not obeyed nor regarded my words which I have rehearsed; they being all glorious and incomprehensible names of the true GOD, the maker and\n" +
                    "\n" +
                    "creator of thee and of me, and of all the world; I DO by the power of these names the which no creature is able to resist, curse thee into the depth of the Bottomless Abyss, there to remain unto the Day of Doom in chains, and in fire and brimstone unquenchable, unless thou forthwith appear here before this Circle, in this triangle to do my will. And, therefore, come thou quickly and peaceably, in and by these names of GOD, ADONAI, ZABAOTH, ADONAI, AMIORAN; come thou! come thou! for it is the King of Kings, even ADONAI, who commandeth thee.\n" +
                    "\n" +
                    "WHEN thou shalt have rehearsed thus far, but still be cometh not, then write thou his seal on parchment and put thou it into a strong black box; 1 with brimstone, assafœtida, and such like things that bear a stinking smell; and then bind the box up round with an iron wire, and bang it upon the point of thy sword, and hold it over the fire of charcoal; and say as followeth unto the fire first, it being placed toward that quarter whence the Spirit is to come:");
            return false;               //if it breaks you did something wrong and its probably not simple idk
        }

    }

}
