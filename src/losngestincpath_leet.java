import java.io.*;
import java.util.*;
import java.lang.*;


class longestincpath_leet {

    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int[][] matrix={{7,8,9},
                        {9,7,6},
                        {7,2,3}};

        int ans=longestIncreasingPath(matrix);

            System.out.println(ans);
        }




    static int longestIncreasingPath(int[][] matrix) {

        int n=matrix.length;
        if(n==0)
            return 0;
        int m=matrix[0].length;


        int z=0;
        int max=1;
        int[][] dp=new int[n][m];           //used to store length of longest inc. path starting from that index

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                z=DFSUtil(i,j,matrix,dp);

                if(max<z)               //updating max value
                    max=z;
            }

        return max;

    }

    static int DFSUtil(int i, int j, int[][] matrix,int[][] dp) {

        if(dp[i][j]!=0)             //using dp[i][j] value to check if visited(value calculated) already or not
            return dp[i][j];

        int n=matrix.length;
        int m=matrix[0].length;
        int x=matrix[i][j];         //current value

        int x1=i-1,x2=i,x3=i,x4=i+1;            //i indices for 4 directions
        int y1=j,y2=j-1,y3=j+1,y4=j;            //j indices for 4 directions

        int a1=0,a2=0,a3=0,a4=0;                //storing values coming from 4 directions

        int maxx=1;

        if(x1>=0&&x1<n&&y1>=0&&y1<m)
            if(matrix[x1][y1]>x) {                          //left neighbour
                a1=1 + DFSUtil(x1,y1,matrix,dp);        //1 + neighbouring greater value position
                maxx=Math.max(maxx,a1);                     //updating max value for current position
            }

        if(x2>=0&&x2<n&&y2>=0&&y2<m)
            if(matrix[x2][y2]>x) {                          //top neighbour
                a2=1 + DFSUtil(x2,y2,matrix,dp);
                maxx=Math.max(maxx,a2);                     //updating max value
            }

        if(x3>=0&&x3<n&&y3>=0&&y3<m)
            if(matrix[x3][y3]>x) {                          //down neighbour
                a3=1 + DFSUtil(x3,y3,matrix,dp);
                maxx=Math.max(maxx,a3);                     //updating max value
            }

        if(x4>=0&&x4<n&&y4>=0&&y4<m)
            if(matrix[x4][y4]>x)  {                         //right neighbour
                a4=1 + DFSUtil(x4,y4,matrix,dp);
                maxx=Math.max(maxx,a4);                     //updating max value
            }

        dp[i][j]=maxx;          //storing max value for current position in dp[i][j]
        return dp[i][j];

    }
}
