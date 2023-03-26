import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class DocCheck {

    public static void spellCheck(File processingFile, File dictionaryFile) {
        HashSet<String> dictionary = new HashSet<>();

        // Load dictionary into HashSet
        try {
            Scanner scanner = new Scanner(dictionaryFile);
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                dictionary.add(word);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading dictionary file.");
            return;
        }

        ///////////////////////SPELL CHECKING/////////////////////////////////////////////////////////////////
        try {
            //create scanner
            Scanner scanner = new Scanner(processingFile);
            File outputFile = new File(processingFile.getName().replaceFirst("[.][^.]+$", "") + " spellChecked.txt");
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();

                // Strip non-alphanumeric characters from word except for whitespace
                word = word.replaceAll("(?<=\\w)[^\\w\\s]|[^\\w\\s](?=\\w)", "");

                if (dictionary.contains(word)) {
                    // Write word to output file if it's in dictionary
                    writer.write(word);
                }
                // Write whitespace character after word
                if (scanner.hasNext()) {
                    writer.write(scanner.match().group());
                }
            }

            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error processing file.");
        }
    }

    public static void wordCount(File processingFile) {
        HashMap<String, Integer> countPerWord = new HashMap<>();
        HashMap<Integer, HashSet<String>> wordsPerCount = new HashMap<>();
    }
}




//import java.io.File;
//        import java.io.FileWriter;
//        import java.util.HashSet;
//
//
//public class DocCheck {
//
//    public static void spellCheck(File processingFile, File dictionaryFile) {
//        HashSet<String> dictionary = new HashSet<>();
//
//        // Load dictionary into HashSet
//        try {
//            Scanner scanner = new Scanner(dictionaryFile);
//            while (scanner.hasNext()) {
//                String word = scanner.next().toLowerCase();
//                dictionary.add(word);
//            }
//            scanner.close();
//        } catch (IOException e) {
//            System.out.println("Error reading dictionary file.");
//            return;
//        }
//
//        ///////////////////////SPELL CHECKING/////////////////////////////////////////////////////////////////
//        try {
//            //create scanner
//            Scanner scanner = new Scanner(processingFile);
//            File outputFile = new File(processingFile.getName().replaceFirst("[.][^.]+$", "") + " spellChecked.txt");
//            FileWriter writer = new FileWriter(outputFile);
//
//            while (scanner.hasNext()) {
//                String word = scanner.next().toLowerCase();
//
//                // Strip non-alphanumeric characters from word except for whitespace
//                word = word.replaceAll("(?<=\\w)[^\\w\\s]|[^\\w\\s](?=\\w)", "");
//
//                if (dictionary.contains(word)) {
//                    // Write word to output file if it's in dictionary
//                    writer.write(word);
//                }
//                // Write whitespace character after word
//                if (scanner.hasNext()) {
//                    writer.write(scanner.match().group());
//                }
//            }
//
//            scanner.close();
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("Error processing file.");
//        }
//    }
//
//    public static void wordCount(File processingFile) {
//        HashMap<String, Integer> countPerWord = new HashMap<>();
//        HashMap<Integer, HashSet<String>> wordsPerCount = new HashMap<>();
//
//        // Implementation for wordCount method
//    }
//}
