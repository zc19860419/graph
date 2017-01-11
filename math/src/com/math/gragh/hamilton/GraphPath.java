package com.math.gragh.hamilton;

import java.util.Stack;

import com.math.gragh.AdjList;
import com.math.gragh.Graph;
import com.math.gragh.utils.Out;

public class GraphPath {
	private Graph G;
	private boolean found;
	private boolean[] visited;
	private Stack<ShowTask> path = new Stack<ShowTask>();

	public class ShowTask {

		private int v;
		private int t;
		private int depth;

		public ShowTask(int v, int t, int depth) {
			this.v = v;
			this.t = t;
			this.depth = depth;
		}

		public void show() {
			for (int i = 0; i < depth; i++) {
				Out.print("  ");
			}
			Out.println(v + "-" + t + " ");
		}
	}

	public GraphPath(Graph G, int v, int w) {
		this.G = G;
		found = false;
		visited = new boolean[G.V()];
		// path.clear();
		// found = searchR(v, w, 0);

		path.clear();
		found = searchHamilton(v, w, G.V() - 1);
	}

	/**
	 * 首先,取所找到的路径长度为其第三个参数,而且只在找到长度为V的路径时成功返回; 其次,在未成功返回时,将重置 visited 标记
	 * 
	 * 哈密顿通路的递归搜索需要花费指数时间
	 * 
	 * @param v
	 * @param w
	 * @param d
	 * @return
	 */
	private boolean searchHamilton(int v, int w, int d) {
		if (v == w) {
			return (d == 0);
		}
		visited[v] = true;
		AdjList A = G.getAdjList(v);
		for (int t = A.beg(); !A.end(); t = A.nxt()) {
			if (!visited[t]) {
				if (searchHamilton(t, w, d - 1)) {
					addShowTask(new ShowTask(v, t, G.V() - 1 - d));
					return true;
				}
			}
		}
		visited[v] = false;
		return false;
	}

	public void show() {
		StringBuffer sb = new StringBuffer("path:");
		ShowTask pop = null;
		while (!path.isEmpty()) {
			pop = path.pop();
			pop.show();
			sb.append(pop.v + "-");
		}
		if (pop != null) {
			sb.append(pop.t + "");
		}
		Out.println(sb.toString());
	}

	/**
	 *
	 * DFS简单路径搜素，如果v到w存在一条联通路径，则返回true,否则返回false
	 * 
	 * @param v
	 * @param w
	 * @param depth
	 * @return
	 */
	private boolean searchR(int v, int w, int depth) {
		if (v == w) {
			return true;
		}
		visited[v] = true;
		AdjList A = G.getAdjList(v);
		for (int t = A.beg(); !A.end(); t = A.nxt()) {
			if (!visited[t]) {
				if (searchR(t, w, depth + 1)) {
					addShowTask(new ShowTask(v, t, depth));
					return true;
				}
			}
		}
		return false;
	}

	private void addShowTask(ShowTask task) {
		path.push(task);
	}

	public boolean exist() {
		return found;
	}
}
