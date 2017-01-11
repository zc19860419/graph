package com.math.gragh.eulerTour;

import java.util.Stack;

import com.math.gragh.AdjList;
import com.math.gragh.Edge;
import com.math.gragh.Graph;
import com.math.gragh.utils.GraphDegree;
import com.math.gragh.utils.Out;

/**
 * <pre>
 * 属性17.4 一个图有一条欧拉通路,条件是当前仅当它是连通的,而且所有顶点都是偶数度数
 * 推论 一个图有一条欧拉通路,条件是当且仅当它是连通的，而且只有两个顶点有奇数度数
 * </pre>
 * 
 * @author 10128044
 *
 */
public class GraphPathE {
	private Graph G;
	private int v, w;
	private boolean nopath;
	private Stack<Integer> S;

	/**
	 * 图 G 中 存在一条欧拉周游路径,从顶点v出发到顶点w,顶点可以重复,但是每条边都被使用且仅使用一次
	 * 
	 * @param G
	 * @param v
	 * @param w
	 */
	public GraphPathE(Graph G, int v, int w) {
		this.G = G;
		this.v = v;
		this.w = w;
		GraphDegree Gdeg = new GraphDegree(G);
		int degree = Gdeg.degree(v) + Gdeg.degree(w);
		// 度数是奇数
		if ((degree % 2) != 0) {
			nopath = true;
			return;
		}
		for (int t = 0; t < G.V(); t++) {
			if ((t != v) && (t != w)) {
				if (Gdeg.degree(t) % 2 != 0) {
					nopath = true;
					return;
				}
			}
		}
		nopath = false;
	}

	public boolean exist() {
		return !nopath;
	}

	/**
	 * <pre>
	 * show 方法在线性时间里运行,tour方法沿着回路上的边前进 
	 * 并删除相应的边, 同时将顶点压入栈, 以用于检查旁环(side loop)
	 * 只要存在需要遍历的有 边环的顶点, 主循环就会调用 tour
	 * </pre>
	 */
	public void show() {
		S = new Stack<Integer>();
		if (nopath) {
			return;
		}
		while (tour(v) == v && !S.isEmpty()) {
			v = S.pop();
			Out.print("-" + v);
		}
		Out.println("");
	}

	/**
	 * tour方法沿着回路上的边前进 并删除相应的边, 同时将顶点压入栈, 以用于检查旁环(side loop)
	 * 
	 * @param v
	 * @return
	 */
	private int tour(int v) {
		while (true) {
			AdjList A = G.getAdjList(v);
			int w = A.beg();
			if (A.end()) {
				break;
			}
			S.push(v);
			G.remove(new Edge(v, w));
			v = w;
		}
		return v;
	}

}
