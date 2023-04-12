package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;
/**
 * This is a class for a singly linked list
 */
public class SLL {
    /**
     * Contains values for the head and tail of the Dnode
     * an integer variable with the size of the list
     * a boolean variable for whether the list is sorted or not
     */
    protected DNode head;
    private DNode tail;
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

    public SLL(DNode head) {
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

    public void insertHead(DNode node) {
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

    public void insertTail(DNode node) {    
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

   
    public void insert(DNode node, int position) {
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
        DNode current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
        sorted = false;
    }

    
    public void sortedInsert(DNode node) {
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
        DNode current = head;
        while (current.next != null && current.next.data < node.data) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }

    public DNode search(int data) {
        /**
         * This method searches the list for a node with a specified value
         * @param the information about the noted that is wanted to be searched for
         * @return the node with the data value, or null if not in list
         */
        DNode current = head;
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
            DNode current = head;
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
        DNode current = head;
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

    public void delete(DNode node) {
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
        DNode current = head;

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
        DNode sortedHead = null;
        DNode current = head;
        while (current != null) {
            DNode next = current.next;
            if (sortedHead == null || current.data < sortedHead.data) {
                current.next = sortedHead;
                sortedHead = current;
            } else {
                DNode search = sortedHead;
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
        DNode current = head;
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
        DNode current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }


    public static void main(String[] args) {
        SLL myList = new SLL();

        // Add nodes to the list
        myList.insertTail(new DNode(1));
        myList.insertTail(new DNode(4));
        myList.insertHead(new DNode(5));
        myList.insert(new DNode(7), 1);
        myList.insert(new DNode(3), 3);

        // Print the list
        System.out.println("Original list:");
        myList.print();

        // Search for a node
        DNode searchResult = myList.search(4);
        System.out.println("Search result:"+searchResult.data);
   

        // Delete a node
        
        DNode tmpp = new DNode(2);
        myList.insertTail(tmpp);
        System.out.println("List contents:");
        myList.print();
        myList.delete(tmpp);
        System.out.println("List after deleting node containing 2:");
        myList.print();

        // Sort the list
        myList.sort();
        System.out.println("List after sorting:");
        myList.print();

        // Delete the head and tail of the list
        myList.deleteHead();
        myList.deleteTail();
        System.out.println("List after deleting head and tail:");
        myList.print();

        // Add a node at position 1
        myList.insert(new DNode(6), 1);
        System.out.println("List after adding node 6 at position 1:");
        myList.print();

    }

}