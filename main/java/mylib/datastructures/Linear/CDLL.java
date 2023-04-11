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
        head = node;
        tail = node;
        head.next = tail;
        tail.prev = head;
    }

   @Override
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            head.next = tail;
            tail.prev = head;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = tail;
            tail.next = head;
        }
        size++;
    }

    @Override
    public void insertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
            head.next = tail;
            tail.prev = head;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
            tail.next = head;
            head.prev = tail;
        }
        size++;
    }

    @Override
    public void insert(DNode node, int position) {
        if (position == 0) {
            insertHead(node);
        } else {
            DNode current = head;
            int i = 0;
            while (current != null && i < position - 1) {
                current = current.next;
                i++;
            }
            if (current == null) {
                insertTail(node);
            } else {
                node.next = current.next;
                current.next.prev = node;
                current.next = node;
                node.prev = current;
            }
        }
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
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }
    
    @Override
    public void deleteTail() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }

    @Override
    public void delete(DNode node) {
        if (node == null) {
            return;
        }
        if (node == head) {
            deleteHead();
            return;
        }
        if (node == tail) {
            deleteTail();
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    @Override
    public void reverse() {
        if (head == null || head == tail) {
            return;
        }
    
        DNode current = head;
        DNode temp = null;
    
        do {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        } while (current != head);
    
        temp = head;
        head = tail;
        tail = temp;
    }

    @Override
    public void print() {
        System.out.print("List content: ");
        if (head != null) {
            DNode current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
        } else {
            System.out.print("empty");
        }
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
