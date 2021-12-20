package SameBST;
import java.util.*;

public class Program {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.
        if(arrayOne.size() == 0 && arrayTwo.size() == 0) return true;

        if (arrayOne.get(0) != arrayTwo.get(0)) return false;
        if (arrayOne.size() != arrayTwo.size()) return false;

        List<Integer> leftSubTreeOne = new ArrayList<>();
        List<Integer> rightSubTreeOne = new ArrayList<>();
        List<Integer> leftSubTreeTwo = new ArrayList<>();
        List<Integer> rightSubTreeTwo = new ArrayList<>();

        int rootOne = arrayOne.get(0);
        for (int i = 1; i < arrayOne.size(); i++) {
            if (arrayOne.get(i) < rootOne) leftSubTreeOne.add(arrayOne.get(i));
            if (arrayOne.get(i) >= rootOne) rightSubTreeOne.add(arrayOne.get(i));
        }

        int rootTwo = arrayTwo.get(0);
        for (int i = 1; i < arrayTwo.size(); i++) {
            if (arrayTwo.get(i) < rootTwo) leftSubTreeTwo.add(arrayTwo.get(i));
            if (arrayTwo.get(i) >= rootTwo) rightSubTreeTwo.add(arrayTwo.get(i));
        }

        boolean leftResult = sameBsts(leftSubTreeOne, leftSubTreeTwo);
        boolean rightResult = sameBsts(rightSubTreeOne, rightSubTreeTwo);

        return (leftResult && rightResult);
    }

    public static void main(String[] args) {
        Integer[] one = new Integer[] {10, 15, 8, 12, 94, 81, 5, 2, 10};
        Integer[] two = new Integer[] {10, 8, 5, 15, 2, 10, 12, 94, 81};

        List<Integer> arrayOne = Arrays.asList(one);
        List<Integer> arrayTwo = Arrays.asList(two);

        sameBsts(arrayOne, arrayTwo);

    }
}
