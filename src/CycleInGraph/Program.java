package CycleInGraph;

import java.util.*;

class Program {

    public static boolean cycleInGraph(int[][] edges) {
        // Write your code here.

        for (int i = 0 ; i < edges.length; i++) {
            if(depthFirstSearchForCycle(edges, i, new ArrayList<Integer>())) {
                return true;
            };
        }

        return false;
    }

    public static boolean depthFirstSearchForCycle(int[][] edges, int currentIdx, List<Integer> ancestors) {
        if (ancestors.contains(currentIdx)) return true;
        int[] nodes = edges[currentIdx];
        ancestors.add(currentIdx);

        for (int i = 0 ; i < nodes.length; i ++) {
            int childIdx = nodes[i];
            if(depthFirstSearchForCycle(edges, childIdx, ancestors)) {
                return true;
            };
        }

        ancestors.remove(Integer.valueOf(currentIdx));
        return false;
    }

    public static void main(String[] args) {
        cycleInGraph(new int[][]{{0}});
    }
}
