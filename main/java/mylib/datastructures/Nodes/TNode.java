package main.java.mylib.datastructures.Nodes;


    /**
     * A class representing a general tree node
     */
    public class TNode {
        /** data stored in the node*/
    public int data;
        /** left child of the node*/
    public TNode left;
        /** right child of the node*/
    public TNode right;
        /** parent  of the node*/
    public TNode parent;
        /** balance of the node*/
    public int balance;

    public TNode() {
        /** Default constructor, */
        data = 0;
        left = null;
        right = null;
        parent = null;
        balance = 0;
    }

    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        /** TNode costructor with following values
        * @param data for the data stored in the node
        * @param balance which is the balance factor
        * @param parent is the parent of the node
        * @param left is the left child of the node
        * @param right is the right child of the TNode
        */
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public int getData() {
         /**
         * getter method for data
         * @return the data stored in the node
         */
        return data;
    }

    public void setData(int data) {
         /**
         * setter method for data
         * @param the data value to be set for TNode
         */
        this.data = data;
    }

    public TNode getLeft() {
         /**
         * getter method for left child
         * @return the left child for the node
         */
        return left;
    }

    public void setLeft(TNode left) {
        /**
         * setter method for left child
         * @param the left child to be set for TNode
         */
        this.left = left;
    }

    public TNode getRight() {
        /**
         * getter method for right child
         * @return the right child for the node
         */
        return right;
    }

    public void setRight(TNode right) {
        /**
         * setter method for right child
         * @param the right child to be set for TNode
         */
        this.right = right;
    }

    public TNode getParent() {
        /**
         * getter method for Parent
         * @return the Parent of the node
         */
        return parent;
    }

    public void setParent(TNode parent) {
        /**
         * setter method for parent 
         * @param the parent to be set for TNode
         */
        this.parent = parent;
    }

    public int getBalance() {
        /**
         * getter method for balance factor
         * @return the value of the balance factor of the TNode
         */
        return balance;
    }

    public void setBalance(int balance) {
        /**
         * setter method for balance factor
         * @param the balance value to be set for TNode
         */
        this.balance = balance;
    }

    public void print() {
        /**
         * This method prints the data and balance of the TNode
         * It prints it in a formatted way
         */
        System.out.println("Node data: " + data + ", balance: " + balance);
    }

    @Override
    public String toString() {
        /**
         * This method is to change the value to a string
         * @return the data value for TNode as a string
         */
        return Integer.toString(data);
    }
}
