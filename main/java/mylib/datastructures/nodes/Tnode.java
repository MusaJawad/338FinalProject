package main.java.mylib.datastructures.nodes;

    /**
     * A class representing a general tree node
     */
public class Tnode {
        /** data stored in the node*/
    public int data;
        /** left child of the node*/
    public Tnode left;
        /** right child of the node*/
    public Tnode right;
        /** parent  of the node*/
    public Tnode parent;
        /** balance of the node*/
    public int balance;

    public Tnode() {
        /** Default constructor, */
        data = 0;
        left = null;
        right = null;
        parent = null;
        balance = 0;
    }

    public Tnode(int data, int balance, Tnode parent, Tnode left, Tnode right) {
        /** Tnode costructor with following values
        * @param data for the data stored in the node
        * @param balance which is the balance factor
        * @param parent is the parent of the node
        * @param left is the left child of the node
        * @param right is the right child of the Tnode
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
         * @param the data value to be set for Tnode
         */
        this.data = data;
    }

    public Tnode getLeft() {
         /**
         * getter method for left child
         * @return the left child for the node
         */
        return left;
    }

    public void setLeft(Tnode left) {
        /**
         * setter method for left child
         * @param the left child to be set for Tnode
         */
        this.left = left;
    }

    public Tnode getRight() {
        /**
         * getter method for right child
         * @return the right child for the node
         */
        return right;
    }

    public void setRight(Tnode right) {
        /**
         * setter method for right child
         * @param the right child to be set for Tnode
         */
        this.right = right;
    }

    public Tnode getParent() {
        /**
         * getter method for Parent
         * @return the Parent of the node
         */
        return parent;
    }

    public void setParent(Tnode parent) {
        /**
         * setter method for parent 
         * @param the parent to be set for Tnode
         */
        this.parent = parent;
    }

    public int getBalance() {
        /**
         * getter method for balance factor
         * @return the value of the balance factor of the Tnode
         */
        return balance;
    }

    public void setBalance(int balance) {
        /**
         * setter method for balance factor
         * @param the balance value to be set for Tnode
         */
        this.balance = balance;
    }

    public void print() {
        /**
         * This method prints the data and balance of the Tnode
         * It prints it in a formatted way
         */
        System.out.println("Node data: " + data + ", balance: " + balance);
    }

    @Override
    public String toString() {
        /**
         * This method is to change the value to a string
         * @return the data value for Tnode as a string
         */
        return Integer.toString(data);
    }
}


