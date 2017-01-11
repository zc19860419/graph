package com.math.gragh;

public interface Graph {
	public int V();

	public int E();

	public boolean directed();

	/**
	 * 插入一条边
	 * 
	 * @param e
	 */
	void insert(Edge e);

	/**
	 * 删除一条边
	 * 
	 * @param e
	 */
	void remove(Edge e);

	boolean edge(int a, int b);

	public AdjList getAdjList(int v);
}
