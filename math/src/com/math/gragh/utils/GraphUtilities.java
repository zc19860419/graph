package com.math.gragh.utils;

import com.math.gragh.AdjList;
import com.math.gragh.Edge;
import com.math.gragh.GraphByAdjLinkedList;

public class GraphUtilities {
	static Edge[] edges(GraphByAdjLinkedList G) {
		int E = 0;
		Edge[] a = new Edge[G.E()];
		for (int v = 0; v < G.V(); v++) {
			AdjList A = G.getAdjList(v);
			for (int w = A.beg(); !A.end(); w = A.nxt()) {
				if (G.directed() || v < w) {
					a[E++] = new Edge(v, w);
				}
			}
		}
		return a;
	}
}
