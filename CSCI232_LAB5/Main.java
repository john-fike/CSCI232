/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        
        database.addStudent("Joe Schmo", 1101, 3.2);
        database.addStudent("Katie Katerson", 31415926, 3.7);
        database.addStudent("Watson TheBassetHound", 12345, 2.4);
        database.addStudent("Ted Kaczynski", 45, 2.4);
        database.addStudent("Ali Khamenei", 9, 3.9);
        database.addStudent("John MacAffee", 762, 3.9);


        database.printDatabase();
        
        database.addStudent("Joe Schmo", 99999, 3.9);
        database.countStudentByName();
        database.findStudentByID(1101);
        database.findStudentByID(31415926);
        database.findStudentByID(12345);
        database.findStudentByID(99999);

        database.printStudentsByGPA();




    }
    
}
