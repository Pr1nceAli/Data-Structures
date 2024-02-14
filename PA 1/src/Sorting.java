import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program implements the Shell Sort algorithm.
 *
 * @author Aly Badr
 * @date 01/10/24
 * @version Winter 24'
 */

public class Sorting {
    /**
     *  passes counter
     */
    private static int PASS = 0;
    /**
     * comparison counter
     */
    private static int CMP = 0;
    /**
     * exchange counter;
     */
    private static int EXH = 0;
    private static int k = 1;//gap;


    /**
     * Function that takes a list as an input and sorts it using the shell sort algorithm.
     * @param theList of type integer.
     */
  public static void shellSort(List<Integer> theList) {
     int length = theList.size();
      System.out.println("\tk\t\tpass\t\tcmp\t\t\texh");
      System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");


      //initial value of k/gap
     while(k <= length/3) {
         k = k * 3 + 1;

     }
      PASS++;
     while(k > 0) {
         //pass
         for(int i = k; i < length; i++) {
             Integer temp = theList.get(i);
             int j = i;
             while(j > k-1 && theList.get(j - k) >= temp) {
                 theList.set(j, theList.get(j-k));
                 j = j-k;
                 EXH++;
             }
             theList.set(j, temp);
             CMP++;//cmp

         }

         System.out.print("\t" + k + "\t\t\t" + PASS + "\t\t\t" + CMP +
                 "\t\t" + EXH + "\t\t\tCurrent list: ");
         // print the current sorted list
         for (Integer num : theList) {
             System.out.print(num + " ");
         }
         System.out.println();

         k = (k-1)/3;

     }
      System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
      System.out.println("Total\t\t" + PASS + "\t\t\t" + CMP + "\t\t\t" + EXH);
  }









}










/*
Shell sort :
1. start
2. initialize the value of gap size
3. divide the list into smaller sub-part
4. sort these sub-lists using insertion sort
5. repeat this step 2 until the list is sorted
6. print a sorted list
7. stop
 */