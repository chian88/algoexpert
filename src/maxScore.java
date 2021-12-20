import java.util.*;

public class maxScore {

    static int dp[][] = new int[200][200];

    static boolean leftBag[][] = new boolean[200][200];

    static int max(ArrayList<Integer> money) {
        int n = money.size();
        int totalTurn = n;

        boolean turn = (totalTurn % 2 == 0) ? false : true; // even if  false

        for (int i = 0; i < n; i++) {
            dp[i][i] = turn ? money.get(i) : 0;
            leftBag[i][i] = true;
        }


        turn = !turn;

        int sz = 1;

        while (sz < n) {
            for (int i = 0; i + sz < n; i++) {
                int scoreOne = dp[i + 1][i + sz];
                int scoreTwo = dp[i][i + sz - 1];

                if (turn) {
                    dp[i][i + sz] = Math.max(money.get(i)+ scoreOne, money.get(i + sz) + scoreTwo);

                    if (money.get(i) + scoreOne > money.get(i + sz) + scoreTwo) {
                        leftBag[i][i + sz] = true;
                    } else {
                        leftBag[i][i + sz] = false;
                    }
                } else {
                    dp[i][i + sz]  = Math.min(scoreOne, scoreTwo);

                    if (scoreOne < scoreTwo)
                        leftBag[i][i + sz] = true;

                    else
                        leftBag[i][i + sz] = false;
                }
            }
            turn = !turn;
            sz++;
        }

        return dp[0][n-1];

    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(80);
        arr.add(90);
        arr.add(30);


        int ans = max(arr);

        System.out.println(ans);
    }

}
