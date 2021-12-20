package LinkedListConstruction;

import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.

            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }

        }

        public void setTail(Node node) {
            // Write your code here.
            if (tail == null) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }

        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            Node current = head;

            while (current != null && current.value != node.value) {
                current = current.next;
            }
            if (current != null) {
                Node oldPrev = current.prev;
                current.prev = nodeToInsert;
                nodeToInsert.next = current;

                nodeToInsert.prev = oldPrev;
                oldPrev.next = nodeToInsert;
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            Node current = head;

            while (current != null && current.value != node.value) {
                current = current.next;
            }
            if (current != null) {
                Node oldNext = current.next;
                current.next = nodeToInsert;
                nodeToInsert.prev = current;

                nodeToInsert.next = oldNext;
                oldNext.prev = nodeToInsert;
            }

        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
        }

        public void remove(Node node) {
            // Write your code here.
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            return false;
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
        Node four = new Node(4);
        one.next = two;
        two.prev = one;
        two.next = three;
        three.prev = two;
        three.next = four;
        four.prev = three;

        Node six = new Node(6);


        DoublyLinkedList list = new DoublyLinkedList();
        list.setHead(one);
//        list.setTail(four);

        list.insertBefore(two, six);
    }
}
