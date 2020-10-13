package graph;

public class GraphTest {
    public static void main(String[] args) {
        int n = 5;
        String VertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String s : VertexValue) {
            graph.insertVertex(s);
        }

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();
        /*System.out.println("=============深度优先搜索=============");
        graph.dfs();*/
        System.out.println("=============广度优先搜索=============");
        graph.bfs();

    }
}
