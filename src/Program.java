import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head != null) {
                node.next = head;
                head.prev = node;
            }
            head = node;
        }

        public void setTail(Node node) {
            if (tail != null) {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            remove(nodeToInsert);
            Node targetNode = findNode(node);
            Node prevNode = targetNode.prev;
            prevNode.next = nodeToInsert;
            nodeToInsert.prev = prevNode;

            targetNode.prev = nodeToInsert;
            nodeToInsert.next = targetNode;

        }

        public Node findNode(Node targetNode) {
            Node current = head;

            while (current != null) {
                if (current.value == targetNode.value) break;
                current = current.next;
            }

            return current;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            nodeToInsert.prev = node;
            Node nextNode = node.next;
            node.next = nodeToInsert;
            nextNode.prev = nodeToInsert;
            nodeToInsert.next = nextNode;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            int currentIndex = 1;
            Node current = head;
            while (current != null && position != currentIndex) {
                current = current.next;
                currentIndex += 1;
            }

            Node prevNode = current.prev;
            prevNode.next = nodeToInsert;
            nodeToInsert.prev = prevNode;
            nodeToInsert.next = current;
            current.prev = nodeToInsert;

        }

        public void removeNodesWithValue(int value) {
            Node current = head;
           while (current != null) {
               if (current.value == value) break;
               current = current.next;
           }

           remove(current);
        }

        public void remove(Node node) {
            if (head == node) {
                head = head.next;
                head.prev = null;
            }

            if (tail == node) {
                tail = tail.prev;
                tail.next = null;
            }


            Node current = findNode(node);
            Node prevNode = current.prev;
            Node nextNode = current.next;
            if (prevNode != null) {
                prevNode.next = nextNode;
            }

            if (nextNode != null) {
                nextNode.prev = prevNode;
            }

            current.next = null;
            current.prev = null;

        }

        public boolean containsNodeWithValue(int value) {
            Node current = head;
            while (current != null) {
                if (current.value == value) return true;
                current = current.next;
            }
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
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;

        DoublyLinkedList list = new DoublyLinkedList();
        list.setHead(node1);
        Node node7 = new Node(7);
        list.insertAtPosition(2, node7);
        list.containsNodeWithValue(7);
//        list.removeNodesWithValue(7);
        //list.insertBefore(nodeB, nodeA);
    }
}
