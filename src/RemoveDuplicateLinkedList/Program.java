package RemoveDuplicateLinkedList;

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

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList original = linkedList;
        while (linkedList.next != null) {
            if (linkedList.next.value == linkedList.value) {
                // delete next node.
                linkedList.next = linkedList.next.next;
            } else {
                linkedList = linkedList.next;
            }
        }
        return original;
    }

    public static void main(String[] args) {
        LinkedList one1 = new LinkedList(1);
        LinkedList one2 = new LinkedList(1);
        LinkedList three1 = new LinkedList(3);
        LinkedList four1 = new LinkedList(4);
        LinkedList four2 = new LinkedList(4);
        LinkedList four3 = new LinkedList(4);
        LinkedList five1 = new LinkedList(5);
        LinkedList six1 = new LinkedList(6);
        LinkedList six2 = new LinkedList(6);

        one1.next = one2;
        one2.next = three1;
        three1.next = four1;
        four1.next = four2;
        four2.next = four3;
        four3.next = five1;
        five1.next = six1;
        six1.next = six2;
        removeDuplicatesFromLinkedList(one1);
    }
}
