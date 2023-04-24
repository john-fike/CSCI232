public class BFS{
    public static void main(String[] args) {
//        if (args.length != 3) {
//            System.out.println("Usage: java MyProgram <file> <a> <b>");
//            return;
//        }
//        String fileName = args[0];
        int startingVertex =  Integer.parseInt(args[1]);
        int endingVertex = Integer.parseInt(args[2]);
        String fileName = "C:\\Users\\John Fike\\CSCI232\\CSCI232\\CSCI232LAB9\\src\\graph.txt";
        Graph Graph = new Graph(fileName);
        BreadthFirstSearch breakfastfirst = new BreadthFirstSearch(Graph,startingVertex);
    }
}



//
//public class MyProgram {
//    public static void main(String[] args) {
//        if (args.length != 3) {
//            System.out.println("Usage: java MyProgram <file> <a> <b>");
//            return;
//        }
//
//        int a = Integer.parseInt(args[1]);
//        int b = Integer.parseInt(args[2]);
//
//        try {
//            Scanner scanner = new Scanner(new File(fileName));
//            int sum = 0;
//            while (scanner.hasNextInt()) {
//                int num = scanner.nextInt();
//                if (num % a == 0 || num % b == 0) {
//                    sum += num;
//                }
//            }
//            System.out.println("The sum of numbers divisible by " + a + " or " + b + " in file " + fileName + " is " + sum);
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: " + fileName);
//        }
//    }
//}
