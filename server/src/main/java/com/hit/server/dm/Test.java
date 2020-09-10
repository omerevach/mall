package com.hit.server.dm;

	import java.util.ArrayDeque;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Queue;
	import java.util.Set;
	import java.util.stream.Collectors;

import algorithm.Graph;
import algorithm.GraphNode;
import algorithm.ISearchAlgo;

	public class Test<T extends GraphNode> implements ISearchAlgo<T> {
		private Graph<T> graph;
		
		public Test(Graph<T> graph) {
			this.graph = graph;
		}

		@Override
		public List<T> findRoute(T from, T to) {
			Queue<T> queue = new ArrayDeque<>();
			queue.add(from);

			T currentNode;
			Set<T> alreadyVisited = new HashSet<>();

			while (!queue.isEmpty()) {
				currentNode = queue.remove();

				if (currentNode.getName().equals(to.getName())) {
					return alreadyVisited.stream().collect(Collectors.toList());
				} else {
					alreadyVisited.add(currentNode);
					queue.addAll(graph.getConnections(currentNode));
					queue.removeAll(alreadyVisited);
				}
			}

			throw new IllegalStateException("No route found");
		}

	}

