package ProductSum;

import java.util.*;

class Program {
    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.
    public static int productSum(List<Object> array) {
        // Write your code here.

        return productSumHelper(array, 1);
    }

    public static int productSumHelper(List<Object> array, int depth) {
        int sum = 0;

        for (Object ele : array) {
            if (ele instanceof ArrayList) {
                sum += productSumHelper((List<Object>) ele, depth + 1) * depth;
            } else {
                int num = (int) ele;
                sum += num * depth;
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        ArrayList<Object> first = new ArrayList<>();
        ArrayList<Object> second = new ArrayList<>();
        ArrayList<Object> third = new ArrayList<>();
        ArrayList<Object> fourth = new ArrayList<>();

        second.add(7);
        second.add(-1);
        fourth.add(-13);
        fourth.add(8);
        third.add(6);
        third.add(fourth);
        third.add(4);
        first.add(5);
        first.add(2);
        first.add(second);
        first.add(3);
        first.add(third);

        int ans = productSum(first);
    }
}
