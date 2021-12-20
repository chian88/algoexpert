package maxProfitWithKTransaction;

public class Program {
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if(prices.length == 0) return 0;
        int[][] structure = new int[k + 1][prices.length];

        for (int i = 0; i < k + 1; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (i == 0 || j == 0) {
                    structure[i][j] = 0;
                } else {
                    // not selling today
                    int yesterdayMaxProfit = structure[i][j-1];

                    // sell today - get today prices, then buy at prices of previous day + profit of previous day.
                    int priceToday = prices[j];

                    int maxProfitYesterday = Integer.MIN_VALUE;
                    for (int x = 0; x < j; x++) {
                        int priceYesterday = prices[x];
                        int profitYesterday = structure[i-1][x];

                        if ((priceYesterday * -1 + profitYesterday) > maxProfitYesterday) {
                            maxProfitYesterday = (priceYesterday * -1 + profitYesterday);
                        }
                    }

                    structure[i][j] = Math.max(yesterdayMaxProfit, priceToday + maxProfitYesterday);

                }
            }
        }


        return structure[k][prices.length-1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{5,11,3,50,60,90};
        int k = 2;

        System.out.println(maxProfitWithKTransactions(prices, k));
    }
}
