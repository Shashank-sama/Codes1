import java.util.*;
import java.lang.*;
import java.io.*;

class dijkstra_path {

    public static void main(String[] args)
    {

        int graph[][] = new int[][]   { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        dijkstra(graph, 0);
    }

    static  void dijkstra(int[][] graph, int src) {
        int V=graph.length;
        int dist[]=new int[V];
        boolean sptSet[]=new boolean[V];

        for(int i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
            sptSet[i]=false;
        }

        dist[src]=0;

        for(int i=0;i<V-1;i++) {

            int u=minDistance(dist,sptSet);

            sptSet[u]=true;

            for(int j=0;j<V;j++)
            {
                if(!sptSet[j] && graph[u][j]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][j]<dist[j])
                {
                    dist[j]=dist[u]+graph[u][j];
                }
            }
        }

        printSolution(dist);

    }

    static int minDistance(int[] dist, boolean[] sptSet) {

        int min=Integer.MAX_VALUE, min_index=-1;

        for(int i=0;i<dist.length;i++)
        {
            if(sptSet[i]==false&&dist[i]<=min)
            {
                min=dist[i];
                min_index=i;
            }
        }
        return  min_index;
    }

    static void printSolution(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}