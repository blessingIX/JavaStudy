package com.yzj.dataStructuresandalgorithms;

import java.util.PriorityQueue;

/**
 * @program: JavaStudy
 * @description: 哈夫曼树
 * @author: blessing
 * @create: 2020-05-27 10:20
 */
public class HuffmanTree {
    private Node root;
    private Node[] nodes;

    public static class Node implements Comparable<Node> {
        int weight;
        Node lChild;
        Node rChild;

        public Node(int weight) {
            this.weight = weight;
        }

        public Node(int weight, Node lChild, Node rChild) {
            this.weight = weight;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public void createHuffman(int[] weights) {
        nodes = new Node[weights.length];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int weight : weights) {
            Node node = new Node(weight);
            queue.add(node);
        }

        while (queue.size() > 1) {
            Node lChild = queue.poll();
            Node rChild = queue.poll();
            Node newNode = new Node(lChild.weight + rChild.weight, lChild, rChild);
            queue.add(newNode);
        }
        root = queue.poll();
    }

    public void output(Node root) {
        if (root == null) return;
        if (root.lChild == null && root.rChild == null) {
            System.out.println(root.weight);
        }
        output(root.lChild);
        output(root.rChild);
    }

    public static void main(String[] args){
        HuffmanTree huffmanTree = new HuffmanTree();
        int[] weights = new int[]{2, 3, 7, 9, 18, 25};
        huffmanTree.createHuffman(weights);
        huffmanTree.output(huffmanTree.root);
    }
}
