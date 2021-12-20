package MinWaitTime;

import java.util.Arrays;

public class Program {
    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int[] cost = new int[queries.length];
        cost[0] = 0;
        int minCost = 0;

        for (int i = 1; i < queries.length; i++) {
            cost[i] = cost[i-1] + queries[i-1];
        }

        for (int i = 0; i < cost.length; i++) {
            minCost += cost[i];
        }



        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(Program.minimumWaitingTime(new int[]{3,2,1,2,6}));
    }
}
