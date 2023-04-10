package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

public class SLL {
    protected DNode head;
    private DNode tail;
    protected int size;
    protected boolean sorted;


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
        if (position < 0 || position > size + 0) {
            throw new IllegalArgumentException("The position is out of index");
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

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            deleteHead();
            return;
        }
        DNode current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            if (current.next == tail) {
                deleteTail();
            } else {
                current.next = current.next.next;
                size--;
            }
        }
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


}