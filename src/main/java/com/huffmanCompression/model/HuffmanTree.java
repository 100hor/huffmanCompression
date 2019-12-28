package com.huffmanCompression.model;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanTree {
    private final Node root;


    public HuffmanTree(Node root) {
        this.root = root;
    }

    public HuffmanTree() {
        this.root = new Node();
    }

    public static HuffmanTree fillHuffmanTree(int[] freqArray) {
        Queue<HuffmanTree> treeQueue = new PriorityQueue<>(idComparator);
        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] > 0) {
                treeQueue.offer(new HuffmanTree(new Node(freqArray[i], (char) i)));
            }
        }
        while (treeQueue.size() > 1) {

            HuffmanTree first = treeQueue.poll();
            HuffmanTree second = treeQueue.poll();
            treeQueue.offer(new HuffmanTree(new Node(first, second)));
        }

        return treeQueue.poll();

    }

    public Node getRoot() {
        return root;
    }

    public static Comparator<HuffmanTree> idComparator = Comparator.comparingInt(c -> c.getRoot().frequency);

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

        public Node() {
        }

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
