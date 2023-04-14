package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.Nodes.DNode;

/**
 * This is a class for a doubly linked list
 */

public class DLL {
    /**
     * Contains values for the head and tail of the DNode
     * an integer variable with the size of the list
     * a boolean variable for whether the list is sorted or not
     */
    private DNode head;
    private DNode tail;
    protected int size;
    protected boolean sorted;

    public DLL() {
         /**
         * default constructor for DLL
         * sets the head and tails of the DNode to null, and size to 0
         * the sorted flag is set to true
         */
        head = null;
        tail = null;
        size = 0;
        sorted = true;
    }

    public DLL(DNode head) {
        /**
         * Constructor for DLL, sets the head and tail reference to head, and size to 1
         * The sorted flag is true because there is only one element
         * @param head of DNode
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
            head.prev = node;
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
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
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
        */
        if (position < 0 || position > size ) {
            System.out.println("Invalid position");
            return;
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
        node.prev = current;
        current.next.prev = node;
        current.next = node;
        size++;
        sorted = false;
    }

    public void sort() {
        /** 
         * This method sorts the list in ascending order
         * It also sets the sorted boolean to true
        */
        if (size <= 1) {
            return;
        }
        DNode current = head;
        while (current.next != null) {
            DNode minNode = current;
            DNode search = current.next;
            while (search != null) {
                if (search.data < minNode.data) {
                    minNode = search;
                }
                search = search.next;
            }
            if (minNode != current) {
                int temp = current.data;
                current.data = minNode.data;
                minNode.data = temp;
            }
            current = current.next;
        }
        sorted = true;
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
        node.prev = current;
        current.next.prev = node;
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
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    public void deleteTail() {
        /**
         * this method deletes the tail of the list, and decrememnts the size of the list by 1
         */
        if (tail == null) {
            return;
        }
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
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


    public void reverse() {
        /**
         * This method reverse all the values in the linked list
         */
        if (head == null) {
            return;
        }
        DNode current = head;
        while (current != null) {
            DNode temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        DNode temp = head;
        head = tail;
        tail = temp;
    }

 
  
    public void print() {
        /**
         * this method prints out various attributed about the list
         */
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + sorted);
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


    public void clear() {
        /** 
         * This method clears the list, sets size to 0, and the sorted boolean to false
         */
        head = null;
        tail = null;
        size = 0;
        sorted = false;
    }

    public static void main(String[] args){
        DNode n1 = new DNode(1);
        DNode n2 = new DNode(2);
        DNode n3 = new DNode(3);
        DNode n4 = new DNode(4);


        System.out.println("Test constructor with node input of 1");
        DLL test1 = new DLL(n1);
        test1.print();
        System.out.println();

        System.out.println("Test Default constructor and insert head with value of 2 and insert tail with value of 3");
        DLL test = new DLL();
        test.insertHead(n2);
        test.insertTail(n3);
        test.print();
        System.out.println();

        System.out.println("Insert 1 at index 1 and Insert 4 at index 3");
        test.insert(n1, 1);
        test.insert(n4, 3);
        test.print();
        System.out.println();
      
        System.out.println("Test sort");
        test.sort();
        test.print();
        System.out.println();

        System.out.println("Test reverse");
        test.reverse();
        test.print();
        System.out.println();

        System.out.println("\nTest search of value 3");
        System.out.println(test.search(3).data);


        System.out.println("\nTesting remove with value of 2 and then removing the head and tail");
        test.delete(n2);
        test.deleteHead();
        test.deleteTail();
        test.print();
        System.out.println();

        System.out.println("Test clear");
        test.clear();
        test.print();
    }
}





      