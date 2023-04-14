package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.Dnode;
/**
 * This is a class for a singly linked list
 */
public class SLL {
    /**
     * Contains values for the head and tail of the Dnode
     * an integer variable with the size of the list
     * a boolean variable for whether the list is sorted or not
     */
    protected Dnode head;
    private Dnode tail;
    protected int size;
    protected boolean sorted;


    public SLL() {
        /**
         * default constructor for SLL
         * sets the head and tails of the Dnode to null, and size to 0
         * the sorted flag is set to true
         */
        head = null;
        tail = null;
        size = 0;
        sorted = true;
    }

    public SLL(Dnode head) {
        /**
         * Constructor for SLl, sets the head and tail reference to head, and size to 1
         * The sorted flag is true because there is only one element
         * @param head of Dnode
         */
        this.head = head;
        this.tail = head;
        size = 1;
        sorted = true;
    }

    public void insertHead(Dnode node) {
        /**
         * This method inserts a new node at the head of the list.
         * The size is increased by 1, and it is not sorted
         * @param the node to be set as the new head of the list
        */
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        sorted = false;
    }

    public void insertTail(Dnode node) {    
        /**
        * This method inserts a new node at the tail of the list.
        * The size is increased by 1, and it is not sorted
        * @param the node to be set as the new tail of the list
       */
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        sorted = false;
    }

   
    public void insert(Dnode node, int position) {
        /**
         * This method inserts a new node at the a specified position of the list.
         * The size is increased by 1, and it is not sorted
         * There are checks if the position is the front or end of the list, or in between
         * The node is then placed in the position specified
         * @param node: the node to be added to the list
         * @param position: the position the node will be added in the list
         * @throws IllegalArgumentException if the position parameter is out of bounds
        */
        if (position < 0 || position > size + 0) {
            throw new IllegalArgumentException("The position is out of index");
        }
        if (position == 0) {
            insertHead(node);
            return;
        }
        if (position == size) {
            insertTail(node);
            return;
        }
        Dnode current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
        sorted = false;
    }

    
    public void sortedInsert(Dnode node) {
        /**
         * this method inserts a node into the list with sorted order.
         * @param node to be added to list
         */
        if (!sorted) {
            sort();
        }
        if (head == null || node.data < head.data) {
            insertHead(node);
            return;
        }
        if (node.data >= tail.data) {
            insertTail(node);
            return;
        }
        Dnode current = head;
        while (current.next != null && current.next.data < node.data) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }

    public Dnode search(int data) {
        /**
         * This method searches the list for a node with a specified value
         * @param the information about the noted that is wanted to be searched for
         * @return the node with the data value, or null if not in list
         */
        Dnode current = head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteHead() {
        /**
         * this method deletes the head of the list, and decrememnts the size of the list by 1
         */
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteTail() {
        /**
         * this method deletes the tail of the list, and decrememnts the size of the list by 1
         */
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Dnode current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    public void delete(int data) {
        /**
         * this method deletes the first occurance of a node with the specified data value of the list, and decrememnts the size of the list by 1
         * @param the specified data value of the node to be deleted
         */
        if (head == null) {
            return;
        }
        if (head.data == data) {
            deleteHead();
            return;
        }
        Dnode current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            if (current.next == tail) {
                deleteTail();
            } else {
                current.next = current.next.next;
                size--;
            }
        }
    }

    public void delete(Dnode node) {
        /**
         * this method deletes the first occurance of a node in the list, and decrememnts the size of the list by 1
         * @param the specified node to be deleted
         */
        if (head == null) {
            return;
        }
        if (head == node) {
            deleteHead();
            return;
        }
        if (tail == node) {
            deleteTail();
            return;
        }
        Dnode current = head;

        while (current.next != node && current.next != null) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }        
    }

    public void sort() {
        /** 
         * This method sorts the list in ascending order
         * It also sets the sorted boolean to true
        */
        if (size <= 1) {
            return;
        }
        Dnode sortedHead = null;
        Dnode current = head;
        while (current != null) {
            Dnode next = current.next;
            if (sortedHead == null || current.data < sortedHead.data) {
                current.next = sortedHead;
                sortedHead = current;
            } else {
                Dnode search = sortedHead;
                while (search.next != null && current.data > search.next.data) {
                    search = search.next;
                }
                current.next = search.next;
                search.next = current;
            }
            current = next;
        }
        head = sortedHead;
        sorted = true;
    }
    
    public void clear() {
        /**
         * clears the linked list
         */
        head = null;
        tail = null;
        size = 0;
    }
    
    public void print() {
        /**
         * this method prints out various attributed about the list
         */
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + isSorted());
        System.out.print("List content: ");
        Dnode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
            if (current == head) { // added condition to break out of the loop
                break;
            }
        }
        System.out.println();
    }
    
    
    private boolean isSorted() {
        /**
         * this method checks if the list is sorted
         * @return boolean of whether the list is sorted or not
         */
        if (size <= 1) {
            return true;
        }
        Dnode current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
    public static void main(String[] args) {

        Dnode n = new Dnode(0);
        Dnode n1 = new Dnode(1);
        Dnode n2 = new Dnode(2);
        Dnode n3 = new Dnode(3);
        Dnode n4 = new Dnode(4);
        Dnode n5 = new Dnode(5);
        Dnode n6 = new Dnode(6);
        Dnode n7 = new Dnode(7);


        System.out.println("Test constructor with node input 1");
        SLL sll1 = new SLL(n1);
        sll1.print();
        System.out.println();

        System.out.println("Test default constructor and 2 insertHeads with values of 1 and 2");
        SLL sll = new SLL();
        sll.insertHead(n1);
        sll.insertHead(n2);
        sll.print(); // Expected output: List length: 2, Sorted status: false, List content:  2 1
        System.out.println();

        System.out.println("Test insertTail with value of 3"); 
        sll.insertTail(n3);
        sll.print(); // Expected output: List length: 3, Sorted status: false, List content: 2 1 3
        System.out.println();

        System.out.println("Test insert 6 at position 2"); 
        sll.insert(n6, 2);
        sll.print(); // Expected output: List length: 7, Sorted status: false, List content: 2 6 1 3
        System.out.println();


        System.out.println("Test sortedInsert with value of 7"); 
        sll.sortedInsert(n7);
        sll.print(); // Expected output: List length: 9, Sorted status: true, List content: 1 2 3 6
        System.out.println();


        System.out.println("Test search data 3"); 
        Dnode node = sll.search(3);
        System.out.println(node.data); // Expected output: 3
        System.out.println();

        System.out.println("Test deleteHead"); 
        sll.deleteHead();
        sll.print(); // Expected output: List length: 8, Sorted status: true, List content: 2 3 6
        System.out.println();

        System.out.println("Test deleteTail"); 
        sll.deleteTail();
        sll.print(); // Expected output: List length: 7, Sorted status: true, List content: 2 3
        System.out.println();

        System.out.println("Test delete value 3"); 
        node = sll.search(3);
        sll.delete(node);
        sll.print(); // Expected output: List length: 6, Sorted status: true, List content: 2
        System.out.println();

        System.out.println("Test clear"); 
        sll.clear();
        sll.print(); // Expected output: List length: 0, Sorted status: true, List content: 

    }

}