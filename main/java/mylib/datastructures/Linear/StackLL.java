package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

public class StackLL extends SLL{
    public StackLL() {
        super();
    }

    public void push(DNode node) {
        insertHead(node);
    }

    public void pop() {
        deleteHead();
    }

    public DNode peek() {
        return head;
    }

    @Override
    public void insertTail(DNode node) {
        // Not affiliated with stacks
    }

    @Override
    public void insert(DNode node, int position) {
        // Not affiliated with stacks    
    }

    @Override
    public void sortedInsert(DNode node) {
        // Not affiliated with stacks
        }

    @Override
    public void deleteTail() {
        // Not affiliated with stacks
        }

    @Override
    public void delete(DNode node) {
        // Not affiliated with stacks
        }

    @Override
    public void sort() {
        // Not affiliated with stacks
        }

    public static void main(String[] args) {
        // Test StackLL
        StackLL stack = new StackLL();
        stack.push(new DNode(1));
        stack.push(new DNode(2));
        stack.push(new DNode(3));
        stack.print(); // Expected output: List length: 3, Sorted status: false, List content: 3 2 1
        stack.pop();
        stack.print(); // Expected output: List length: 2, Sorted status: false, List content: 2 1
        DNode top = stack.peek();
        System.out.println(top.data); // Expected output: 2
    }
}
