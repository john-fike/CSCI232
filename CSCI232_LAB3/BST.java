
/**
 *
 * @author yaw
 */
public class BST {

    Node root;

    public BST() {
        root = null;
    }

    public void insert(int newValue) {
        if (root == null) {
            root = new Node(newValue);
        } else {
            Node currentNode = root;
            boolean placed = false;
            while (!placed) {
                if (newValue == currentNode.getValue()) {
                    placed = true;
                    // Don't insert repeated value.
                } else if (newValue < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new Node(newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new Node(newValue));
                        currentNode.getRight().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }

    public int getMin(){
    if(root != null) {
        Node current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getValue();
    }
        return -1;
    }
    public int getMax(){
        if(root != null) {
            Node current = root;
            while (current.getRight() != null) {
                current = current.getRight();
            }
            return current.getValue();
        }
        return -1;
    }
    public Node find(int value){
        if(root != null) {
            Node current = root;
            //look until both children are null or value is found
            while(current.getValue() != value) {
                //go to lower
                if (current.getValue() > value && current.getLeft() != null) {
                    current = current.getLeft();
                }
                //go higher
                else if (current.getRight() != null) {
                    current = current.getRight();
                }
                //return null if both children are null
                else {
                    return null;
                }
            }
            return current;
        }
        return null;
    }
}
