import java.util.ArrayList;

public class MinCost {

     static int findMinProfit(ArrayList<Integer> profit, ArrayList<Integer> time, int n, int p) {
        int dp[][] = new int[p+1][n+1];

        for (int currentProfit = 0; currentProfit < p; currentProfit++) {
            for (int currentQuestion = 0; currentQuestion < n; currentQuestion++) {
                if (currentProfit==0){
                    dp[currentProfit][currentQuestion] = 0;
                }
                else if (currentQuestion==0) {
                    dp[currentProfit][currentQuestion] = Integer.MAX_VALUE;
                }

                else {
                    int excl = dp[currentProfit][currentQuestion-1];
                    int incl = time.get(currentQuestion);

                    if (currentProfit - profit.get(currentQuestion) > 0) {
                        if (dp[currentProfit - profit.get(currentQuestion)][currentQuestion-1] == Integer.MAX_VALUE) {
                            incl = Integer.MAX_VALUE;
                        } else {
                            incl += dp[currentProfit - profit.get(currentQuestion)][currentQuestion-1];
                        }
                    }

                    dp[currentProfit][currentQuestion] = Math.min(incl, excl);

                }
            }
        }

        return dp[p][n];
    }

    public static void main(String[] args) {

        ArrayList<Integer> profit = new ArrayList<>();
        profit.add(2);
        profit.add(6);
        profit.add(5);
        profit.add(4);
        profit.add(7);

        ArrayList<Integer> time = new ArrayList<>();
        time.add(8);
        time.add(11);
        time.add(9);
        time.add(10);
        time.add(12);

        int ans = findMinProfit(profit, time, 5, 10);

        System.out.println(ans);

    }
}
