import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;


/**
 *  The function of this file is to read txt file of ints
 *  and from this create an array list of the txt file ints.
 *
 * @author Aly Badr
 * @date 01-13-24
 * @version Winter 24'
 */
public class Tester {
    /**
     * Global defining of int array list.
     */
    private static SLL<Integer> myList = new SLL<>();
    private static final List<String> myTxtList = List.of("inorder100.txt","inorder1000.txt","inorder10000.txt",
            "random10.txt","random100.txt","random1000.txt","random10000.txt", "reverse100.txt",
            "reverse1000.txt","reverse10000.txt");
    private static SLL<Integer> getList(){
        return myList;
    }

    /**
     *This function reads int values from a txt file
     * @param str string value that is the path of txt file.
     */
    public static void readValues(final String str) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(str));
        int index = 0;
        while(scan.hasNext()) {
            myList.add(index,Integer.valueOf(scan.next()));
            index++;
        }

        scan.close();
    }

    /**
     * This function displays an unsorted and sorted list
     */
    private static void displayResult() throws InterruptedException {
        System.out.print("Original list: ");
        System.out.print(myList.toString());
        System.out.println();
        resultShellSort();
        System.out.println();
        System.out.print("Sorted list: ");
        System.out.print(myList.toString());
        System.out.println();

    }

    /**
     * Function that makes a call to the shell sort algorithm.
     * @throws InterruptedException should an error occur.
     */
    private static void resultShellSort() throws InterruptedException {
        Sorting s = new Sorting();
        s.shellSort(myList);

    }


    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Instant start = java.time.Instant.now();
        Thread.sleep(0);
        for(int i = 6 ; i < 7; i++) {
            System.out.println(myTxtList.get(i));
            readValues(("Files/" + myTxtList.get(i)));
//            System.out.println(myList);
            displayResult();
            Instant end = java.time.Instant.now();
            Duration between = java.time.Duration.between(start, end);
            System.out.format("Time %02d miliseconds" , between.toMillis());
            System.out.println();
//            myList.clear();
        }


    }
}
