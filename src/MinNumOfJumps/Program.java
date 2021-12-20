package MinNumOfJumps;
import java.util.*;

public class Program {
    public static int minNumberOfJumps(int[] array) {
        int[] jumps = new int[array.length];

        Arrays.fill(jumps, Integer.MAX_VALUE);

        jumps[0] = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                // jump + prev indx is more than current idx
                if(array[j] + j >= i) {
                    jumps[i] = Math.min(jumps[i], 1 + jumps[j]);
                }
            }
        }



        return jumps[array.length -1 ];
    }

    public static void main(String[] args) {
        Program.minNumberOfJumps(new int[] {3, 4,2,1,2,3,7,1,1,1,3});
    }
}
