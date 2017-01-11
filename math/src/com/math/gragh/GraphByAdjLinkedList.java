package com.math.gragh;

/**
 * Graph ADT 实现
 * 
 * @author 10128044
 *
 */
public class GraphByAdjLinkedList implements Graph {// sparse multigraph
													// implementation
	private int Vcnt;// 顶点个数
	private int Ecnt;// 边个数

	private boolean digraph;

	private class Node {
		int v;
		Node next;

		Node(int x, Node t) {
			v = x;
			next = t;
		}
	}

	private Node adj[];

	public GraphByAdjLinkedList(int V, boolean flag) {
		Vcnt = V;
		Ecnt = 0;
		digraph = flag;
		adj = new Node[V];
	}

	@Override
	public int V() {
		return Vcnt;
	}

	@Override
	public int E() {
		return Ecnt;
	}

	@Override
	public boolean directed() {
		return digraph;
	}

	/**
	 * 插入一条边到邻接表中
	 * 
	 * <pre>
	 * 		[e]
	 * v----------->w
	 * adj[v]----[w]----adj[v]'
	 * </pre>
	 * 
	 * @param e
	 */
	@Override
	public void insert(Edge e) {
		int v = e.v;
		int w = e.w;
		adj[v] = new Node(w, adj[v]);
		if (!digraph) {
			adj[w] = new Node(v, adj[w]);
		}
		Ecnt++;
	}

	/**
	 * 从邻接表中删除一条边
	 * 
	 * @param e
	 */
	@Override
	public void remove(Edge e) {
		int v = e.v;
		int w = e.w;
		if (!edge(v, w)) {
			return;
		}
		remove(v, w);
		if (!digraph) {
			remove(w, v);
		}
		return;
	}

	private void remove(int v, int w) {
		Node t = adj[v];
		Node nxt = t.next;
		while (nxt != null && nxt.v != w) {
			t = nxt;
			nxt = t.next;
		}
		if (nxt != null && nxt.v == w) {
			t.next = nxt.next;
			nxt = null;
		}
	}

	@Override
	public boolean edge(int a, int b) {
		AdjList A = getAdjList(a);
		for (int i = A.beg(); !A.end(); A.nxt()) {
			if (i == b) {
				return true;
			}
		}
		return false;
	}

	@Override
	public AdjList getAdjList(int v) {
		return new AdjLinkedList(v);
	}

	private class AdjLinkedList implements AdjList {

		private int v;
		private Node t;

		AdjLinkedList(int v) {
			this.v = v;
			this.t = null;
		}

		@Override
		public int beg() {
			t = adj[v];
			return (t == null) ? -1 : t.v;
		}

		@Override
		public int nxt() {
			if (t != null) {
				t = t.next;
			}
			return (t == null) ? -1 : t.v;
		}

		@Override
		public boolean end() {
			return t == null;
		}
	}

	public AdjList getAdjList() {
		return null;
	}
}
