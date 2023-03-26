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
        System.out.println(higher((HashSet<Integer>) set,10));  //why do I have to cast this? I do not know
        System.out.println(ceiling((HashSet<Integer>) set,10));  //why do I have to cast this? I do not know


        // create a HashSet and a TreeSet with the same elements
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int value = random.nextInt(100000);
            hashSet.add(value);
            treeSet.add(value);
        }

// time the higher() method for the HashSet
        long startTime = System.nanoTime();
        Integer result1 = higher(hashSet, 50000);
        long endTime = System.nanoTime();
        long duration1 = endTime - startTime;

// time the higher() method for the TreeSet
        startTime = System.nanoTime();
        Integer result2 = treeSet.higher(50000);
        endTime = System.nanoTime();
        long duration2 = endTime - startTime;

// time the higher() method for the HashSet
        long startTime = System.nanoTime();
        Integer hashSetHigher = higher(hashSet, 50000);
        long endTime = System.nanoTime();
        long duration1 = endTime - startTime;

// time the higher() method for the TreeSet
        startTime = System.nanoTime();
        Integer result2 = treeSet.higher(50000);
        endTime = System.nanoTime();
        long duration2 = endTime - startTime;


// print the results
        System.out.println("HashSet higher() duration: " + duration1 + " ns");
        System.out.println("TreeSet higher() duration: " + duration2 + " ns");
        System.out.println("HashSet higher() result: " + result1);
        System.out.println("TreeSet higher() result: " + result2);

    }
    public static Integer higher(HashSet<Integer> hashSet, int value) {
        Integer[] array = hashSet.toArray(new Integer[0]);
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, value);
        if (index < array.length - 1) {
            return array[index + 1];
        }
        return null;
    }
    private static Integer ceiling(HashSet<Integer> hashSet, int value) {
        Integer[] array = hashSet.toArray(new Integer[0]);
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, value);
        if (index >= 0) {
            return array[index];
        } else if (-(index + 1) < array.length) {
            return array[-(index + 1)];
        }
        return null;
    }
}



