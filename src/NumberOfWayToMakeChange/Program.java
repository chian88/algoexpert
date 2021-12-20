package NumberOfWayToMakeChange;

public class Program {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n+1];

        ways[0] = 0;

        for (int denom : denoms) {
            for(int amount = 1 ; amount < n+1; amount++) {
                if (denom <= amount) {
                    ways[amount] = ways[amount] + ways[amount - denom];
                }
            }
        }

        return ways[n];
    }

    public static void main(String[] args) {
        Program.numberOfWaysToMakeChange(10, new int[]{1, 5, 10, 25});
    }
}
