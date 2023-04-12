package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

/**
 * This class is a Queue data structure based off a singly linked list 
 */

public class QueueLL extends SLL {
    
    public QueueLL() {
        /**
         * default constructor for Queue
         */
        super();
    }

    public QueueLL(DNode head) {
        /**
         * Constructor for queue with a specific head node
         * @param Node for head
         */
        super(head);
    }

    @Override
    public void insertHead(DNode node) {
        /**
         * Overrides the method from SLL because it is not affiliated with Queues
         */
     // Not affiliated with Queues
    }

    /**
     * Override SLL's sortedInsert method with insertTail method
     */
    @Override
    public void sortedInsert(DNode node) {
        insertTail(node);
    }

    /**
     * Override SLL's print method with display method
     */
    @Override
    public void print() {
        display();
    }

    public void enqueue(DNode node) {
        /**
         * This method adds a node at the tail of the Queue
         */
        insertTail(node);
    }

    public void dequeue() {
        /**
         * This method removes the node at the top of the Queue
         */
        deleteHead();
    }

    @Override
    public DNode search(int data) {
        /**
         * Overrides the method from SLL because it is not affiliated with queues
         */
        return null;
    }

    @Override
    public void sort() {
        /**
         * Overrides the method from SLL because it is not affiliated with queues
         */
    }

    @Override
    public void clear() {
        /**
         * Overrides the method from SLL because it is not affiliated with queues
         */
    }

    public void display() {
        /**
         * This method displays all the elements of the Queue
         */
        System.out.println("Queue length: " + size);
        System.out.println("Front -> ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("<- Rear");
    }

    
}
