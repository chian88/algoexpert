package NumberOfWaysToTraverseGraph;

public class Program {
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] ways = new int[height+1][width+1];

        for(int i = 1; i < height+1; i++) {
            for (int j = 1; j < width+1; j++) {
                if(i == 1 || j == 1) {
                    ways[i][j] = 1;
                } else {
                    int left = ways[i][j-1];
                    int up = ways[i-1][j];
                    ways[i][j] = left + up;
                }
            }
        }

        return ways[height][width];
    }


    public static void main(String[] args) {
        Program.numberOfWaysToTraverseGraph(2, 3);
    }
}
