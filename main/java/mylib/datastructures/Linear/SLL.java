package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

public class SLL {
    private DNode head;
    private DNode tail;
    private int size;
    private boolean sorted;


    public SLL() {
        head = null;
        tail = null;
        size = 0;
        sorted = true;
    }

    public SLL(DNode head) {
        this.head = head;
        this.tail = head;
        size = 1;
        sorted = true;
    }

    public void insertHead(DNode node) {
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

    public void sortedInsert(DNode node) {
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
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

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
            current.next = null;
            tail = current;
        }
        size--;
    }

    public void delete(DNode node) {
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
        while (current.next != node) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }
    public void sort() {
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
        head = null;
        tail = null;
        size = 0;
    }
    
    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + isSorted());
        System.out.print("List content: ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    private boolean isSorted() {
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

        // Test insertHead
        SLL sll = new SLL();
        sll.insertHead(new DNode(1));
        sll.insertHead(new DNode(2));
        sll.insertHead(new DNode(3));
        sll.print(); // Expected output: List length: 3, Sorted status: false, List content: 3 2 1

        // Test insertTail
        sll.insertTail(new DNode(4));
        sll.insertTail(new DNode(5));
        sll.print(); // Expected output: List length: 5, Sorted status: false, List content: 3 2 1 4 5

        // Test insert at position
        sll.insert(new DNode(6), 2);
        sll.insert(new DNode(7), 6);
        sll.print(); // Expected output: List length: 7, Sorted status: false, List content: 3 6 2 1 4 5 7

        // Test sortedInsert
        sll.sortedInsert(new DNode(0));
        sll.sortedInsert(new DNode(8));
        sll.print(); // Expected output: List length: 9, Sorted status: true, List content: 0 1 2 3 4 5 6 7 8

        // Test search
        DNode node = sll.search(4);
        System.out.println(node.data); // Expected output: 4

        // Test deleteHead
        sll.deleteHead();
        sll.print(); // Expected output: List length: 8, Sorted status: true, List content: 1 2 3 4 5 6 7 8

        // Test deleteTail
        sll.deleteTail();
        sll.print(); // Expected output: List length: 7, Sorted status: true, List content: 1 2 3 4 5 6 7

        // Test delete
        node = sll.search(3);
        sll.delete(node);
        sll.print(); // Expected output: List length: 6, Sorted status: true, List content: 1 2 4 5 6 7

        // Test clear
        sll.clear();
        sll.print(); // Expected output: List length: 0, Sorted status: true, List content: 

    }

}