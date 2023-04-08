package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CSLL extends SLL{
    private DNode tail;

    public CSLL() {
        super();
        tail = null;
    }

    public CSLL(DNode head) {
        super(head);
        tail = head;
        tail.next = head;
    }

    @Override
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.next = node;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
        sorted = false;
    }

    @Override
    public void insertTail(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.next = node;
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        size++;
        sorted = false;
    }

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

    @Override
    public void clear() {
        super.clear();
        tail = null;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Tail: " + tail.data);
    }


public static void main(String[] args) {

    // Test insertHead
    CSLL csll = new CSLL();
    csll.insertHead(new DNode(1));
    csll.insertHead(new DNode(2));
    csll.insertHead(new DNode(3));
    csll.print(); // Expected output: List length: 3, Sorted status: false, List content: 3 2 1, Tail: 1

    // Test insertTail
    csll.insertTail(new DNode(4));
    csll.insertTail(new DNode(5));
    csll.print(); // Expected output: List length: 5, Sorted status: false, List content: 3 2 1 4 5, Tail: 5

    // Test insert at position
    csll.insert(new DNode(6), 2);
    csll.insert(new DNode(7), 6);
    csll.print(); // Expected output: List length: 7, Sorted status: false, List content: 3 6 2 1 4 5 7, Tail: 7

    // Test sortedInsert
    csll.sortedInsert(new DNode(0));
    csll.sortedInsert(new DNode(8));
    csll.print(); // Expected output: List length: 9, Sorted status: true, List content: 0 1 2 3 4 5 6 7 8, Tail: 8

    // Test search
    DNode node = csll.search(4);
    System.out.println(node.data); // Expected output: 4

    // Test deleteHead
    csll.deleteHead();
    csll.print(); // Expected output: List length: 8, Sorted status: true, List content: 1 2 3 4 5 6 7 8, Tail: 8

    // Test deleteTail
    csll.deleteTail();
    csll.print(); // Expected output: List length: 7, Sorted status: true, List content: 1 2 3 4 5 6 7, Tail: 7

    // Test delete
    node = csll.search(3);
    csll.delete(node);
    csll.print(); // Expected output: List length: 6, Sorted status: true, List content: 1 2 4 5 6 7, Tail: 7

    // Test clear
    csll.clear();
    csll.print(); // Expected output: List length: 0, Sorted status: true, List content: , Tail: null

}
}
