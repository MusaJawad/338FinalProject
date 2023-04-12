package main.java.mylib.datastructures.nodes;

/**
This class a general representation of a node in a doubly linked list
*/
public class DNode {
    /**
     * Contains the data variable for the node,
     * The reference to the previous node,
     * and the reference to the next node in the list.
     */
    public int data;
    public DNode prev;
    public DNode next;

    public DNode(int data) {
        /** 
         * This is a constructor for the Dnode
         * @param data value for the Dnode
         */
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}