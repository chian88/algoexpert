package MoveElementToEnd;
import java.util.*;

public class Program {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int i = 0;
        int j = array.size() - 1;

        while (i < j) {
            if (array.get(i) == toMove && array.get(j) == toMove) {
                j--;
            } else if (array.get(i) == toMove) {
                int start = array.get(i);
                array.set(i, array.get(j));
                array.set(j, start);
                i++;
                j--;
            } else {
                i++;
            }
        }

        return array;
    }
}
