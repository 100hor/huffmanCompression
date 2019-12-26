package model;


import java.util.PriorityQueue;

public class HuffmanTree implements Comparable<HuffmanTree> {
    private final Node root;


    public HuffmanTree(Node root) {
        this.root = root;
    }

    public HuffmanTree() {
        this.root = new Node();
    }

    public HuffmanTree fillHuffmanTree(int []freqArray){
        PriorityQueue<HuffmanTree> treeQueue = new PriorityQueue<>();
        for (int i = 0; i < freqArray.length; i++){
            if (freqArray[i] > 0){
                treeQueue.offer(new HuffmanTree(new Node(freqArray[i], (char)i)));
            }
        }
        while (treeQueue.size() > 1) {

            HuffmanTree first = treeQueue.poll();
            HuffmanTree second = treeQueue.poll();
            treeQueue.offer(new HuffmanTree(new Node(first, second)));
        }

        return treeQueue.poll();

    }

    @Override
    public int compareTo(HuffmanTree o) {
        return Integer.compare(root.frequency, o.root.frequency);
    }


    static class Node {
        private int frequency;
        private char symbol;
        private Node leftNode;
        private Node rightNode;

        public Node(int frequency, char symbol) {
            this.frequency = frequency;
            this.symbol = symbol;
        }

        public Node(HuffmanTree left, HuffmanTree right) {
            frequency = left.root.frequency + right.root.frequency;
            leftNode = left.root;
            rightNode = right.root;
        }
        public Node() { }

        public int getFrequency() {
            return frequency;
        }

        public char getSymbol() {
            return symbol;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }
    }
}
