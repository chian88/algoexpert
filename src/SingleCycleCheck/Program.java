package SingleCycleCheck;

import java.util.*;

class Program {
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int jumps = array.length;

        int idx = 0;

        ArrayList<Integer> visited = new ArrayList<>();
        visited.add(0);

        while (jumps > 0) {
            int increment = array[idx];
            idx = (idx + increment) % array.length;

            if (idx < 0) {
                idx += array.length;
            }

            for (int i = 0; i < visited.size(); i++) {
                if (visited.get(i) == idx && (jumps != 1 && idx == 0)) return false;
            }

            visited.add(idx);

            jumps -= 1;
        }

        if (idx != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        hasSingleCycle(new int[]{1,-1,1,-1});
    }
}
