package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

public class QueueLL extends SLL {
    
    public QueueLL() {
        super();
    }

    public QueueLL(DNode head) {
        super(head);
    }

    @Override
    public void insertHead(DNode node) {
     // Not affiliated with Queues
    }

    // Override SLL's sortedInsert method with insertTail method
    @Override
    public void sortedInsert(DNode node) {
        insertTail(node);
    }

    // Override SLL's print method with display method
    @Override
    public void print() {
        display();
    }

    // Method to add an element at the tail of the Queue
    public void enqueue(DNode node) {
        insertTail(node);
    }

    // Method to remove the first element from the Queue
    public void dequeue() {
        deleteHead();
    }

    @Override
    public DNode search(int data) {
        // Not affiliated with Queues
        return null;
    }

    @Override
    public void sort() {
        // Not affiliated with Queues
    }

    @Override
    public void clear() {
        // Not affiliated with Queues
    }

    // Method to display the elements of the Queue
    public void display() {
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
        QueueLL queue = new QueueLL();
        
        // Add some elements to the queue
        queue.enqueue(new DNode(1));
        queue.enqueue(new DNode(2));
        queue.enqueue(new DNode(3));
        
        // Display the queue
        queue.display(); // Expected output: Queue length: 3, Front -> 1 2 3 <- Rear
        
        // Remove an element from the queue
        queue.dequeue();
        
        // Display the queue again
        queue.display(); // Expected output: Queue length: 2, Front -> 2 3 <- Rear
    }
}
