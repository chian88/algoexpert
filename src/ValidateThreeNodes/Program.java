package ValidateThreeNodes;
import java.util.*;
public class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Write your code here.

        boolean oneChildOfTwo = false;
        if (nodeOne.value != nodeTwo.value) {
            oneChildOfTwo = checkDescendent(nodeTwo, nodeOne);
        }

        boolean twoChildOfThree = false;
        if(oneChildOfTwo == true && nodeThree.value != nodeTwo.value) {
            twoChildOfThree = checkDescendent(nodeThree, nodeTwo);
        }


        boolean threeChildOfTwo = false;
        if (nodeThree.value != nodeTwo.value) {
            threeChildOfTwo = checkDescendent(nodeTwo, nodeThree);
        }

        boolean twoChildOfOne = false;
        if (threeChildOfTwo && nodeOne.value != nodeTwo.value) {
            twoChildOfOne =  checkDescendent(nodeOne, nodeTwo);
        }

        return (oneChildOfTwo && twoChildOfThree) || (threeChildOfTwo && twoChildOfOne);
    }

    public static boolean checkDescendent(BST parent, BST child) {
        boolean leftResult = false;
        boolean rightResult = false;
        if(parent == null) return false;
        if (parent.value == child.value) return true;


        if (parent.value > child.value) {
            // go left
            leftResult = checkDescendent(parent.left, child);
        } else {
            // go right
            rightResult = checkDescendent(parent.right, child);
        }
        return (leftResult || rightResult);
    }

    public static void main(String[] args) {
        BST five = new BST(5);
        BST two = new BST(2);
        BST seven = new BST(7);
        BST one = new BST(1);
        BST four = new BST(4);
        BST six = new BST(6);
        BST eight = new BST(8);
        BST zero = new BST(0);
        BST three = new BST(3);

        five.left = two;
        five.right = seven;
        two.left = one;
        two.right = four;
        one.left = zero;
        four.left = three;
        seven.left = six;
        seven.right = eight;

        validateThreeNodes(three, two, five);
    }
}
