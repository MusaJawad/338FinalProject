package main.java.mylib.datastructures.Trees;
import java.util.LinkedList;
import java.util.Queue;

import main.java.mylib.datastructures.nodes.Tnode;

public class BST {
    protected Tnode root;
    
    // Default constructor
    public BST() {
        root = null;
    }
    
    // Overloaded constructor with root value
    public BST(int val) {
        root = new Tnode(val, 0, null, null, null);
    }
    
    // Overloaded constructor with Tnode object as root
    public BST(Tnode obj) {
        root = obj;
    }
    
    // Getter for root
    public Tnode getRoot() {
        return root;
    }
    
    // Setter for root
    public void setRoot(Tnode node) {
        root = node;
    }
    
    // Inserts new node with value val into the BST
    public void insert(int val) {
        Tnode newNode = new Tnode(val, 0, null, null, null);
        if (root == null) {
            root = newNode;
        } else {
            Tnode currNode = root;
            while (true) {
                if (val < currNode.getData()) {
                    if (currNode.getLeft() == null) {
                        currNode.setLeft(newNode);
                        newNode.setParent(currNode);
                        updateBalance(newNode);
                        break;
                    }
                    currNode = currNode.getLeft();
                } else {
                    if (currNode.getRight() == null) {
                        currNode.setRight(newNode);
                        newNode.setParent(currNode);
                        updateBalance(newNode);
                        break;
                    }
                    currNode = currNode.getRight();
                }
            }
        }
    }
    private void updateBalance(Tnode node) {
        if (node == null) {
            return;
        }
    
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.balance = rightHeight - leftHeight;
    
        if (node.parent != null) {
            if (node == node.parent.left) {
                node.parent.balance--;
            } else {
                node.parent.balance++;
            }
            if (node.parent.balance != 0) {
                updateBalance(node.parent);
            }
        }
    }
    
    private int height(Tnode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    // Inserts existing node into the BST
    public void insert(Tnode node) {
        if (root == null) {
            root = node;
        } else {
            Tnode currNode = root;
            while (true) {
                if (node.getData() < currNode.getData()) {
                    if (currNode.getLeft() == null) {
                        currNode.setLeft(node);
                        node.setParent(currNode);
                        updateBalance(node);
                        break;
                    }
                    currNode = currNode.getLeft();
                } else {
                    if (currNode.getRight() == null) {
                        currNode.setRight(node);
                        node.setParent(currNode);
                        updateBalance(node);
                        break;
                    }
                    currNode = currNode.getRight();
                }
            }
        }
    }
    
    // Deletes node with value val from the BST
    /**
 * Deletes the node with the given value from the tree.
 *
 * @param val The value of the node to delete.
 */
public void delete(int val) {
    root = delete(root, val);
}

/**
 * Deletes the node with the given value from the tree rooted at the given node.
 *
 * @param node The root of the tree to delete from.
 * @param val The value of the node to delete.
 * @return The root of the modified tree.
 */
private Tnode delete(Tnode node, int val) {
    if (node == null) {
        System.out.println("Value " + val + " is not in the tree.");
        return null;
    }

    if (val < node.getData()) {
        node.setLeft(delete(node.getLeft(), val));
    } else if (val > node.getData()) {
        node.setRight(delete(node.getRight(), val));
    } else {
        if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        }

        Tnode successor = getSuccessor(node.getRight());
        node.setData(successor.getData());
        node.setRight(delete(node.getRight(), successor.getData()));
    }

    return node;
}

/**
 * Gets the node that comes after the given node in the tree.
 *
 * @param node The node to find the successor of.
 * @return The successor node.
 */
private Tnode getSuccessor(Tnode node) {
    Tnode current = node;
    while (current.getLeft() != null) {
        current = current.getLeft();
    }
    return current;
}

/**
 * Searches for a node with the given value in the tree.
 *
 * @param val The value to search for.
 * @return The node with the given value, or null if it is not found.
 */
public Tnode search(int val) {
    Tnode current = root;
    while (current != null) {
        if (val == current.getData()) {
            return current;
        } else if (val < current.getData()) {
            current = current.getLeft();
        } else {
            current = current.getRight();
        }
    }
    return null;
}

/**
 * Prints the contents of the tree in ascending order.
 */


public void printInOrder() {
    printInOrder(root);
    System.out.println();
}

private void printInOrder(Tnode node) {
    if (node == null) {
        return;
    }
    printInOrder(node.left);
    System.out.print(node.data + " ");
    printInOrder(node.right);
}
/**
 * Prints the contents of the tree in Breadth-First order, each level of the
 * tree will be printed on a separate line.
 */
public void printBF() {
    if (root == null) {
        return;
    }

    Queue<Tnode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Tnode node = queue.remove();
            System.out.print(node.getData() + " ");
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        System.out.println();
    }
}

    public static void main(String[] args) {

        System.out.println("Test default constructor and insert values of 5,3,7,1,9,4,6,8");
        BST bst = new BST();
        // Insert some nodes into the BST
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        System.out.println();

        
        System.out.println("Test Print in order");  
        bst.printInOrder();
        System.out.println();
        System.out.println();

        System.out.println("Test PrintBF");  
        bst.printBF();
        System.out.println();
        System.out.println();


        System.out.println("test deleting with value 5 ");
        bst.delete(5);        
        bst.printInOrder();
        System.out.println();
        

        System.out.println("Test search value of 7");
        Tnode node = bst.search(7);
        if (node != null) {
            System.out.println("Found node with value " + node.getData());
        } else {
            System.out.println("Node not found");
        }
    }

}

