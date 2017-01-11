package com.math.gragh.utils;

import com.math.gragh.AdjList;
import com.math.gragh.Graph;

public class GraphDegree {

	private int deg[];

	public GraphDegree(Graph G) {
		this.deg = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			deg[v] = 0;
			AdjList A = G.getAdjList(v);
			for (A.beg(); !A.end(); A.nxt()) {
				deg[v]++;
			}
		}
	}

	public int degree(int v) {
		return deg[v];
	}
}
