package main.java.mylib.datastructures.Trees;
import main.java.mylib.datastructures.Nodes.TNode;

    /**
     * AVL is a self-balancing binary search tree that extends the BST class.
     * It uses rotations to maintain a balanced tree with a maximum height of log(n).
     */
    public class AVL extends BST {
    
         
    /**
     * Creates an empty AVL tree.
     */
    public AVL() {
        super();
    }
    
    /**
     * Creates an AVL tree with a single node with the given value.
     * 
     * @param val the value of the node to be created
     */
    public AVL(int val) {
        super(val);
    }
    
    /**
     * Creates an AVL tree with the given root node and balances the tree.
     * 
     * @param obj the root node of the tree
     */
    public AVL(TNode obj) {
        super(obj);
        balance(root);
    }
    
    /**
     * Balances the subtree rooted at the given node using rotations.
     * 
     * @param node the root of the subtree to be balanced
     */
    private void balance(TNode node) {
        if (node == null) {
            return;
        }
        
        int balanceFactor = getBalanceFactor(node);
        
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        
        if (node.parent != null) {
            balance(node.parent);
        } else {
            root = node;
        }
    }
    
    /**
     * Returns the balance factor of the given node.
     * 
     * @param node the node whose balance factor is to be computed
     * @return the balance factor of the node
     */
    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return leftHeight - rightHeight;
    }
    
    /**
     * Rotates the subtree rooted at the given node to the left.
     * 
     * @param node the root of the subtree to be rotated
     * @return the new root of the subtree
     */
    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.right;
        node.right = newRoot.left;
        if (newRoot.left != null) {
            newRoot.left.parent = node;
        }
        newRoot.left = node;
        newRoot.parent = node.parent;
        node.parent = newRoot;
        return newRoot;
    }
    
    /**
     * Rotates the subtree rooted at the given node to the right.
     * 
     * @param node the root of the subtree to be rotated
     * @return the new root of the subtree
     */
    private TNode rotateRight(TNode node) {
        TNode newRoot = node.left;
        node.left = newRoot.right;
        if (newRoot.right != null) {
            newRoot.right.parent = node;
        }
        newRoot.right = node;
        newRoot.parent = node.parent;
        node.parent = newRoot;
        return newRoot;
    }


        /**
        Inserts a new integer value into the AVL tree.
        @param val the integer value to insert
        */
        @Override
        public void insert(int val) {
            TNode newNode = new TNode(val, 0, null, null, null);
            if (root == null) {
                root = newNode;
            } else {
                TNode currNode = root;
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

        
        /**
        Updates the balance of the tree after inserting a new node.
        @param node the node that was just inserted
        */
                
        private void updateBalance(TNode node) {
            if (node == null) {
                return;
            }
        }

        /**
        Inserts a new TNode object into the AVL tree.
        @param node the TNode object to insert
        */
        @Override
        public void insert(TNode node) {
            super.insert(node);
            balance(node);
        }
        
        
        private int height(TNode node) {
            if (node == null) {
                return -1;
            }
            
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    
    

        /**
     * Recursive method to search for a node with the given value in the AVL tree.
     * Starting from the specified node, the method will traverse the tree
     * recursively to find the node with the specified value.
     *
     * @param val the value to search for
     * @param node the starting node for the search
     * @return the node with the specified value, or null if not found
     */
    private TNode geTNode(int val, TNode node) {
        if (node == null || node.data == val) {
            return node;
        } else if (node.data < val) {
            return geTNode(val, node.right);
        } else {
            return geTNode(val, node.left);
        }
    }

    /**
     * Public method to search for a node with the given value in the AVL tree.
     * Starting from the root node, the method will traverse the tree recursively
     * to find the node with the specified value.
     *
     * @param val the value to search for
     * @return the node with the specified value, or null if not found
     */
        
    public TNode geTNode(int val) {
        return geTNode(val, root);
    }
 
    
    public static void main(String[] args) {

        System.out.println("Test constructor with value input of 10 and insert values of 1,2,3,7,8,9 ");
        AVL avl = new AVL(10);
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(7);
        avl.insert(8);
        avl.insert(9);
        System.out.println();
        
        System.out.println("Test Print in order");
        avl.printInOrder();
        System.out.println();

        System.out.println("Test PrintBF ");
        avl.printBF();
        System.out.println();

        System.out.println("Test Delete with a value 3");
        avl.delete(3);
        avl.printInOrder();
        System.out.println();


        
    }
    


}
    
