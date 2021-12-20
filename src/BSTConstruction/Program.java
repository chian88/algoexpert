package BSTConstruction;

public class Program {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            inserts(this, value);
            return this;
        }

        public BST inserts(BST tree, int value) {
            /*
            if value is smaller than tree.value, traverse left
            if value is bigger than tree.value , traverse right
             */

            if (tree.value > value && tree.left == null) {
                tree.left = new BST(value);
                return tree;
            } else if (tree.value <= value && tree.right == null) {
                tree.right = new BST(value);
                return tree;
            } else if (tree.value > value) {
                return inserts(tree.left, value);
            } else {
                return inserts(tree.right, value);
            }

        }

        public boolean contains(int value) {
            // Write your code here.
            return containss(this, value);
        }

        public boolean containss(BST tree, int value) {
            if(tree.value == value) {
                return true;
            } else if (tree.value > value && tree.left != null) {
                return containss(tree.left, value);
            } else if (tree.value < value && tree.right != null) {
                return containss(tree.right, value);
            }
            return false;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            removes(this, value);
            return this;
        }

        public void removes(BST tree, int value) {

            if (tree.value == value && tree.left != null && tree.right != null) {
                // remove node with two child
                BST newRoot = findMinNode(tree.right);
                if (newRoot.left == null) {
                    tree.value = newRoot.value;
                    tree.right = null;
                } else if (newRoot.left != null) {
                    tree.value = newRoot.left.value;
                    newRoot.left = null;
                }

            } else if (tree.value == value && tree.left != null) {
                tree.value = tree.left.value;
                tree.left = tree.left.left;
            } else if (tree.value == value && tree.right != null) {
                tree.value = tree.right.value;
                tree.right = tree.right.right;
            } else if (tree.left != null && tree.left.value == value && tree.left.left != null && tree.left.right != null) {


                BST newRoot = findMinNode(tree.left.right);
                if (newRoot.left == null) {
                    tree.left.value = newRoot.value;
                    tree.left.right = null;
                } else if (newRoot.left != null) {
                    tree.left.value = newRoot.left.value;
                    newRoot.left = null;
                }
            } else if (tree.right != null && tree.right.value == value && tree.right.right != null && tree.right.left != null) {
                BST newRoot = findMinNode(tree.right.right);
                if (newRoot.left == null) {
                    tree.right.value = newRoot.value;
                    tree.right.right = null;
                } else if (newRoot.left != null) {
                    tree.right.value = newRoot.left.value;
                    newRoot.left = null;
                }
            } else if (tree.left != null && tree.left.value == value && tree.left.left != null) {
                tree.left = tree.left.left;
            } else if (tree.right != null && tree.right.value == value && tree.right.right != null) {
                tree.right = tree.right.right;
            } else if (tree.left != null && tree.left.value == value && tree.left.left == null && tree.left.right == null) {
                tree.left = null;
            } else if (tree.right != null && tree.right.value == value && tree.right.left == null && tree.right.right == null) {
                tree.right = null;
            } else if (tree.value > value) {
                removes(tree.left, value);
            } else if (tree.value < value) {
                removes(tree.right, value);
            }
        }

        public BST findMinNode(BST tree) {
            BST parent = tree;
            while(tree.left != null) {
                parent = tree;
                tree = tree.left;

            }
            return parent;
        }




        public static void main(String[] args) {
            BST root = new BST(10);
            root.insert(5);
            root.insert(15);
            root.insert(2);
            root.insert(5);
            root.insert(13);
            root.insert(22);
            root.insert(1);
            root.insert(14);
            root.insert(12);
            root.remove(5);
            root.remove(5);
            root.remove(12);
            root.remove(13);
            root.remove(14);
            root.remove(22);
            root.remove(2);
            root.remove(1);
            root.contains(15);
        }
    }
}
