package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL{
    private DNode head;
    private DNode tail;
    public CDLL() {
        super();
    }

    public CDLL(DNode node) {
        super(node);
        head.prev = tail;
        tail.next = head;
    }

    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        head.prev = tail;
        tail.next = head;
    }

    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        head.prev = tail;
        tail.next = head;
    }

    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        head.prev = tail;
        tail.next = head;
    }

    @Override
    public void deleteHead() {
        super.deleteHead();
        head.prev = tail;
        tail.next = head;
    }

    @Override
    public void deleteTail() {
        super.deleteTail();
        head.prev = tail;
        tail.next = head;
    }

    @Override
    public void delete(DNode node) {
        super.delete(node);
        head.prev = tail;
        tail.next = head;
    }

    @Override
    public void reverse() {
        super.reverse();
        head.prev = tail;
        tail.next = head;
    }

    @Override
    public void print() {
        System.out.print("List content: ");
        DNode current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        // Test constructor and insertHead
        CDLL cdll = new CDLL(new DNode(1));
        cdll.insertHead(new DNode(2));
        cdll.insertHead(new DNode(3));
        cdll.print(); // Expected output: List content: 3 2 1
    
        // Test insertTail
        cdll.insertTail(new DNode(4));
        cdll.insertTail(new DNode(5));
        cdll.print(); // Expected output: List content: 3 2 1 4 5
    
        // Test insert at position
        cdll.insert(new DNode(6), 2);
        cdll.insert(new DNode(7), 6);
        cdll.print(); // Expected output: List content: 3 2 6 1 4 5 7
    
        // Test deleteHead
        cdll.deleteHead();
        cdll.print(); // Expected output: List content: 2 6 1 4 5 7
    
        // Test deleteTail
        cdll.deleteTail();
        cdll.print(); // Expected output: List content: 2 6 1 4 5
    
        // Test delete
        DNode node = cdll.search(4);
        cdll.delete(node);
        cdll.print(); // Expected output: List content: 2 6 1 5
    
        // Test reverse
        cdll.reverse();
        cdll.print(); // Expected output: List content: 5 1 6 2
    
    }
}
