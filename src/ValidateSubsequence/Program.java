package ValidateSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int subPointer = 0;

        for (int i = 0 ; i < array.size(); i++) {
            if (array.get(i) == sequence.get(subPointer)) {
                subPointer++;
            }
            if (subPointer == sequence.size()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList(Arrays.asList(5,1,22,25,6,-1,8,10));
        List<Integer> sequence = new ArrayList(Arrays.asList(25));
        Program.isValidSubsequence(array, sequence);
    }
}
