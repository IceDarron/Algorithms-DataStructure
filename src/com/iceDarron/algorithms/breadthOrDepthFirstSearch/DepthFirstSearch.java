package com.iceDarron.algorithms.breadthOrDepthFirstSearch;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 0→1
 * ↓↓
 * 2←3→4
 * <p>
 * 深度优先遍历的策略是：
 * <p>
 * 从一个顶点v出发，首先将v标记为已遍历的顶点，然后选择一个邻接于v的尚未遍历的顶点u，如果u不存在，本次搜素终止。如果u存在，那么从u又开始一次DFS。如此循环直到不存在这样的顶点。
 * <p>
 * 比如图a中
 * <p>
 * 1.从顶点0开始，将0标记为已遍历，然后选择未被遍历的邻接0的顶点1。
 * <p>
 * 2.标记顶点1，然后选择3并标记，然后选择顶点3邻接的顶点2。
 * <p>
 * 3.顶点2标记后没有与它邻接的未标记的点，所以返回3选择另一个邻接3并且未被标记的顶点4。
 * <p>
 * 4.顶点4没有更多的符合条件的点，因此搜索终止，返回到3，3没有更多的点，搜索终止返回到1，最后返回到0，搜索终止。
 */
public class DepthFirstSearch {

    static int count = 0;

    /*
     * HashMap<Character,LinkedList<Character>> graph 这个HashMap是用于存放图中每个node的邻接表
     * 表示此映射所维护的键的类型为Character，此映射值的类型为LinkedList<Character> graph
     * 表示将映射关系存放在graph此映射中
     *
     * LinkedList<Character> 表示在此Collection中保持元素类型为Character
     *
     * HashMap<Character,Integer> dist 这个HashMap 是用于存放每个node与距离顶点s的距离的映射关系
     * 表示此映射所维护的键的类型为Character 此映射所维护的值的类型为Integer，dist表示将映射关系存放到dist此映射中
     */
    public static void dfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited) {
        visit(graph, visited, 's');
    }

    public static void visit(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited, char start) {

        if (!visited.containsKey(start)) {
            count++;
            System.out.println("The time into element " + start + ":" + count);// 记录进入该节点的时间
            visited.put(start, true);
            for (Character c : graph.get(start)) {
                if (!visited.containsKey(c)) {
                    visit(graph, visited, c);// 递归访问其邻近节点
                }
            }
            count++;
            System.out.println("The time out element " + start + ":" + count);// 记录离开该节点的时间
        }
    }
}