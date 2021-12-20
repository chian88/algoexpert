public class CoinGame {

    public static int solve(int[] A) {
        int[][] MV = new int[A.length][A.length];

        for (int interval = 0; interval < A.length; interval++) {
            for (int i = 0, j = interval; j < A.length; i++, j++) {
                // a = MV(i+2,j) - Alice chooses i Bob chooses i+1
                // b = MV(i+1,j-1)- Alice chooses i , Bob chooses j OR
                // Alice chooses j , Bob chooses i
                // c = MV(i,j-2)- Alice chooses j , Bob chooses j-1
                int a, b, c;
                if (i + 2 <= j)
                    a = MV[i + 2][j];
                else
                    a = 0;
                //////////////////////////////////
                if (i + 1 <= j - 1)
                    b = MV[i + 1][j - 1];
                else
                    b = 0;
                //////////////////////////////////
                if (i <= j - 2)
                    c = MV[i][j - 2];
                else
                    c = 0;
                //////////////////////////////////
                MV[i][j] = Math
                        .max(A[i] + Math.min(a, b), A[j] + Math.min(b, c));
            }
        }
        return MV[0][A.length - 1];
    }

    public static void main(String[] args) {
        int[] B = { 6, 9,1,2,16,8};
        System.out.println("Max value pick up by player1(Alice) " + solve(B));
    }
}