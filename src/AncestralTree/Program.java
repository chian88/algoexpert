package AncestralTree;

import java.util.*;

class Program {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.

        int depthOne = findDepth(descendantOne, topAncestor, 0);
        int depthTwo = findDepth(descendantTwo, topAncestor, 0);

        if (depthOne > depthTwo) {
            descendantOne = bringUpAncestor(descendantOne, depthOne - depthTwo);
        } else {
            descendantTwo = bringUpAncestor(descendantTwo,  depthTwo - depthOne);
        }

        AncestralTree youngestCommonAncestor = findCommonAncestor(descendantOne, descendantTwo);
        return youngestCommonAncestor; // Replace this line
    }

    public static AncestralTree findCommonAncestor(AncestralTree descendentOne, AncestralTree descendentTwo) {
        if (descendentOne.name == descendentTwo.name) return descendentOne;

        return findCommonAncestor(descendentOne.ancestor, descendentTwo.ancestor);
    }

    public static AncestralTree bringUpAncestor(AncestralTree descendent, int level) {
        if (level == 0) return descendent;
        return bringUpAncestor(descendent.ancestor, level -1);
    }

    public static int findDepth(AncestralTree descendent, AncestralTree root, int count) {
        if (descendent.name == root.name) return count;

        count += 1;
        count = findDepth(descendent.ancestor, root, count);
        return count;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static void main(String[] args) {
        AncestralTree a = new AncestralTree('A');
        AncestralTree b = new AncestralTree('B');
        AncestralTree c = new AncestralTree('C');
        a.addAsAncestor(new AncestralTree[]{b,c});
        AncestralTree d = new AncestralTree('D');
        AncestralTree e = new AncestralTree('E');
        b.addAsAncestor(new AncestralTree[]{d, e});
        AncestralTree f = new AncestralTree('F');
        AncestralTree g = new AncestralTree('G');
        c.addAsAncestor(new AncestralTree[]{f, g});
        AncestralTree h = new AncestralTree('H');
        AncestralTree i = new AncestralTree('I');
        d.addAsAncestor(new AncestralTree[]{h, i});


        getYoungestCommonAncestor(a, e, i);
    }
}