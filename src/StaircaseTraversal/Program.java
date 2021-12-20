package StaircaseTraversal;

import java.util.*;

class Program {

    public static int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        int ans = staircaseTraversalHelper(height, maxSteps, map);


        return -1;
    }

    static int staircaseTraversalHelper(int step , int maxSteps, Map<Integer, Integer> map ) {
        if (step == 1) return 1;
        if (step == 0) return 1;

        if (map.containsKey(step)) {
            return map.get(step);
        }

        int totalStep = 0;

        for (int i = 1; i <= Math.min(step, maxSteps); i++) {
            totalStep += staircaseTraversalHelper(step - i, maxSteps, map);
        }
        map.put(step, totalStep);


        return totalStep;
    }

    public static void main(String[] args) {
        staircaseTraversal(4, 2);
    }
}
