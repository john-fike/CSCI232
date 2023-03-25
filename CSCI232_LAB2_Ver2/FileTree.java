
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author yaw
 */
public class FileTree {

    private Node root;
    private Node current;

    public FileTree() {
        root = new Node("~");
        current = root;
    }

    public String getCurrentLocation() {
        return current.getName();
    }

    public boolean moveDown(String directory) {
        ArrayList<Node> children = current.getChildren();
        for (Node c : children) {
            if (directory.equals(c.getName())) {
                current = c;
                return true;
            }
        }
        return false;
    }

    public void moveUp() {
        if (current != root) {
            current = current.getParent();
        }
    }

    public void goHome() {
        current = root;
    }

    public String getChildren() {
        String files = new String();
        ArrayList<Node> children = current.getChildren();
        if(children.size() != 0){
            for (Node c : children) {
                files += c.getName() + " ";
            }
        }else{
            return "nothing!!!";
        }

        return files;
    }

    public boolean insert(String directory) {
        if (directory != null && !directory.equals(" ")) {
            Node newFile = new Node(directory);
            newFile.setParent(current);
            current.addChild(newFile);
            return true;
        }
        return false;
    }
    
    public void breadthFirst() {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                
                //DO ACTION
                System.out.println(node.getName());
                
                for (Node child : node.getChildren()) {
                    queue.add(child);
                }
            }
        }
    }
    
    public void depthFirst() {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                
                //DO ACTION
                System.out.println(node.getName());
                
                for (Node child : node.getChildren()) {
                    stack.add(child);
                }
            }
        }
    }
}
