package com.math.gragh;

/**
 * Graph ADT 实现
 * 
 * @author 10128044
 *
 */
public class GraphByAdjArray implements Graph {
	private int Vcnt;// 顶点个数
	private int Ecnt;// 边个数

	private boolean digraph;

	private boolean adj[][];

	public GraphByAdjArray(int V, boolean flag) {
		Vcnt = V;
		Ecnt = 0;
		digraph = flag;
		adj = new boolean[V][V];
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
	 * @param e
	 */
	@Override
	public void insert(Edge e) {
		int v = e.v;
		int w = e.w;
		if (!adj[v][w]) {
			Ecnt++;
		}
		adj[v][w] = true;
		if (!digraph) {
			adj[w][v] = true;
		}
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
		if (adj[v][w]) {
			Ecnt--;
		}
		adj[v][w] = false;
		if (!digraph) {
			adj[w][v] = false;
		}
	}

	@Override
	public boolean edge(int a, int b) {
		return adj[a][b];
	}

	@Override
	public AdjList getAdjList(int v) {
		return new AdjArray(v);
	}

	private class AdjArray implements AdjList {

		private int i;
		private int v;

		AdjArray(int v) {
			this.v = v;
			this.i = -1;
		}

		@Override
		public int beg() {
			i = -1;
			return nxt();
		}

		@Override
		public int nxt() {
			for (i++; i < V(); i++) {
				if (edge(v, i)) {
					return i;
				}
			}
			return -1;
		}

		@Override
		public boolean end() {
			return i >= V();
		}

	}
}
