package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;
/**
 * CDLL is a circular doubly-linked list that extends DLL.
 */
public class CDLL extends DLL {

    private DNode head;
    private DNode tail;

    /**
     * Constructs an empty CDLL object.
     */
    public CDLL() {
        super();
    }

    /**
     * Constructs a CDLL object with a specified node as its head and tail.
     *
     * @param node the node to be used as the head and tail of the CDLL
     */
    public CDLL(DNode node) {
        super(node);
        head = node;
        tail = node;
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Inserts a node at the head of the CDLL.
     *
     * @param node the node to be inserted
     */
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

    /**
     * Inserts a node at the tail of the CDLL.
     *
     * @param node the node to be inserted
     */
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

    /**
     * Inserts a node at the specified position in the CDLL.
     *
     * @param node     the node to be inserted
     * @param position the position at which to insert the node
     */
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

    /**
     * Deletes the node at the head of the CDLL.
     */
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

    /**
     * Deletes the node at the tail of the CDLL.
     */
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

    /**
     * Deletes a specified node from the CDLL.
     *
     * @param node the node to be deleted
     */
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


    /**
    Reverses the order of the elements in the circular doubly linked list.
    If the list is empty or contains only one element, no changes are made.
    This method modifies the list in place.
    */
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

    /**
    Prints the contents of the circular doubly linked list to the console.
    If the list is empty, the message "empty" is printed.
    */
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
}
