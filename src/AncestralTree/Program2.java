package AncestralTree;

import java.util.*;

public class Program2 {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        List<AncestralTree> ancestorsOne = findAncestors(descendantOne, new ArrayList<AncestralTree>(), topAncestor);
        List<AncestralTree> ancestorsTwo = findAncestors(descendantTwo, new ArrayList<AncestralTree>(), topAncestor);

        for (AncestralTree tree1 : ancestorsOne) {
            for (AncestralTree tree2 : ancestorsTwo) {
                if (tree1.name == tree2.name) return tree1;
            }
        }

        return topAncestor; // Replace this line
    }

    public static List<AncestralTree> findAncestors(AncestralTree descendant, List<AncestralTree> ancestors, AncestralTree root) {
        if (descendant.name == root.name) {
            ancestors.add(root);
            return ancestors;
        }

        ancestors.add(descendant);
        return findAncestors(descendant.ancestor, ancestors, root);
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
