package ContinuousMedianHandler;

import java.util.*;

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {
    static class ContinuousMedianHandler {
        double median = 0;
        PriorityQueue<Integer> greaterHalf = new PriorityQueue<>((x,y)-> Integer.compare(x,y));
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>((x,y) -> Integer.compare(y,x));

        public void insert(int number) {
            // Write your code here.

            Integer maxOfLowerHalf = lowerHalf.peek();

            if (maxOfLowerHalf == null) {
                maxOfLowerHalf = Integer.MAX_VALUE;
            }


            if (number > maxOfLowerHalf ) {
                greaterHalf.add(number);
            } else {
                lowerHalf.add(number);
            }

            int sizeOfLowerHalf = lowerHalf.size();
            int sizeOfGreaterHalf = greaterHalf.size();

            if ( (sizeOfGreaterHalf - sizeOfLowerHalf) > 1 ) {
                // greater Half too big.

                Integer smallestOfGreaterHalf = greaterHalf.poll();
                lowerHalf.add(smallestOfGreaterHalf);
            } else if ((sizeOfLowerHalf - sizeOfGreaterHalf) > 1) {
                Integer biggestOfLowerHalf = lowerHalf.poll();
                greaterHalf.add(biggestOfLowerHalf);
            }

            sizeOfLowerHalf = lowerHalf.size();
            sizeOfGreaterHalf = greaterHalf.size();

            int totalSize = sizeOfGreaterHalf + sizeOfLowerHalf;

            if (totalSize % 2 == 0) {
                this.median = (greaterHalf.peek() + lowerHalf.peek()) / 2.0;
            } else if (sizeOfGreaterHalf > sizeOfLowerHalf) {
                this.median = greaterHalf.peek();
            } else if (sizeOfLowerHalf > sizeOfGreaterHalf) {
                this.median = lowerHalf.peek();
            }
        }

        public double getMedian() {
            return median;
        }
    }

    public static void main(String[] args) {
        ContinuousMedianHandler test = new ContinuousMedianHandler();
        test.insert(5);
        test.insert(10);
        System.out.println(test.getMedian());
        test.insert(100);
        System.out.println(test.getMedian());
    }
}
