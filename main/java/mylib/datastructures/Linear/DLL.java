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
        size--;
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
        System.out.print("List content: ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }




    public static void main(String[] args) {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);
        DNode node5 = new DNode(5);
        
        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.insertTail(node3);
        dll.insert(node4, 2);
        dll.sortedInsert(node5);
        dll.print(); // List content: 2 4 1 5 3
        
        DNode searchResult = dll.search(5);
        if (searchResult != null) {
            System.out.println("Found node with value " + searchResult.data); // Found node with value 5
        } else {
            System.out.println("Node not found");
        }
        
        dll.deleteHead();
        dll.deleteTail();
        dll.delete(node4);
        dll.reverse();
        dll.print(); // List content: 3 1
        
        DLL sortedDll = new DLL(node5);
        sortedDll.sortedInsert(node1);
        sortedDll.sortedInsert(node3);
        sortedDll.sortedInsert(node4);
        sortedDll.sortedInsert(node2);
        sortedDll.print(); // List content: 1 2 3 4 5
    }
}

      