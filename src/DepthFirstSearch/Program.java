package DepthFirstSearch;

import java.util.*;

class Program {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            return depthFirstSearchHelper(array, this);
        }

        public List<String> depthFirstSearchHelper(List<String> array, Node node) {
            // Write your code here.
            if (array.contains(node.name)) return array;
            array.add(node.name);

            for (Node child : node.children) {
                depthFirstSearchHelper(array, child);
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

        a.depthFirstSearch(new ArrayList<String>());
    }
}