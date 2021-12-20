package FindLoop;

import java.util.*;

class Program {
    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList first = head;
        LinkedList second = head;

        first = first.next;
        second = second.next.next;

        while (first != second) {
            first = first.next;
            second = second.next.next;
        }

        first = head;

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList zero = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);

        LinkedList three = new LinkedList(3);

        LinkedList four = new LinkedList(4);

        LinkedList five = new LinkedList(5);

        LinkedList six = new LinkedList(6);

        LinkedList seven = new LinkedList(7);

        LinkedList eight = new LinkedList(8);

        LinkedList nine = new LinkedList(9);

        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = four;

        findLoop(zero);


    }
}




//class Program {
//    public static LinkedList findLoop(LinkedList head) {
//        // Write your code here.
//        Set<Integer> visited = new HashSet<>();
//
//        LinkedList current = head;
//        Integer duplicate = null;
//
//        while (current != null) {
//            if (visited.contains(current.hashCode())) {
//                // need to break
//                return current;
//            } else {
//                visited.add(current.hashCode());
//            }
//            current = current.next;
//        }
//
//
//
//        return null;
//    }
//
//    static class LinkedList {
//        int value;
//        LinkedList next = null;
//
//        public LinkedList(int value) {
//            this.value = value;
//        }
//    }
//
//    public static void main(String[] args) {
//        LinkedList four = new LinkedList(4);
//        LinkedList five = new LinkedList(5);
//        LinkedList six = new LinkedList(6);
//        LinkedList two = new LinkedList(2);
//        LinkedList seven = new LinkedList(7);
//        LinkedList eight = new LinkedList(8);
//        LinkedList nine = new LinkedList(9);
//
//        four.next = five;
//        five.next = six;
//        six.next = two;
//        two.next = seven;
//        seven.next = eight;
//        eight.next = nine;
//        nine.next = four;
//
//        LinkedList ans = findLoop(four);
//        int x = 1;
//    }
//}
