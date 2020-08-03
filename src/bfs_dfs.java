import java.util.*;
import java.lang.*;
import java.io.*;



class bfs_dfs {

    public static  class Graph {
         int V;
         LinkedList<Integer> adj[]; //Adjacency Lists


        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }


        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void print_adjlist(){

            System.out.print("Adjacency List if given Graph is :");

            for(int i=0;i<V;i++)
            {
                Iterator<Integer> x=adj[i].listIterator();
                System.out.println();
                System.out.print("List of "+i+" is ");
                while(x.hasNext())
                {
                    System.out.print("==>"+x.next());
                }
            }
        }

         void BFS(int s) {

            boolean visited[]=new boolean[V];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[s]=true;
             queue.add(s);

             while(queue.size()!=0)
             {
                 s=queue.poll();
                 System.out.print(s+", ");

                 Iterator<Integer> i=adj[s].listIterator();
                 while(i.hasNext())
                 {
                     int n=i.next();
                     if(visited[n]==false)
                     {
                         visited[n]=true;
                         queue.add(n);
                     }
                 }
             }

        }

        void DFS(int s) {

            boolean visited[]=new boolean[V];
            for (int i=0; i<V; ++i)
                if (visited[i] == false)
                    DFSUtil(i, visited);

        }

        void DFSUtil(int v, boolean[] visited) {
            visited[v]=true;
            System.out.print(v+", ");

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (visited[n]==false)
                    DFSUtil(n, visited);
            }
        }

    }


    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.print_adjlist();
        System.out.println();

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);

        System.out.println();
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);

    }


}