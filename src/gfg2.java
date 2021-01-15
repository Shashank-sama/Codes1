import java.io.*;
import java.util.*;
import java.lang.*;


class gfg2 {

    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        //Question - 1 : India is well known for its spirituality and holy places,
        // a holy place is represented by '*' (rest of the cities are represented by '.'),
        // and all the cities which are neighbors (which shares a corner or a side) to holy places
        // are known as spiritual cities.
        //Geek wants to travel all spiritual places, but he decided to travel
        // from one city to another city if both of them are spiritual and neighbors too.
        //The task is to find the maximum number of spiritual cities geek can travel, starting from a spiritual city.
        //Note: A holy place is not considered as a spiritual city.

        // Example:
        //Input:
        //2
        //5 5
        //....*
        //.....
        //..*..
        //.....
        //.....
        //1 2
        //**

        //Output:
        //10
        //0

        //Explanation:
        //Testcase 1: (1, 4), (2, 2), (2, 3), (2, 4), (2, 5), (3, 2), (3, 4), (4, 2), (4, 3), (4, 4)
        // are the spiritual cities which geek will visit.

        char[][] a={{'.','.','.','.','*'},
                {'.','.','.','.','.'},
                {'.','.','*','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}};

        int n=5,m=5;
        int ans=maxCities(a,n,m);
        System.out.println("Soln. of Q1 is "+ans);

        //Question - 2 : Professor X wants his students to help each other in the chemistry lab.
        // He suggests that every student should help out a classmate who scored less marks than him in chemistry
        // and whose roll number appears after him.
        // But the students are lazy and they don't want to search too far.
        // They each pick the first roll number after them that fits the criteria.
        // Find the marks of the classmate that each student picks. If a student is unable to find anyone print -1.
        //Note: one student may be selected by multiple classmates.

        // Example:
        //Sample Input:
        //2
        //5
        //3 8 5 2 25
        //4
        //1 2 3 4

        //Sample Output:
        //2 5 2 -1 -1
        //-1 -1 -1 -1

        int[] arr={3,8,5,2,25};
        System.out.println("Soln. of Q2 is :");
        int aa[]=help_classmate(arr,arr.length);
        for(int i=0;i<arr.length;i++)
            System.out.print(aa[i]+", ");



        }



    static int maxCities(char a[][], int n, int m)
    {
        //code here.
        int dir[][]={{-1,-1,-1,0,0,1,1,1},{-1,0,1,-1,1,-1,0,1}};

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='*')
                {
                    for(int k=0;k<8;k++)
                    {

                        int x=i+dir[0][k];
                        int y=j+dir[1][k];
                        if(isSafe(x,y,n,m))
                        {
                            if(a[x][y]=='.')
                                a[x][y]='@';
                        }
                    }
                }
            }

        int max=0,z=0;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='@'&&vis[i][j]==false)
                    z=DFS(i,j,a,vis,n,m);

                if(z>max)
                    max=z;
            }
        }

        return max;
    }

    static int DFS(int i, int j, char[][] a, boolean[][] vis, int n, int m) {
        vis[i][j]=true;

        int dire[][]={{-1,-1,-1,0,0,1,1,1},{-1,0,1,-1,1,-1,0,1}};

        int maxx=0;

        for(int k=0;k<8;k++)
        {

            int x=i+dire[0][k];
            int y=j+dire[1][k];
            if(isSafe(x,y,n,m))
            {
                if(a[x][y]=='@'&&vis[x][y]==false)
                    maxx=maxx+DFS(x,y,a,vis,n,m);
            }
        }

        return 1+maxx;

    }


    static boolean isSafe(int i, int j, int n, int m)
    {
        if(i>=0&&i<n&&j>=0&&j<m)
            return true;
        else
            return false;
    }

    //____________________________________________________________________________________________________________
    //Soln. 2

    static int[] help_classmate(int arr[], int n)
    {
        // code here

        int[] ans=new int[n];
        for(int i=0;i<n;i++)
            ans[i]=-1;

        PriorityQueue<int []> pq=new PriorityQueue<>(Collections.reverseOrder((x,y)->y[0]==x[0]?x[1]-y[1]:x[0]-y[0]));

        for(int i=0;i<n;i++){
            int x[]=new int[2];
            x[0]=arr[i];
            x[1]=i;
            pq.add(x);

            x=pq.peek();

            while(x[0]>arr[i])
            {
                ans[x[1]]=arr[i];
                pq.poll();
                x=pq.peek();
            }
        }

        return ans;
    }

}