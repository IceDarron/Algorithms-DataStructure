package com.iceDarron.algorithms.breadthOrDepthFirstSearch;

import java.util.HashMap;
import java.util.LinkedList;

public class Test {

    public static void main(String args[]) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        DepthFirstSearch dfs = new DepthFirstSearch();

        // s顶点的邻接表
        LinkedList<Character> list_s = new LinkedList<Character>();
        list_s.add('w');
        list_s.add('r');
        LinkedList<Character> list_w = new LinkedList<Character>();
        list_w.add('s');
        list_w.add('x');
        list_w.add('i');
        LinkedList<Character> list_r = new LinkedList<Character>();
        list_r.add('s');
        list_r.add('v');
        LinkedList<Character> list_x = new LinkedList<Character>();
        list_x.add('w');
        list_x.add('y');
        list_x.add('u');
        LinkedList<Character> list_v = new LinkedList<Character>();
        list_v.add('r');
        LinkedList<Character> list_i = new LinkedList<Character>();
        list_i.add('w');
        LinkedList<Character> list_u = new LinkedList<Character>();
        list_u.add('x');
        LinkedList<Character> list_y = new LinkedList<Character>();
        list_y.add('x');
        HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();
        graph.put('s', list_s);
        graph.put('w', list_w);
        graph.put('r', list_r);
        graph.put('x', list_x);
        graph.put('v', list_v);
        graph.put('i', list_i);
        graph.put('y', list_y);
        graph.put('u', list_u);

        System.out.println("BFS starts:");
        HashMap<Character, Integer> dist = new HashMap<Character, Integer>();
        char start = 's';
        bfs.bfs(graph, dist, start);

        System.out.println("DFS starts:");
        HashMap<Character, Boolean> visited = new HashMap<Character, Boolean>();
        dfs.dfs(graph, visited);
    }

}
