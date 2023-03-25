/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;

/**
 *
 * @author yaw
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(44);
        bst.insert(17);
        bst.insert(88);
        bst.insert(8);
        bst.insert(32);
        bst.insert(65);
        bst.insert(97);
        bst.insert(27);
        bst.insert(54);
        bst.insert(82);
        bst.insert(93);
        bst.insert(21);
        bst.insert(29);
        bst.insert(76);
        bst.insert(28);
        bst.insert(68);
        bst.insert(80);
        
        // Test methods...
        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
        for(int i=1; i<100; i++) {
            Node node = bst.find(i);
            if (node != null){
                System.out.println(bst.find(i).getValue());
            }
        }



    }
}
