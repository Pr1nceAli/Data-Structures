
/**
 * This program implements the Shell Sort algorithm.
 *
 * @author Aly Badr
 * @date 01/10/24
 * @version Winter 24'
 */

public class Sorting<T extends Comparable<T>> {
    /**
     * passes counter
     */
    private int PASS = 0;
    /**
     * comparison counter
     */
    private int CMP = 0;
    /**
     * exchange counter;
     */
    private int EXH = 0;
   /**
    Gap variable.
    */
    private int k = 1;//gap
    /**
       Variable to keep track of swap.
     */
    private boolean swap = true;


/**
     * Function that takes a list as an input and sorts it using the shell sort algorithm.
     *
     * @param list of type integer.
     */
    public void shellSort(SLL<Integer> list) {
        int length = list.length();
        System.out.println("\tk\t\tpass\t\tcmp\t\t\texh");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");


        //initial value of k/gap
        while (k < length / 3) {
            k = k * 3 + 1;
        }
        while (k > 0) {
            while(swap) {
                swap = false;
                PASS++;
                for (int i = 0; i < length - k; i++) {
                    SLL.Node<Integer> curr = getNode(list, i);
                    SLL.Node<Integer> next = getNode(list, i + k);
                    while (curr != null && next != null) {
                        if (curr.element > next.element) {
                            swap(curr, next);
                            curr = getNode(list, i);
                            next = getNode(list, i + k);
                            swap = true;
                            EXH++;
                        } else {// Update the current and next references after swapping.
                            curr = curr.next;
                            next = next.next;
                        }
                        CMP++;
                    }
                }
                System.out.print("\t" + k + "\t\t\t" + PASS + "\t\t\t" + CMP +
                        "\t\t" + EXH + "\t\t\tCurrent list: ");
                // print the current sorted list
                System.out.print(list);
                System.out.println();

                k = (k - 1) / 3;
            }
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Total\t\t" + PASS + "\t\t\t" + CMP + "\t\t\t" + EXH);
    }

    /**
     * Method to grab a node.
     * @param theList passed in linked list.
     * @param theIndex the current index of list.
     * @return node.
     */
    private SLL.Node<Integer> getNode(SLL<Integer> theList, int theIndex) {
        SLL.Node<Integer> node = theList.getHead();

        while (theIndex > 0 && node != null) {
            node = node.next;
            theIndex--;
        }
        return node;
    }

    /**
     * Method to swap the nodes.
     * @param theNode1 Node to be swapped.
     * @param theNode2 Node to be swapped with.
     */
    private void swap(SLL.Node<Integer> theNode1, SLL.Node<Integer> theNode2) {
        if(theNode1 != null && theNode2 != null) {
            int temp = theNode1.element;
            theNode1.element = theNode2.element;
            theNode2.element = temp;
        }
    }
}

/*public SLL.Node<Integer> getNode(final SLL.Node<Integer> node, final int theIndex) {

        SLL.Node<Integer> curr = node;
        for (int i = 0; i < theIndex && curr != null;
             i++) {
            curr = curr.next;

        }
        return curr;
    }*//*


*/
/*for (int j = 0; j < length - i - k; j++) {
                    if (next != null && curr.element > next.element) {//compare
                        SLL.Node<Integer> temp = next.next;//temp tp swap
                        next.next = curr.next;
                        curr.next = temp;


                        if (i == 0) {
                            list.setHead(next);
                        } else {
                            SLL.Node<Integer> prev1 = getNode(list.getHead(), i - 1);
                            prev1.next = next;

                            SLL.Node<Integer> prev2 = getNode(list.getHead(), i + k - 1);
                            prev2.next = curr;
                        }*/


