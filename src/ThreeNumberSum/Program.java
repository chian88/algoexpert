package ThreeNumberSum;

import java.util.*;


class Program {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);

        List<Integer[]> res = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int head = array[i];

            int leftPointer = i + 1;
            int rightPointer = array.length - 1;

            while (leftPointer < array.length && leftPointer < rightPointer) {
                int total = head + array[leftPointer] + array[rightPointer];

                if (targetSum == total) {
                    res.add(new Integer[]{head, array[leftPointer], array[rightPointer]});
                    leftPointer++;
                } else if (total < targetSum) {
                    leftPointer++;
                } else if (total > targetSum) {
                    rightPointer--;
                }
            }
        }


        return res;
    }


    public static void main(String[] args) {
        threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
    }
}









//public class Program {
//    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
//        // Write your code here.
//        Arrays.sort(array);
//
//        List<Integer[]> answer = new ArrayList<>();
//
//        for(int i = 0; i < array.length; i++) {
//            int main = array[i];
//            int left = i+1;
//            int right = array.length - 1;
//            while(left < right) {
//                int currentSum = main + array[left] + array[right];
//                if(currentSum == targetSum) {
//                    Integer[] miniAns = new Integer[] {main, array[left], array[right]};
//                    answer.add(miniAns);
//                    left++;
//                } else if (currentSum < targetSum) {
//                    left++;
//                } else if (currentSum > targetSum) {
//                    right--;
//                }
//            }
//        }
//
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
////        List<Integer> array = new ArrayList(Arrays.asList());
//        int[] array = new int[] {12,3,1,2,-6,5,-8,6};
////        List<Integer> sequence = new ArrayList(Arrays.asList(25));
//        Program.threeNumberSum(array, 0);
//    }
//}
