package PartII;

import java.util.HashMap;
import java.util.List;

import PartII.ShortestPath.Node;
import PartII.ShortestPath.NodeAndWeight;

public class TestShortestPath {
	public static void main(String[] args) {
		ShortestPath p = new ShortestPath();
		HashMap<Node, NodeAndWeight[]> graph = p.createAdjacencyList();
		Node start = p.getStart();
		Node end = p.getEnd();
		List<Node> path = ShortestPath.getShortestPath(graph, start, end);
		
		System.out.println(path);
	}
}