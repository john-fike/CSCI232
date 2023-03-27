import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        tree.add(10);
        tree.add(5);
        tree.add(8);
        tree.add(1);
        tree.add(11);
        tree.add(3);

        System.out.println(tree.higher(10));
        System.out.println(tree.ceiling(10));


        Integer arr[] = {10,5,8,1,11,3};
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        System.out.println(set);
        System.out.println(higher((HashSet<Integer>) set,10));
        System.out.println(ceiling((HashSet<Integer>) set,10));


        // create a HashSet and a TreeSet with the same elements
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int value = random.nextInt(100000);
            hashSet.add(value);
            treeSet.add(value);
        }

        int randValue = random.nextInt(100000);

// time the higher() method for the HashSet
        long startTime = System.nanoTime();
        Integer result1 = higher(hashSet, randValue);
        long endTime = System.nanoTime();
        long durationHashHigher = endTime - startTime;

// time the higher() method for the TreeSet
        startTime = System.nanoTime();
        Integer result2 = treeSet.higher(randValue);
        endTime = System.nanoTime();
        long durationTreeHigher = endTime - startTime;

// time the ceiling() method for the HashSet
        startTime = System.nanoTime();
        Integer hashCeiling = ceiling(hashSet, randValue);
        endTime = System.nanoTime();
        long durationHashCeiling = endTime - startTime;

// time the ceiling() method for the TreeSet
        startTime = System.nanoTime();
        Integer treeCeiling = treeSet.higher(randValue);
        endTime = System.nanoTime();
        long durationTreeCeiling = endTime - startTime;


// print the results
        System.out.println("HashSet higher() duration: " + durationHashHigher + " ns");
        System.out.println("TreeSet higher() duration: " + durationTreeHigher + " ns");
        System.out.println("HashSet ceiling() result: " + durationHashCeiling + "ns");
        System.out.println("TreeSet ceiling() result: " + durationTreeCeiling + "ns");

    }

    //find
    private static Integer higher(HashSet<Integer> hashSet, int value) {
        // Convert the HashSet to an array of Integers
        Integer[] array = hashSet.toArray(new Integer[0]);

        // Sort the array in ascending order
        Arrays.sort(array);

        // Find the index of the specified value in the array
        int index = Arrays.binarySearch(array, value);

        // If the index is less than the last element in the array, return the next element
        if (index < array.length - 1) {
            return array[index + 1];
        }

        // If there is no next element, return null
        return null;
    }

    //find element greater than or equal to element of value value
    private static Integer ceiling(HashSet<Integer> hashSet, int value) {
        // Convert the HashSet to an array of Integers
        Integer[] array = hashSet.toArray(new Integer[0]);

        // Sort the array in ascending order
        Arrays.sort(array);

        // Find the index of the specified value in the array
        int index = Arrays.binarySearch(array, value);

        // If the index is non-negative, return the element at that index
        if (index >= 0) {
            return array[index];
        }

        //if binary search has returned an index within the array, return the element larger than
        //element at insertion point
        else if (-(index + 1) < array.length) {
            return array[-(index + 1)];
        }

        // If there is no element greater than or equal to the specified value, return null
        return null;
    }

}

/*
TreeSet is a self balancing BST, meaning finding ordered elements is done in logn time.
Hash tables are much less efficient at finding ordered elements, meaning they can
be found in only nlogn time. This is because hash table are only nebulous collections of
data, and are essentially an unordered array.

Tree sets are useful when elements must be stored in an ordered fashion, as sorted elements
are much quicker to find. However, hashsets can access any specific element in constant time, meaning
insertion, deletion, and lookup operations can be done much faster than tree sets.

 */

