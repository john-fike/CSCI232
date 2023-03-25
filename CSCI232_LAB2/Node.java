
import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class Node {
    private String name;
    private Node parent;
    private ArrayList<Node> children;
    
    public Node(String name) {
        this.name = name;
        children = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public Node getParent() {
        return parent;
    }
    
    public ArrayList<Node> getChildren() {
        return children;
    }
    
    public void addChild(Node child) {
        children.add(child);
        System.out.println("ADDING CHILD: " + child.getName());
    }

    public void removeChild(Node child){
        children.remove(child);
    }
    //master skywalker, there are too many of them! what are we going to do?
    public void anakin(){
        for(Node node : children){
            node.anakin();
        }
        children.clear();
    }
}
