package MergeOverlappingIntervals;

import java.util.*;

class Program {

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int previousLongestTail = Integer.MIN_VALUE;
        boolean extend = false;
        boolean newWord = true;

        List<Integer[]> result = new ArrayList<Integer[]>();
        Integer[] temp = new Integer[2];

        for (int i = 0; i < intervals.length - 1; i++) {
            int[] currentInterval = intervals[i];
            int[] nextInterval = intervals[i+1];

            if (newWord == true) {
                temp = new Integer[]{currentInterval[0], null};
                previousLongestTail = currentInterval[1];
            }

            if (previousLongestTail >= nextInterval[0]) {
                previousLongestTail = Math.max(previousLongestTail, nextInterval[1]);
                newWord = false;
            } else {
                newWord = true;
                temp[1] = previousLongestTail;
                result.add(temp);
            }
        }
        int[] lastInterval = intervals[intervals.length - 1];
        if (newWord == true) {
            Integer[] lastTemp = new Integer[]{lastInterval[0], lastInterval[1]};
            result.add(lastTemp);
        } else {
            temp[1] = Math.max(previousLongestTail, lastInterval[1]);
            result.add(temp);
        }

        int[][] answer = new int[result.size()][2];

        for (int i = 0 ; i < result.size(); i++) {
            answer[i][0] = result.get(i)[0];
            answer[i][1] = result.get(i)[1];

        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] interval = new int[][]{{2,3}, {4,5}, {6,7}, {8,9}, {1,10}};

        mergeOverlappingIntervals(interval);
    }
}

