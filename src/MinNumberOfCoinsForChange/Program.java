package MinNumberOfCoinsForChange;

import java.util.Arrays;

public class Program {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] minCoin = new int[n + 1];
        Arrays.fill(minCoin, Integer.MAX_VALUE);

        minCoin[0] = 0;
        int toCompare = 0;
        for (int denom : denoms) {
            for (int amount = 1; amount < n+1; amount++) {
                if (denom <= amount) {
                    if(minCoin[amount - denom] == Integer.MAX_VALUE) {
                        toCompare = minCoin[amount - denom];
                    } else {
                        // used up a coin, then add 1 more coin to (amount-denom)
                        toCompare = minCoin[amount - denom] + 1;
                    }
                }

                minCoin[amount] = Math.min(minCoin[amount], toCompare);
            }
        }

        return minCoin[n] != Integer.MAX_VALUE ? minCoin[n] : -1;
    }

    public static void main(String[] args) {
        System.out.println(Program.minNumberOfCoinsForChange(7, new int[]{1, 5 , 10}));
    }
}
