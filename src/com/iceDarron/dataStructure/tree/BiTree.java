package com.iceDarron.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树相关
 * <p>
 * 先（根>左>右）中（左>根>右）后（左>右>根）序遍历
 */
public class BiTree {

    public BTNode root;

    public BiTree(BTNode root) {
        this.root = root;
    }

    public BTNode getRoot() {
        return this.root;
    }

    /**
     * 构造树
     * 8
     * 4       7
     * 2    3   n    6
     * n  1           5  n
     */
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
     * 打印树
     */
    public void printTree(BTNode root) {

    }

    /**
     * 访问节点
     */
    public void visit(BTNode node) {
        System.out.print(node.getVal() + " ");
    }

    /**
     * 递归实现前序遍历
     */
    public void preOrder(BTNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * 递归实现中序遍历
     */
    public void inOrder(BTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            visit(node);
            inOrder(node.getRight());
        }
    }

    /**
     * 递归实现后序遍历
     */
    public void postOrder(BTNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            visit(node);
        }
    }

    /**
     * 非递归实现前序遍历
     */
    public void iterativePreOrder(BTNode node) {
        Stack<BTNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                visit(node);
                if (node.getRight() != null)
                    stack.push(node.getRight());
                node = node.getLeft();
            } else {
                node = stack.pop();
            }
        }
    }

    /**
     * 非递归实现中序遍历
     */
    public void iterativeInOrder(BTNode node) {
        Stack<BTNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                visit(node);
                node = node.getRight();
            }
        }
    }

    /**
     * 非递归实现后序遍历
     */
    public void iterativePostOrder(BTNode node) {
        Stack<BTNode> stack = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                helper.push(0);
                node = node.getLeft();
            } else {
                int a = helper.pop();
                if (a == 0) {
                    helper.push(1);
                    node = stack.peek().getRight();
                } else {
                    node = stack.pop();
                    visit(node);
                    node = null;
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

    /**
     * 计算二叉树结点
     * <p>
     * 用递归，每一个函数往左边和右边（顺序无关），两个方向探索，然后每探索成功一次，说明有一个结点，+1。出口为结点为空。
     */
    public int countNodes(BTNode node) {
        if (node == null) {
            return 0;
        } else {
            return countNodes(node.getLeft()) + countNodes(node.getRight()) + 1;
        }
    }

    /**
     * 计算二叉树深度
     * <p>
     * 用递归，向左右探索（顺序无关），返回的值是二叉树的深度。
     * <p>
     * 分治思想，在左边和右边的子树那个深度大，那么就选那个深度大的+1 。出口为结点为空。
     */
    public int deepth(BTNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = deepth(node.getLeft());
            int right = deepth(node.getRight());
            if (left > right)
                return left + 1;
            else
                return right + 1;
        }
    }


    /**
     * 计算二叉树的叶子数目
     *
     * 递归，和探索结点一样，左右探索（顺序无关），结点左右子树皆为空，才是叶子。
     *
     * 出口两个，结点为空返回0，结点的左右子树为空返回1。
     */
    public int leafCount(BTNode node) {
        if (node == null)
            return 0;
        else if (node.getLeft() == null && node.getRight() == null)
            return 1;
        else
            return leafCount(node.getLeft()) + leafCount(node.getRight());
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


/**
 * 测试类
 */
class TestBiTree {

    public static void main(String[] args) {
        BiTree tree = new BiTree(BiTree.init());

//        System.out.println("Pre-Order:");
//        tree.preOrder(tree.getRoot());
//        System.out.println();
//        tree.iterativePreOrder(tree.getRoot());
//        System.out.println();

//        System.out.println("In-Order:");
//        tree.inOrder(tree.getRoot());
//        System.out.println();
//        tree.iterativeInOrder(tree.getRoot());
//        System.out.println();

//        System.out.println("Post-Order:");
//        tree.postOrder(tree.getRoot());
//        System.out.println();
//        tree.iterativePostOrder(tree.getRoot());
//        System.out.println();

//        System.out.println("Level-Order:");
//        tree.levelOrder(tree.getRoot());
//        System.out.println();

//        System.out.println("Count-Nodes:");
//        System.out.println(tree.countNodes(tree.root));

//        System.out.println("Deepth:");
//        System.out.println(tree.deepth(tree.root));

        System.out.println("Leaf-Count:");
        System.out.println(tree.leafCount(tree.getRoot()));
    }
}
