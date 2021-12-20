package RemoveKthNodeFromEnd;

import java.util.*;

class Program {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList current = head;
        int len = 1;

        while (current.next != null) {
            len++;
            current = current.next;
        }

        current = head;
        if (k == len) {
            current.value = current.next.value;
            current.next = current.next.next;
        } else {
            int target = len - k;

            while (target > 1) {
                current = current.next;
                target--;
            }

            current.next = current.next.next;
        }

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
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

        removeKthNodeFromEnd(one1, 9);
    }
}
