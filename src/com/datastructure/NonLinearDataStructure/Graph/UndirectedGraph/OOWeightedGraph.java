package com.datastructure.NonLinearDataStructure.Graph.UndirectedGraph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class OOWeightedGraph {
    private class Node {
        private String label;
        private List<Edge> edges;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to + " with weight " + weight;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();

            if (!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }

    /* *************** Shortest Path *************** */

    private class NodeEntry {
        public Node node;
        public int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public Path getShortestPath(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        Map<Node, Integer> distances = new HashMap<>();

        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);

        distances.replace(fromNode, 0);

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority));

        Map<Node, Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();

        queue.add(new NodeEntry(fromNode, 0));

        /* Breadth First Traversal */
        while (!queue.isEmpty()) {
            var current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(toNode, previousNodes);
    }

    private Path buildPath(Node toNode, Map<Node, Node> previousNodes) {
        Stack<Node> stack = new Stack<>();
        var previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while (!stack.isEmpty())
            path.addNode(stack.pop().label);

        return path;
    }

    /* *************** Cycle Detection *************** */

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values())
            if (!visited.contains(node) && hasCycle(node, null, visited))
                return true;

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);

        for (var edge : node.getEdges()) {
            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to) || hasCycle(edge.to, node, visited))
                return true;
        }

        return false;
    }

    /* *************** Minimum Spanning Tree *************** */

    public OOWeightedGraph getMinimumSpanningTree() {
        var tree = new OOWeightedGraph();

        if (nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight));

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());

        tree.addNode(startNode.label);

        if (edges.isEmpty())
            return tree;

        while (tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            if (tree.containsNode(nextNode.label))
                continue;

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

            for (var edge : nextNode.getEdges())
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);

        }

        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }
}
