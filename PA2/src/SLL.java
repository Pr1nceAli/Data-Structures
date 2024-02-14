/**
 * This class implements a single linked list.
 * @author  Aly Badr
 * @date 01/31/24
 * @version TCSS 342
 */

public class SLL<T extends Comparable<T>> {
    //Initialize the head of the list.
     public Node<T> head;
    //Initialize the size of list.
     public int size;

     public SLL() {
         this.head = null;
         this.size = 0;
     }


    public static class Node<T extends Comparable<T>> {

        Node<T> next;
         T element;

         public Node(T element) {
             this.element = element;
             this.next = null;
         }
    }

    /**
     * check for underflow.
     * @return true if empty & false if not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Getter for the head.
     * @return head of list.
     */
    public Node<T> getHead() {
        return  head;
    }

    /**
     * Setter for the head.
     * @param theHead the node to be set as the new head.
     */
    public void setHead(Node<T> theHead) {
        if (theHead != null) {
            this.head = theHead;
        }
    }



    /**
     * Method to add a new node to front of list.
     * @param theElement generic type.
     */
    public void addFront(final T theElement) {
        Node<T> temp = new Node<>(theElement);
        temp.next =  head;
        head =  temp;
        size++;
    }

    /**
     * Method to add a new node to rear of the list.
     * @param theElement generic type.
     */
    public void addRear (final T theElement) {
        Node<T> temp = new Node<>(theElement);
        if(isEmpty()) {
            head =temp;
        } else {
            Node<T> curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        size++;
    }

    /**
     *  Method to add node anywhere in list.
     * @param theIndex of type int.
     * @param theElement generic type.
     */
    public void add(final int theIndex, final T theElement) {
        if(theIndex < 0 || theIndex > size) {
            throw new IndexOutOfBoundsException("Index is greater than size of list!");
        }
        if(theIndex == 0) { //adding to the front.
            addFront(theElement);
        }else if(theIndex == size) {//adding to the rear.
            addRear(theElement);
        }else {
            Node<T> temp = new Node<>(theElement);
            Node<T> curr =  head;

            for(int i = 0; i< theIndex -1; i++) {
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
            size++;
        }
    }

    /**
     * Method to delete a node in the list.
     * @param theIndex of type int.
     * @return the elem.
     */
    public T delete(final int theIndex) {
        if(theIndex < 0 || theIndex >= size) {
            throw new IndexOutOfBoundsException("Index is greater than the size of the list!");
        }
        T elem;
        //delete on empty list
        if(theIndex == 0) {
            elem = head.element;
            this.head = head.next;
        } else {
            Node<T> curr = head;
            for(int i = 0; i < theIndex - 1; i++) {
                curr = curr.next;
            }
            elem = curr.next.element;
            curr.next = curr.next.next;
        }
        size--;
        return elem;
    }

    /**
     * Method to an element at a certain index.
     * @param theIndex of type int.
     * @return the value of the node.
     */
    public T get(final int theIndex) {
        if(theIndex < 0 || theIndex >= size) {
            throw new IndexOutOfBoundsException("Index is greater than the size or less than!");
        }

        Node<T> curr =  head;
            for(int i = 0; i < theIndex && curr != null;
                i++) {
                curr = curr.next;
            }
        if(curr == null) {
            throw new RuntimeException("Node not found");
        }
        return  curr.element;
    }

    /**
     * Method to get the length of the list.
     * @return the length of the list.
     */
    public int length() {
        int count = 0;
        Node<T> curr =  head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    @Override
    public String toString() {
        String str = "[ " + head.element;
        Node<T> curr =  head.next;
        while(curr != null) {
            str += ", " + curr.element;

            curr = curr.next;
        }
        str += "]";
        return str;
    }


}
