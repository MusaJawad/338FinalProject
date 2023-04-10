package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL {
    private DNode head;
    private DNode tail;
    protected int size;
    protected boolean sorted;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
        sorted = true;
    }

    public DLL(DNode head) {
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
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
        sorted = false;
    }

    public void insertTail(DNode node) {
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
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + sorted);
        System.out.print("List content: ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public void clear() {
        head = null;
        tail = null;
        size = 0;
        sorted = false;
    }

   
    public static void main(String[] args){
        DNode node = new DNode(2);
        DNode node1 = new DNode(10);
        DNode node2 = new DNode(4);
        DNode node3 = new DNode(1);
        DNode node4 = new DNode(12);
        DLL test = new DLL(node);
        DLL test1 = new DLL();
        // Testing methods:
        System.out.println("For test (Overloaded CTOR)");
        test.insert(node1, 1);
        test.insert(node2, 2);
        test.insert(node3, 3);
        test.insert(node4, 4);
        test.print();
        System.out.println("\nFor test (Default CTOR)");
        test1.insertHead(node2);
        test1.insert(node1, 1);
        test1.insert(node3, 2);
        test1.print();
        System.out.println("\nTesting sorting");
        test.sort();
        test.print();
        System.out.println("\nTesting searching");
        System.out.println(test.search(10).data); // Expected 10

        System.out.println("\nTesting removal");
        test.delete(node2);
        test.deleteHead();
        test.deleteTail();
        test.print();
    }
}



      