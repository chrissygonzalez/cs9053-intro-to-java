package PartII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ShortestPath {
	private static Node start;
	private static Node end;
	
	class Node {
		private String name;
		private int distance;
		private Node parent;
		
		public Node(String name) {
			this.name = name;
			this.distance = Integer.MAX_VALUE;
			this.parent = null;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getDistance() {
			return this.distance;
		}
		
		public void setDistance(int dist) {
			this.distance = dist;
		}
		
		public void setParent(Node p) {
			this.parent = p;
		}
		
		public String toString() {
			return "{ name: " + name + ", distance: " + distance + "}";
		}
	}
	
	class NodeAndWeight {
		private Node node;
		private int weight;
		
		public NodeAndWeight(Node node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	
	public Node getStart() {
		return ShortestPath.start;
	}
	
	public Node getEnd(){
		return ShortestPath.end;
	}
	
	public HashMap<Node, NodeAndWeight[]> createAdjacencyList() {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node z = new Node("Z");
		
		start = a;
		end = z;
		
		NodeAndWeight[] aList = {new NodeAndWeight(b, 5), new NodeAndWeight(c, 8)};
		NodeAndWeight[] bList = {new NodeAndWeight(a, 5), new NodeAndWeight(c, 5), new NodeAndWeight(d, 7), new NodeAndWeight(e, 7)};
		NodeAndWeight[] cList = {new NodeAndWeight(a, 8), new NodeAndWeight(b, 5), new NodeAndWeight(d, 9), new NodeAndWeight(e, 6)};
		NodeAndWeight[] dList = {new NodeAndWeight(b, 7), new NodeAndWeight(c, 9), new NodeAndWeight(e, 6), new NodeAndWeight(z, 4)};
		NodeAndWeight[] eList = {new NodeAndWeight(b, 7), new NodeAndWeight(c, 6), new NodeAndWeight(d, 6), new NodeAndWeight(z, 3)};
		NodeAndWeight[] zList = {new NodeAndWeight(d, 4), new NodeAndWeight(e, 3)};
		
		HashMap<Node, NodeAndWeight[]> adjList = new HashMap<Node, NodeAndWeight[]>();
		adjList.put(a, aList);
		adjList.put(b, bList);
		adjList.put(c, cList);
		adjList.put(d, dList);
		adjList.put(e, eList);
		adjList.put(z, zList);
		
		return adjList;
	}
	
	public static List<Node> getShortestPath(HashMap<Node, NodeAndWeight[]> graph, Node start, Node end) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> Integer.compare(a.getDistance(), b.getDistance()));
		Set<String> processed = new HashSet<String>();
		Set<Node> nodes = graph.keySet();
		
		start.setDistance(0);
		
		for(Node node : nodes) {
			pq.add(node);
		}
		
		while(processed.size() < nodes.size()) {
			Node min = pq.remove();
			for(NodeAndWeight n : graph.get(min)) {
				int newDistance = min.distance + n.weight;
				if(newDistance < n.node.distance) {
					pq.remove(n.node);
					n.node.setDistance(newDistance);
					n.node.setParent(min);
					pq.add(n.node);
				}
			}
			processed.add(min.getName());
		}
		
		List<Node> path = new LinkedList<Node>();
		
		Node step = end;
		while(step != null) {
			path.add(0, step);
			step = step.parent;
		}

		return path;
	}
}
