package com.iceDarron.algorithms.breadthOrDepthFirstSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 0→1
 * ↓↓
 * 2←3→4
 * <p>
 * 广度优先搜索的策略是：
 * <p>
 * 从起始点开始遍历其邻接的节点，由此向外不断扩散。
 * <p>
 * 1.假设我们以顶点0为原点进行搜索，首先确定邻接0的顶点集合S0 = {1，2}。
 * <p>
 * 2.然后确定顶点1的集合S1 = {3}，顶点2没有邻接点，所以集合为空。
 * <p>
 * 3.然后确定3的邻接点集合S3，因为2已经被遍历过，所以不考虑，所以由顶点3知道的邻接点集合S3 = {4}。
 * <p>
 * 4.然后再确定顶点4的邻接点集合,顶点4没有更多的邻接点了，此时也没有还未遍历的邻接点集合，搜索终止。
 */
public class BreadthFirstSearch {

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
    public static void bfs(HashMap<Character, LinkedList<Character>> graph,
                           HashMap<Character, Integer> dist, char start) {
        // Queue<Character> 表示在此Collection中所保存的元素的类型为Character
        Queue<Character> q = new LinkedList<Character>();
        q.add(start);// 将指定元素s插入队列，成功时返回true，如果没有可用空间，则返回illegalStateException
        //put(start,0) start为指定值将要关联的键，0为指定值将要关联的值， 如果start与0的映射关系已存在，则返回并替换旧值0
        //如果 start与0的映射关系不存在，则返回null
        dist.put(start, 0);
        int i = 0;
        while (!q.isEmpty())//
        {
            char top = q.poll();// 获取并移除队列的头，返回队列的头，如果队列为空，返回null
            i++;
            // dist.get(top) 返回指定键top所映射的值
            System.out.println("The " + i + "th element:" + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;// 得出其周边还未被访问的节点的距离
            /*
             * graph.get(top)如果此映射包含一个满足 (key==null ? k==null : key.equals(k))
             * 的从 k 键到 v 值的映射关系，则此方法返回 v；否则返回 null。（最多只能有一个这样的映射关系。）
             * for（元素变量：元素集合），如果元素集合中所有元素都已遍历过，则结束此循环， 否则执行for循环里的程序块
             */
            for (Character c : graph.get(top)) {
                // containskey(key) 如果此映射包含对于指定键key的映射关系，则返回true
                if (!dist.containsKey(c))// 如果dist中还没有该元素说明还没有被访问
                {
                    //关联指定键c与指定值d，如果关联关系已存在，则替换旧值d，返回旧值d， 如果无映射关系，则返回null
                    dist.put(c, d);
                    q.add(c); // 将指定元素c插入队列，成功时返回true，如果没有可用空间，则返回illegalStateException
                }
            }
        }
    }
}



