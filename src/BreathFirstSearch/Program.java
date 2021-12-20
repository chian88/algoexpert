package BreathFirstSearch;

import java.util.*;

class Program {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
           Queue<Node> queue = new LinkedList<Node>();
           queue.add(this);
           array.add(this.name);

           while(!queue.isEmpty()) {
               Node current = queue.poll();

               for (Node child : current.children) {
                   array.add(child.name);
                   queue.add(child);
               }
           }
            return array;
        }



        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node a = new Node("A");


        a.addChild("B");
        a.addChild("C");
        a.addChild("D");
        a.children.get(0).addChild("E");
        a.children.get(0).addChild("F");
        a.children.get(2).addChild("G");
        a.children.get(2).addChild("H");
        a.children.get(0).children.get(1).addChild("I");
        a.children.get(0).children.get(1).addChild("J");
        a.children.get(2).children.get(0).addChild("K");

        a.breadthFirstSearch(new ArrayList<String>());
    }
}
