package DoublyLinkedList;

import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
	static class DoublyLinkedList {
		public Node head;
		public Node tail;

		public void setHead(Node node) {
			// Write your code here.
			remove(node);
			if (head == null) {
				head = node;
				tail = node;
			} else if (head == tail) {
				head = node;
				head.next = tail;
				tail.prev = head;
			} else {
				node.next = head;
				head.prev = node;
				node.prev = null;
				head = node;
			}

		}

		public void setTail(Node node) {
			// Write your code here.

			remove(node);
			if (tail == null) {
				head = node;
				tail = node;
			} else if (head == tail) {
				tail = node;
				tail.prev = head;
				head.next = tail;
			} else {
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = node;
			}
		}

		public void insertBefore(Node node, Node nodeToInsert) {
			// Write your code here.
			remove(nodeToInsert);
			Node curr = head;
			boolean found = false;
			while (curr != null) {
				if (curr == node) {
					found = true;
					break;
				}
				curr = curr.next;
			}

			if (found) {
				Node prev = curr.prev;
				curr.prev = nodeToInsert;
				nodeToInsert.next = curr;

				if (prev != null) {
					nodeToInsert.prev = prev;
					prev.next = nodeToInsert;
				} else {
					nodeToInsert.prev = null;
					head = nodeToInsert;
				}

			}

		}

		public void insertAfter(Node node, Node nodeToInsert) {
			// Write your code here.
			remove(nodeToInsert);
			Node curr = head;
			boolean found = false;
			while (curr != null ) {
				if (curr == node) {
					found = true;
					break;
				}
				curr = curr.next;
			}

			if (found) {
				Node next = curr.next;

				curr.next = nodeToInsert;
				nodeToInsert.prev = curr;

				if (next != null) {
					next.prev = nodeToInsert;
					nodeToInsert.next = next;
				} else {
					nodeToInsert.next = null;
					tail = nodeToInsert;
				}
			}
		}

		public void insertAtPosition(int position, Node nodeToInsert) {
			// Write your code here.
			Node curr = head;
			while (position > 1 && curr != null) {
				curr = curr.next;
				position--;
			}

			if (curr == head) {
				setHead(nodeToInsert);
			} else if (curr == null) {
				setTail(nodeToInsert);
			} else {
				insertBefore(curr, nodeToInsert);
			}
		}

		public void removeNodesWithValue(int value) {
			// Write your code here.
			Node curr = head;

			while (curr != null) {
				if (curr.value == value) {
					remove(curr);
				}
				curr = curr.next;
			}

		}

		public void remove(Node node) {
			// Write your code here.

			Node curr = head;
			boolean found = false;
			while (curr != null) {
				if (node == curr) {
					found = true;
					break;
				}
				curr = curr.next;
			}

			if (found) {
				Node prev = curr.prev;
				Node next = curr.next;
				if (prev == null) {
					// curr is head
					head = next;
				} else {
					prev.next = next;
				}

				if (next == null) {
					// curr is tail
					tail = prev;
				} else {
					next.prev = prev;
				}

			}
		}

		public boolean containsNodeWithValue(int value) {
			// Write your code here.

			boolean found = false;

			Node curr = head;

			while (curr != null) {
				if (curr.value == value) {
					found = true;
					break;
				}

				curr = curr.next;
			}
			return found;
		}
	}

	// Do not edit the class below.
	static class Node {
		public int value;
		public Node prev;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
//		Node three2 = new Node(3);
//		Node three3 = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		DoublyLinkedList list = new DoublyLinkedList();
		list.setHead(one);
		list.insertAfter(one, two);
		list.insertAfter(two, three);
		list.insertAfter(three, four);
		list.insertAfter(four, five);
		list.insertAfter(five, six);
		list.insertAfter(six, seven);

		list.insertAtPosition(7, one);
		list.insertAtPosition(1, one);
		list.insertAtPosition(2, one);
		list.insertAtPosition(3, one);
		list.insertAtPosition(4, one);
		list.insertAtPosition(5, one);
		list.insertAtPosition(6, one);
	}
}
