
import java.util.Scanner;

/**
 *
 * @author yaw
 */
public class FileSystemManager {

    private FileTree tree;

    public FileSystemManager() {
        tree = new FileTree();
    }

    public void run() {
        String command = " ";
        Scanner in = new Scanner(System.in);
        while (!command.equals("exit")) {
            System.out.print(tree.getCurrentLocation() + " % ");
            command = in.nextLine();
            executeCommand(command);
        }
    }

    private void executeCommand(String command) {
        int breakPoint = command.indexOf(" ");
        String argument = null;
        if (breakPoint != -1) {
            argument = command.substring(breakPoint + 1, command.length());
            command = command.substring(0, breakPoint);
        }
        if (command.equals("cd")) {
            if (!move(argument)) {
                System.out.println("cd: no such file or directory: " + argument + "\n");
            }
        } else if (command.equals("ls")) {
            System.out.println(tree.getChildren());
        } else if (command.equals("mkdir")) {
            if (!tree.insert(argument)) {
                System.out.println("Invalid file name.\n");
            }
        } else if(command.equals("pwd")){
            System.out.println("~" + tree.getPath());
        } else if(command.equals("rm")){
            tree.remove(argument);
        } else if (command.equals("exit")) {
        } else {
            System.out.println("'" + command + "' is not a recognized command");
        }
    }

    private boolean move(String file) {
        if (file == null || file.equals("") || file.equals("~")) {
            tree.goHome();
            return true;
        }
        if (file.equals("..")) {
            tree.moveUp();
            return true;
        }
        return tree.moveDown(file);
    }
    
    public void test() {  
        tree.insert("1");
        tree.moveDown("1");
        tree.insert("1.1");
        tree.insert("1.2");
        tree.moveDown("1.2");
        tree.insert("1.2.1");
        tree.goHome();
        
        tree.insert("2");
        tree.moveDown("2");
        tree.insert("2.1");
        tree.insert("2.2");
        tree.insert("2.3");
        tree.moveDown("2.2");
        tree.insert("2.2.1");
        tree.moveDown("2.2.1");
        tree.insert("2.2.1.1");
        tree.insert("2.2.1.2");
        tree.moveUp();
        tree.insert("2.2.2");
        tree.goHome();
        
        tree.insert("3");
        tree.moveDown("3");
        tree.insert("3.1");
        tree.insert("3.2");
        tree.moveDown("3.2");
        tree.insert("3.2.1");
        tree.insert("3.2.2");
        tree.goHome();
        
        tree.insert("4");
        tree.moveDown("4");
        tree.insert("4.1");
        tree.insert("4.2");
        tree.moveDown("4.2");
        tree.insert("4.2.1");
        tree.goHome();
        
        //run();
        
//
    }        
}
