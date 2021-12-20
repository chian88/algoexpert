package MergeLinkedList;

import java.util.*;

class Program {
	// This is an input class. Do not edit.
	public static class LinkedList {
		int value;
		LinkedList next;

		LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
		// Write your code here.
		LinkedList p1 = headOne;
		LinkedList prev = null;
		LinkedList originalHead = null;

		LinkedList p2 = headTwo;
		boolean firstTime = true;
		while (p1 != null && p2 != null) {
			if (p1.value < p2.value) {
				if (firstTime) {
					firstTime = false;
					originalHead = p1;
				}
				LinkedList temp = p1.next;
				if (prev != null) {
					prev.next = p1;
				}
				prev = p1;
				p1.next = p2;
				p1 = temp;


			} else {
				if (firstTime) {
					firstTime = false;
					originalHead = p2;
				}
				LinkedList temp = p2.next;
				if (prev != null) {
					prev.next = p2;
				}

				prev = p2;
				p2.next = p1;
				p2 = temp;
			}
		}



		return originalHead;
	}

	public static void main(String[] args) {
		LinkedList headOne = new LinkedList(2);
		LinkedList headOne1 = new LinkedList(6);
		LinkedList headOne2 = new LinkedList(7);
		LinkedList headOne3 = new LinkedList(8);

		headOne.next = headOne1;
		headOne1.next = headOne2;
		headOne2.next = headOne3;


		LinkedList headTwo = new LinkedList(1);
		LinkedList headTwo1 = new LinkedList(3);
		LinkedList headTwo2 = new LinkedList(4);
		LinkedList headTwo3 = new LinkedList(5);
		LinkedList headTwo4 = new LinkedList(9);
		LinkedList headTwo5 = new LinkedList(10);

		headTwo.next = headTwo1;
		headTwo1.next = headTwo2;
		headTwo2.next = headTwo3;
		headTwo3.next = headTwo4;
		headTwo4.next = headTwo5;

		mergeLinkedLists(headOne, headTwo);
	}
}
