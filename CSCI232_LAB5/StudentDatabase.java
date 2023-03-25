
import java.util.HashMap;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class StudentDatabase {

    private HashMap<String, HashSet<Student>> database;

    public StudentDatabase() {
        database = new HashMap<>();
    }

    public void addStudent(String name, int idNumber, double gpa) {
        Student student = new Student(name, idNumber, gpa);
        
        if (!database.containsKey(name)) {
            database.put(name, new HashSet<>());
        }
        database.get(name).add(student);
    }

    public void printDatabase() {
        for (String name : database.keySet()) {
            for (Student student : database.get(name)) {
            System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
            }
        }
        System.out.println();
    }

    public void countStudentByName(){
        for(String name : database.keySet()){
            int count = 0;
            for(Student student : database.get(name)){
                System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
                count++;
            }
            //lmao
            System.out.println("Number of students with name " + name + ": " + count + "\n");
        }
    }

    public void findStudentByID(int id){
        System.out.println("Finding student with ID: " + id);
        for (String name : database.keySet()) {
            for (Student student : database.get(name)) {
                if(student.getIdNumber()==id) {
                    System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
                }
            }
        }
        System.out.println();
    }

    public void printStudentsByGPA(){
        HashMap<Double, HashSet<Student>> GPADataBase = new HashMap<>();
        for(String name : database.keySet()){
            for (Student student : database.get(name)) {
                if(!GPADataBase.containsKey(student.getGPA())){
                    GPADataBase.put(student.getGPA(), new HashSet<>());
                }GPADataBase.get(student.getGPA()).add(student);
            }
        }
        for (Double gpa : GPADataBase.keySet()) {
            int count = 0;
            for (Student student : GPADataBase.get(gpa)) {
                System.out.println(student.getName() + ": (ID=" + student.getIdNumber() + "), (gpa=" + student.getGPA() + ")");
                count ++;
            }
            System.out.println("Number of students with id " + gpa + ": " + count + "\n");
        }
    }


    /*public void updateGPA(String name, double newGPA) {
        // TODO
        database.get(name).changeGPA(newGPA);
    }

    public void removeStudent(String name) {
        database.remove(name);
        // TODO
    }*/
}
