import java.io.File;


public class Driver {
    public static void main(String[] args) {
        File dictionaryFile = new File("C:\\Users\\John Fike\\CSCI232\\CSCI232\\CSCI232_PROJECT2\\src\\words.txt");
        File processingFile = new File("C:\\Users\\John Fike\\CSCI232\\CSCI232\\CSCI232_PROJECT2\\src\\test.txt");
        DocCheck.spellCheck(processingFile, dictionaryFile);
        DocCheck.wordCount(processingFile);
    }
}
