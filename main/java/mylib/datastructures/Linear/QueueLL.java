package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.Nodes.DNode;

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

    public static void main(String[] args) {

        System.out.println("Test constructor with node input 1");
        QueueLL queue1 = new QueueLL(new DNode(1));
        queue1.display();
        System.out.println();


        System.out.println("Test default constructor and enqueue with values 1,2 and 3");
        QueueLL queue = new QueueLL();
        queue.enqueue(new DNode(1));
        queue.enqueue(new DNode(2));
        queue.enqueue(new DNode(3));
        queue.display(); // Expected output: Queue length: 3, Front -> 1 2 3 <- Rear
        System.out.println();

        System.out.println("Test dequeue with values 1,2 and 3");
        queue.dequeue();
        queue.display(); // Expected output: Queue length: 2, Front -> 2 3 <- Rear
    }
    
}
