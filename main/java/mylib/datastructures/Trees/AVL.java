package main.java.mylib.datastructures.Trees;
import main.java.mylib.datastructures.nodes.TNode;


    public class AVL extends BST {
    
        public AVL() {
            super();
        }
        
        public AVL(int val) {
            super(val);
        }
        
        public AVL(TNode obj) {
            super(obj);
            balance(root);
        }
        
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
        
        private int getBalanceFactor(TNode node) {
            if (node == null) {
                return 0;
            }
            
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            
            return leftHeight - rightHeight;
        }
        
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
        
        @Override
        public void insert(int val) {
            super.insert(val);
            balance(getNode(val));
        }
        
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
    
    

    
    private TNode getNode(int val, TNode node) {
        if (node == null || node.data == val) {
            return node;
        } else if (node.data < val) {
            return getNode(val, node.right);
        } else {
            return getNode(val, node.left);
        }
    }
    
    public TNode getNode(int val) {
        return getNode(val, root);
    }




        public static void main(String[] args) {
            AVL avl = new AVL(10);
            avl.insert(5);
            avl.insert(3);
            avl.insert(12);
            avl.insert(15);
            avl.insert(8);
            avl.insert(9);
            
            System.out.println("Printing in-order traversal of AVL tree:");
            avl.printInOrder();
            
            System.out.println("\nPrinting breadth-first traversal of AVL tree:");
            avl.printBF();
            
            System.out.println("\nDeleting node with value 8...");
            avl.delete(8);
            System.out.println("Printing in-order traversal of AVL tree after deletion:");
            avl.printInOrder();
            
            System.out.println("\nDeleting node with value 10...");
            avl.delete(10);
            System.out.println("Printing in-order traversal of AVL tree after deletion:");
            avl.printInOrder();
            
            System.out.println("\nInserting node with value 11...");
            avl.insert(11);
            System.out.println("Printing in-order traversal of AVL tree after insertion:");
            avl.printInOrder();
        }
    
}
    
