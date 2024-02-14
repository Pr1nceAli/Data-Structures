import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


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
    private static ArrayList<Integer> myList = new ArrayList<>();
    private static List<String> myTxtList = List.of("inorder100.txt","inorder1000.txt","inorder10000.txt",
    "random10.txt","random100.txt","random1000.txt","random10000.txt", "reverse100.txt",
         "reverse1000.txt","reverse10000.txt");
    private static ArrayList<Integer> getList(){
        return myList;
    }

    /**
     *This function reads int values from a txt file
     * @param str string value that is the path of txt file.
     */
    public static void readValues(final String str) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(str));

        while(scan.hasNext()) {
            myList.add(Integer.valueOf(scan.next()));
        }

        scan.close();
    }

    /**
     * This function displays an unsorted and sorted list
     */
    private static void displayResult() throws InterruptedException {
        System.out.print("Original list: ");
       for(int num : myList){
           System.out.print(num + " ");
       }
        System.out.println();
       resultShellSort();
       System.out.println();
        System.out.print("Sorted list: ");
        for(int num : myList){
            System.out.print( num + " ");
        }
        System.out.println();

    }

    /**
     * Function that makes a call to the shell sort algorithm.
     * @throws InterruptedException
     */
    private static void resultShellSort() throws InterruptedException {
        Instant start = java.time.Instant.now();
        Thread.sleep(100);
        Instant end = java.time.Instant.now();
        Duration between = java.time.Duration.between(start, end);
        Sorting.shellSort(myList);
        System.out.format("Time %02d miliseconds" , between.toMillis());
    }


    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        for(int i =7; i < 10; i++) {
            System.out.println(myTxtList.get(i));
            readValues(("Files/" + myTxtList.get(i)));
//            System.out.println(myList);
            displayResult();

            System.out.println();
            myList.clear();
        }


    }
}
