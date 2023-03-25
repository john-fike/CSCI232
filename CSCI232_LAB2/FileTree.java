
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
        ArrayList<Node> children;
        String[] tokens = directory.split("/");
        String targetDirectory = tokens[tokens.length - 1];
        if(tokens.length>1){
            Stack<Node> stack = new Stack<>();
            children = root.getChildren();
            //Time complexity? pfft who cares
            if (root != null) {
                stack.add(root);
                while (!stack.isEmpty()) {
                    Node node = stack.pop();
                    if (targetDirectory.equals(node.getName())) {
                        current = node;
                        return true;
                    }
                    for (Node child : node.getChildren()) {
                        stack.add(child);
                    }
                }
            }
        }
        else{
            children = current.getChildren();
            for (Node node : children) {
                if (targetDirectory.equals(node.getName())) {
                    current = node;
                    return true;
                }
            }
        }

        System.out.println("That path does not exist bozo");
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
        for (Node c : children) {
            files += c.getName() + " ";
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
                System.out.println(node.getName());
                for (Node child : node.getChildren()) {
                    stack.add(child);
                }
            }
        }
    }
    public String getPath(){
        Node temp = current;
        String path = "/";
        Stack<String> stonk = new Stack<>();
        while(temp != root){
            stonk.push(temp.getName() + "/");
            temp = temp.getParent();
        }
        for(String s : stonk){
            path = path + stonk.pop();
        }
        return path + current.getName();
    }
    public boolean remove(String directory) {
        Stack<Node> stack = new Stack<>();
        if (current != null) {
            //look through current directory children and see if they are the directory to be deleted
            for(Node node : current.getChildren()){
                if(directory.equals(node.getName())) {
                    System.out.println("REMOVING DIRECTORY: " + node.getName());
                    node.anakin();           //decimate children of node to be removed
                    current.removeChild(node);
                    return true;
                }
            }
        }
        System.out.println("That directory doesn't exist, please get good.");
        return false;
    }
}
