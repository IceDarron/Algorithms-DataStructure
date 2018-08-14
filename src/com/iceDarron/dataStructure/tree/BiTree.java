package com.iceDarron.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树相关
 *
 * 创建树，先中后序遍历
 *
 */
public class BiTree {

	public BTNode root;

	public BiTree(BTNode root) {
		this.root = root;
	}

	public BTNode getRoot() {
		return this.root;
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

	/**
     * 访问节点
     */
	public void visit(BTNode p) {
		System.out.print(p.getVal() + " ");
	}

	/**
     * 递归实现前序遍历
     */
	public void preOrder(BTNode T) {
		if (T != null) {
			visit(T);
			preOrder(T.getLeft());
			preOrder(T.getRight());
		}
	}

	/**
     * 递归实现中序遍历
     */
	public void inOrder(BTNode T) {
		if (T != null) {
			inOrder(T.getLeft());
			visit(T);
			inOrder(T.getRight());
		}
	}

	/**
     * 递归实现后序遍历
     */
	public void postOrder(BTNode T) {
		if (T != null) {
			postOrder(T.getLeft());
			postOrder(T.getRight());
			visit(T);
		}
	}

	/**
     * 非递归实现前序遍历
     */
	public void iterativePreOrder(BTNode T) {
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

	/**
     * 非递归实现中序遍历
     */
	public void iterativeInOrder(BTNode T) {
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

	/**
     * 非递归实现后序遍历
     */
	public void iterativePostOrder(BTNode T) {
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

	/**
     * 层次遍历
     */
	public void levelOrder(BTNode root) {
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





}

/**
 * 二叉树数据结构
 */
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


class TestBiTree {

    public static void main(String[] args) {
        BiTree tree = new BiTree(BiTree.init());

        System.out.println("Pre-Order:");
        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.iterativePreOrder(tree.getRoot());
        System.out.println();

        System.out.println("In-Order:");
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.iterativeInOrder(tree.getRoot());
        System.out.println();

        System.out.println("Post-Order:");
        tree.postOrder(tree.getRoot());
        System.out.println();
        tree.iterativePostOrder(tree.getRoot());
        System.out.println();

        System.out.println("Level-Order:");
        tree.levelOrder(tree.getRoot());
        System.out.println();
    }
}
