import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DocCheck {

    public static void spellCheck(File processingFile, File dictionaryFile) {
        HashSet<String> dictionary = new HashSet<>();

        // Load dictionary into HashSet
        try (Scanner scanner = new Scanner(dictionaryFile)) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim().toLowerCase();
                dictionary.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found");
            return;
        }

        ///////////////////////SPELL CHECKING/////////////////////////////////////////////////////////////////
        try {
            //create scanner
            Scanner scanner = new Scanner(processingFile);
            scanner.useDelimiter("[\\s.,-]+");
            File outputFile = new File("spellChecked.txt");
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNext()) {
                String inputWord = scanner.next();
                String tempInputWord = inputWord.toLowerCase();


                // Strip non-alphanumeric characters from word except letters and apostrophes
//                word = word.replaceAll("[^a-zA-Z']+", "");

                if (dictionary.contains(word)) {
                    // Write word to output file if it's in dictionary
                    writer.write(word);
                } else {
                    // Enclose misspelled word in triangle brackets and write to output file
                    writer.write("<" + word + ">");
                }
                // Write whitespace character after word
                String whitespace = scanner.findWithinHorizon("[\\s.,-]+", 2);
                if (whitespace != null) {
                    writer.write(whitespace);
                }
            }

            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error processing file.");
        }
    }


    public static void wordCount(File processingFile) {
        // Create two maps to store word counts and sets of words for each count
        HashMap<String, Integer> countPerWord = new HashMap<>();
        HashMap<Integer, HashSet<String>> wordsPerCount = new HashMap<>();

        try (Scanner scanner = new Scanner(processingFile)) {
            // Iterate over each word in the file
            while (scanner.hasNext()) {
                // Get the next word and convert it to lowercase
                String word = scanner.next().toLowerCase();

                // Remove any non-letter characters from the word using a regex
                word = word.replaceAll("[^a-zA-Z]", "");

                // If the word is empty (i.e. only contained non-letter characters),
                // skip to the next word
                if (word.isEmpty()) {
                    continue;
                }

                // Increment the count for the current word in the countPerWord map
                int count = countPerWord.getOrDefault(word, 0) + 1;
                countPerWord.put(word, count);

                // Get the set of words with the current count from the wordsPerCount map,
                // or create a new empty set if it doesn't exist yet
                HashSet<String> words = wordsPerCount.getOrDefault(count, new HashSet<>());

                // Add the current word to the set of words with the current count
                words.add(word);

                // Update the wordsPerCount map with the new set of words for the current count
                wordsPerCount.put(count, words);
            }
        } catch (FileNotFoundException e) {
            // If the file isn't found, print an error message and return
            System.out.println("File not found: " + processingFile);
            return;
        }

        // Print the total number of words and the mapping of counts to sets of words
        System.out.println("Word count: " + countPerWord.size());
        System.out.println("Words per count: " + wordsPerCount);


        List<Integer> counts = new ArrayList<>(wordsPerCount.keySet());
        Collections.sort(counts);
        for (int count : counts) {
            System.out.println(count + ": " + wordsPerCount.get(count));
        }
    }
}


