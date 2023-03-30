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
                String word = scanner.nextLine();
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
            //stop at punctuation
            scanner.useDelimiter("[\\s.,\\-:()@&*]+|\\r?\\n");
            File outputFile = new File("spellChecked.txt");
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNext()) {
                String inputWord = scanner.next();
                String tempInputWord = inputWord.toLowerCase();

                if (dictionary.contains(tempInputWord)) {
                    // Write word to output file if it's in dictionary
                    writer.write(inputWord);
                }
                // Write whitespace and punctuation that follow the word
                String remainingChars = scanner.findWithinHorizon("[\\s.,\\-&@]+", 2);
                if (remainingChars != null) {
                    writer.write(remainingChars);
                }
            }
            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Please try again later. Taking a nap rn zzz");
        }
    }


    public static void wordCount(File processingFile) {
        // Create two maps to store word counts and sets of words for each count
        HashMap<String, Integer> countPerWord = new HashMap<>();
        HashMap<Integer, HashSet<String>> wordsPerCount = new HashMap<>();

        try (Scanner scanner = new Scanner(processingFile)) {
            scanner.useDelimiter("[\\s.,\\-:()@]+|\\r?\\n");
            // Iterate over each word in the file
            while (scanner.hasNext()) {
                // Get the next nextWord and convert it to lowercase
                String nextWord = scanner.next().toLowerCase();

                // Grab count for the current nextWord in the countPerWord map, increment. Start at 1 if nextWord hasn't been counted before.
                int count = countPerWord.getOrDefault(nextWord, 0) + 1;
                //Update count in hashmap
                countPerWord.put(nextWord, count);

                // Get the set of words with the current count from the wordsPerCount map,
                // or create a new empty set if it doesn't exist yet
                HashSet<String> words = wordsPerCount.getOrDefault(count, new HashSet<>());
                // Add the current nextWord to the set of words with the current count
                words.add(nextWord);
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
    }
}


