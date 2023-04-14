package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.Nodes.DNode;

/**
 * This class is a stack based off a singly linked list 
 */

public class StackLL extends SLL{
    public StackLL() {
        /**
         * default constructor for stack
         */
        super();
    }

    public void push(DNode node) {
        /**
         * This methods adds a new node at the top of the stack
         * @param the node to be added
         */
        insertHead(node);
    }

    public void pop() {
        /**
         * this method deletes the top node from the stack
         */
        deleteHead();
    }

    public DNode peek() {
        /**
         * This method gives the top node of the stack
         * @return the top node of the stack
         */
        return head;
    }

    @Override
    public void insertTail(DNode node) {
        /**
         * Overrides the method from SLL because it is not affiliated with stacks
         */
        // Not affiliated with stacks
    }

    @Override
    public void insert(DNode node, int position) {
        /**
         * Overrides the method from SLL because it is not affiliated with stacks
         */
        // Not affiliated with stacks    
    }

    @Override
    public void sortedInsert(DNode node) {
        /**
         * Overrides the method from SLL because it is not affiliated with stacks
         */
        // Not affiliated with stacks
        }

    @Override
    public void deleteTail() {
        /**
         * Overrides the method from SLL because it is not affiliated with stacks
         */
        // Not affiliated with stacks
        }

    @Override
    public void delete(DNode node) {
        /**
         * Overrides the method from SLL because it is not affiliated with stacks
         */
        // Not affiliated with stacks
        }

    @Override
    public void sort() {
        /**
         * Overrides the method from SLL because it is not affiliated with stacks
         */
        // Not affiliated with stacks
    }

        public static void main(String[] args) {

            System.out.println("Test default constructor and push with values of 1,2,3");
            StackLL stack = new StackLL();
            stack.push(new DNode(1));
            stack.push(new DNode(2));
            stack.push(new DNode(3));
            stack.print(); // Expected output: List length: 3, Sorted status: false, List content: 3 2 1
            System.out.println();

            System.out.println("Test pop");
            stack.pop();
            stack.print(); // Expected output: List length: 2, Sorted status: false, List content: 2 1
            System.out.println();

            System.out.println("Test peak");
            DNode top = stack.peek();
            System.out.println(top.data); // Expected output: 2
        }
}
