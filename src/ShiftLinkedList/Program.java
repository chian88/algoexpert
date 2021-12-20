package ShiftLinkedList;

import java.util.*;

class Program {
	public static LinkedList shiftLinkedList(LinkedList head, int k) {
		if (k == 0) return head;
		LinkedList originalHead = head;
		LinkedList originalTail = head;
		int len = 1;

		while (originalTail.next != null) {
			len++;
			originalTail = originalTail.next;
		}

		if (k > 0) {
			k = k % len;

			if (k == 0) return originalHead;

			LinkedList newTail = head;

			int dist = len - k - 1;

			while (dist > 0) {
				newTail = newTail.next;
				dist--;
			}

			LinkedList newHead = newTail.next;

			originalTail.next = originalHead;
			newTail.next = null;
			return newHead;
		} else {
			k = Math.abs(k) % len;
			if (k == 0) return originalHead;

			LinkedList newTail = head;

			int dist = k - 1;

			while (dist > 0) {
				newTail = newTail.next;
				dist--;
			}

			LinkedList newHead = newTail.next;

			originalTail.next = originalHead;
			newTail.next = null;
			return newHead;
		}


	}

	static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList headOne = new LinkedList(0);
		LinkedList headOne1 = new LinkedList(1);
		LinkedList headOne2 = new LinkedList(2);
		LinkedList headOne3 = new LinkedList(3);
		LinkedList headOne4 = new LinkedList(4);
		LinkedList headOne5 = new LinkedList(5);

		headOne.next = headOne1;
		headOne1.next = headOne2;
		headOne2.next = headOne3;
		headOne3.next = headOne4;
		headOne4.next = headOne5;

		shiftLinkedList(headOne, 6);
	}
}
