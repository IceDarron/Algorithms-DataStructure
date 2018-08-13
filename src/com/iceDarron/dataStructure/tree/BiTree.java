package com.iceDarron.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** 二叉树 */
public class BiTree {
	protected BTNode root;

	public BiTree(BTNode root) {
		this.root = root;
	}

	public BTNode getRoot() {
		return root;
	}

	/** 访问节点 */
	public static void visit(BTNode p) {
		System.out.print(p.getVal() + " ");
	}

	/** 递归实现前序遍历 */
	protected static void preOrder(BTNode T) {
		if (T != null) {
			visit(T);
			preOrder(T.getLeft());
			preOrder(T.getRight());
		}
	}

	/** 递归实现中序遍历 */
	protected static void inOrder(BTNode T) {
		if (T != null) {
			inOrder(T.getLeft());
			visit(T);
			inOrder(T.getRight());
		}
	}

	/** 递归实现后序遍历 */
	protected static void postOrder(BTNode T) {
		if (T != null) {
			postOrder(T.getLeft());
			postOrder(T.getRight());
			visit(T);
		}
	}

	/** 非递归实现前序遍历-我的代码 */
	protected static void iterativePreOrder(BTNode T) {
		Stack<BTNode> stack = new Stack<>();
		while (T != null || !stack.isEmpty()) {
			if (T != null) {
				visit(T);
				if (T.getRight() != null)
					stack.push(T.getRight());
				T = T.getLeft();
			} else {
				T = stack.pop();
			}
		}
	}

	/** 非递归实现中序遍历-我的代码 */
	protected static void iterativeInOrder(BTNode T) {
		Stack<BTNode> stack = new Stack<>();
		while (T != null || !stack.isEmpty()) {
			if (T != null) {
				stack.push(T);
				T = T.getLeft();
			} else {
				T = stack.pop();
				visit(T);
				T = T.getRight();
			}
		}
	}

	/** 非递归实现后序遍历 */
	protected static void iterativePostOrder(BTNode T) {
		Stack<BTNode> stack = new Stack<>();
		Stack<Integer> helper = new Stack<>();
		while (T != null || !stack.isEmpty()) {
			if (T != null) {
				stack.push(T);
				helper.push(0);
				T = T.getLeft();
			} else {
				int a = helper.pop();
				if (a == 0) {
					helper.push(1);
					T = stack.peek().getRight();
				} else {
					T = stack.pop();
					visit(T);
					T = null;
				}
			}
		}
	}

	/** 层次遍历 */
	protected static void levelOrder(BTNode root) {
		if (root == null) {
			return;
		}
		Queue<BTNode> queue = new LinkedList<>();
		queue.offer(root);
		BTNode tmp = null;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			visit(tmp);
			if (tmp.getLeft() != null)
				queue.offer(tmp.getLeft());
			if (tmp.getRight() != null)
				queue.offer(tmp.getRight());
		}
	}

	public static void main(String[] args) {
		BiTree tree = new BiTree(init());

		System.out.println("Pre-Order:");
		preOrder(tree.getRoot());
		System.out.println();
		iterativePreOrder(tree.getRoot());
		System.out.println();

		System.out.println("In-Order:");
		inOrder(tree.getRoot());
		System.out.println();
		iterativeInOrder(tree.getRoot());
		System.out.println();

		System.out.println("Post-Order:");
		postOrder(tree.getRoot());
		System.out.println();
		iterativePostOrder(tree.getRoot());
		System.out.println();

		System.out.println("Level-Order:");
		levelOrder(tree.getRoot());
		System.out.println();
	}

	/** 构造树 */
	public static BTNode init() {
		BTNode a = new BTNode(1);
		BTNode b = new BTNode(2, null, a);
		BTNode c = new BTNode(3);
		BTNode d = new BTNode(4, b, c);
		BTNode e = new BTNode(5);
		BTNode f = new BTNode(6, e, null);
		BTNode g = new BTNode(7, null, f);
		BTNode h = new BTNode(8, d, g);
		return h; // root
	}
}

class BTNode {
	private int val;
	private BTNode left, right;

	public BTNode(int val) {
		this(val, null, null);
	}

	public BTNode(int val, BTNode left, BTNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(char key) {
		this.val = key;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}
}
