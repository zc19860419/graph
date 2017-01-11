package com.math.gragh;

import com.math.gragh.hamilton.GraphPath;
import com.math.gragh.utils.GraphIO;
import com.math.gragh.utils.Out;

public class Main {
	public static void main(String[] args) {
		// test1();
		test2();
	}

	private static void test2() {
		Graph G = new GraphByAdjArray(5, false);

		Edge e1 = new Edge(0, 2);
		G.insert(e1);
		Edge e2 = new Edge(2, 3);
		G.insert(e2);
		Edge e3 = new Edge(4, 2);
		G.insert(e3);
		Edge e4 = new Edge(0, 1);
		G.insert(e4);
		Edge e5 = new Edge(4, 1);
		G.insert(e5);
		Edge e6 = new Edge(4, 3);
		G.insert(e6);
		Edge e7 = new Edge(1, 2);
		G.insert(e7);

		GraphIO.show(G);
		GraphPath path = new GraphPath(G, 4, 0);
		if (path.exist()) {
			path.show();
		} else {
			Out.println("not found");
		}
	}

	private static void test1() {
		Graph G = new GraphByAdjArray(5, false);

		Edge e1 = new Edge(0, 2);
		G.insert(e1);

		Edge e2 = new Edge(2, 3);
		G.insert(e2);

		Edge e3 = new Edge(4, 2);
		G.insert(e3);

		// GraphIO.show(G);
		GraphPath path = new GraphPath(G, 0, 3);
	}
}
