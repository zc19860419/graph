package com.math.gragh.utils;

import com.math.gragh.AdjList;
import com.math.gragh.Graph;

public class GraphIO {
	public static void scanEZ(Graph G) {

	}

	public static void scan(Graph G) {

	}

	public static void show(Graph G) {
		for (int s = 0; s < G.V(); s++) {
			Out.print(s + ": ");
			AdjList A = G.getAdjList(s);
			for (int t = A.beg(); !A.end(); t = A.nxt()) {
				Out.print(t + " ");
			}
			Out.println("");
		}
	}
}
