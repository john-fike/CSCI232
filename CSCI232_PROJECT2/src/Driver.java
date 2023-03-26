import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Driver {
    public static void main(String[] args) {
        File dictionaryFile = new File("C:\\Users\\John Fike\\CSCI232\\CSCI232\\CSCI232_PROJECT2\\src\\words.txt");
        File processingFile = new File("C:\\Users\\John Fike\\CSCI232\\CSCI232\\CSCI232_PROJECT2\\src\\test.txt");
        DocCheck.spellCheck(processingFile, dictionaryFile);
//        DocCheck.wordCount(processingFile);
    }
}
