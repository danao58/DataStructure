package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数量
    private boolean[] isVisited;//记录某个节点是否被访问

    public Graph(int n) {//初始化矩阵
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    public void insertVertex(String vertex){//插入结点
        vertexList.add(vertex);
    }

    /**
     *
     * @param v1 当前点的坐标
     * @param v2 他对应的下一个定点的坐标
     * @param wight
     */
    public void insertEdge(int v1,int v2,int wight){//添加边
        edges[v1][v2] = wight;
        edges[v2][v1] = wight;
        numOfEdges++;
    }


    public int getNumOfVertex(){//返回节点个数
        return vertexList.size();
    }

    public int getNumOfEdges(){//返回边的条数
        return numOfEdges;
    }

    public String getValueByIndex(int i){//返回节点对应的数据
        return vertexList.get(i);
    }

    public void bfs(){//
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    private void bfs(boolean[] isVisited,int i){//广度优先搜索
        int u;//表示队列的头节点对应的下标
        int w;//表示邻接结点w
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "=>");
        isVisited[i] = true;
        queue.add(i);

        while (! queue.isEmpty()){

            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);

            while (w != -1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }

    }

    public void dfs(){//回溯一次，遍历全部
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    private void dfs(boolean[] isVisited,int i){//深度优先遍历
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    private int getFirstNeighbor(int index){//得到第一个邻接节点的下标
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    private int getNextNeighbor(int v1,int v2){//根据前一个邻接节点的下标来获取下一个邻接节点
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }


    public void showGraph(){//展示邻接矩阵
        for (int[] edge : edges) {
            System.out.print("[");
            for (int i : edge) {
                System.out.print(i + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

}
