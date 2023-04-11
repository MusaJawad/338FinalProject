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
            tail.next = node;
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
            node.next = head;
            tail = node;
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


        if(tail != null){
            System.out.println("Tail: " + tail.data);
        }
        else{
            System.out.println("Tail: ");

        }
    }





        public static void main(String[] args) {
            CSLL list = new CSLL();
    
            
            System.out.println("Insert 1 at head");
            DNode node1 = new DNode(1);
            list.insertHead(node1);
            list.print(); // Should print: 1, Tail: 1
            System.out.println();
    
            System.out.println("// Insert 2 at tail");
            DNode node2 = new DNode(2);
            list.insertTail(node2);
            list.print(); // Should print: 1, 2, Tail: 2
            System.out.println();
  
            System.out.println("// Insert 3 at position 2");
            DNode node3 = new DNode(3);
            list.insert(node3, 2);
            list.print(); // Should print: 1, 3, 2, Tail: 2
            System.out.println();
  

            System.out.println("// Delete head");
            list.deleteHead();
            list.print(); // Should print: 3, 2, Tail: 2
            System.out.println();
  
            System.out.println("// Delete tail");
            list.deleteTail();
            list.print(); // Should print: 3, Tail: 3
            System.out.println();
  
            System.out.println("// Clear the list");
            list.clear();
            list.print(); // Should print nothing
        }
    }
