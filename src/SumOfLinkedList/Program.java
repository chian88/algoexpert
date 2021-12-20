package SumOfLinkedList;

import java.util.*;

class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int power = 0;
        int num1 = 0;

        while (linkedListOne != null) {
            num1 += linkedListOne.value * Math.pow(10, power);
            power++;
            linkedListOne = linkedListOne.next;
        }

        power = 0;
        int num2 = 0;

        while (linkedListTwo != null) {
            num2 += linkedListTwo.value * Math.pow(10, power);
            power++;
            linkedListTwo = linkedListTwo.next;
        }

        int total = num1 + num2;

        LinkedList head = new LinkedList(total % 10);
        LinkedList current = head;
        total = total / 10;

        while (total > 0) {
            current.next = new LinkedList(total % 10);
            total = total / 10;
            current = current.next;
        }


        return head;
    }

    public static void main(String[] args) {
        LinkedList two = new LinkedList(2);
        LinkedList four = new LinkedList(4);
        LinkedList seven = new LinkedList(7);
        LinkedList one = new LinkedList(1);

        two.next = four;
        four.next = seven;
        seven.next = one;

        LinkedList nine = new LinkedList(9);
        LinkedList four2 = new LinkedList(4);
        LinkedList five = new LinkedList(5);

        nine.next = four2;
        four2.next = five;

        sumOfLinkedLists(two, nine);
    }
}
