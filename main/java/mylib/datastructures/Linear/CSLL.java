package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;



/**

CSLL is a circular singly linked list that extends the SLL class.

It adds the functionality to maintain a reference to the tail of the list and supports circular traversal.
*/


public class CSLL extends SLL{

    /**
    Reference to the tail of the list.
    */
    private DNode tail;


    /**
    Constructs an empty circular singly linked list.
    */
    public CSLL() {
        super();
        tail = null;
    }

    /**
    Constructs a circular singly linked list with the given head node.
    @param head the first node of the list
    */
    public CSLL(DNode head) {
        super(head);
        tail = head;
        tail.next = head;
    }

    /**
    Inserts a node at the beginning of the list.
    @param node the node to insert
    */
    @Override
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.next = node;
        } else {
            node.next = head;
            head = node;
            tail.next = node;
        }
        size++;
        sorted = false;
    }

    /**
    Inserts a node at the end of the list.
    @param node the node to insert
    */
    @Override
    public void insertTail(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.next = node;
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
        size++;
        sorted = false;
    }



    /**
    Inserts a node at the given position in the list.
    @param node the node to insert
    @param position the position at which to insert the node
    */
    @Override
    public void insert(DNode node, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            insertHead(node);
            return;
        }
        if (position == size + 1) {
            insertTail(node);
            return;
        }
        DNode current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
        sorted = false;
    }


    /**
    Deletes the first node of the list.
    */
    @Override
    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
    }


    /**
    Deletes the last node of the list.
    */

    @Override
    public void deleteTail() {
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
            current.next = head;
            tail = current;
        }
        size--;
    }



    /**
    Deletes all nodes and information
    */
    @Override
    public void clear() {
        super.clear();
        tail = null;
    }




    /**
    Prints all the information
    */
    @Override
    public void print() {
        super.print();


        if(tail != null){
            System.out.println("Tail: " + tail.data);
        }
        else{
            System.out.println("Tail: ");

        }
    }
    public static void main(String[] args) {

        DNode n1 = new DNode(1);
        DNode n2 = new DNode(2);
        DNode n3 = new DNode(3);

        System.out.println("Test constructor with node input and then inserting 2 at head ");
        CSLL list1 = new CSLL(n1);
        list1.insertHead(n2);
        list1.print(); // Should print: 2,1 Tail: 1
        System.out.println();


        System.out.println("Test default constructor and then inserting 1 at head ");
        CSLL list = new CSLL();
        list.insertHead(n1);
        list.print(); // Should print: 1, Tail: 1
        System.out.println();

        System.out.println("Test inserting 2 at tail");
        list.insertTail(n2);
        list.print(); // Should print: 1, 2, Tail: 2
        System.out.println();

        System.out.println("Test inserting 3 at position 2");
        list.insert(n3, 2);
        list.print(); // Should print: 1, 3, 2, Tail: 2
        System.out.println();

        System.out.println("Test deleting a tail");
        list.deleteTail();
        list.print(); // Should print: 1,3 Tail: 3
        System.out.println();

        System.out.println("Test delete a head");
        list.deleteHead();
        list.print(); // Should print: 3 Tail: 2
        System.out.println();

        System.out.println("Test clearing the list");
        list.clear();
        list.print(); // Should print nothing
    }

    }
