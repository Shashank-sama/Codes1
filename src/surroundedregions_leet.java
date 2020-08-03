import java.io.*;
import java.util.*;
import java.lang.*;


class surroundedregions_leet {

    public static void main (String[] args)throws java.lang.Exception
        {
            Scanner sc = new Scanner(System.in);

            char[][] board={{'X','X','X','X'},
                            {'X','O','O','X'},
                            {'X','X','O','X'},
                            {'X','O','X','X'}};

            solve(board);       //Convert all regions of O's which are completely surrounded by X's

            for(int i=0;i<4;i++) {
                for (int j = 0; j < 4; j++)
                    System.out.print(board[i][j]);

                System.out.println();
            }


        }


    static void solve(char[][] board) {

        int n=board.length;
        if(n>2)
        {
            int m=board[0].length;
            if(m>2)
                DFS(board,n,m);
        }


    }

    static void DFS(char[][] board,int n, int m) {
        boolean visited[][]=new boolean[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if((i==0||i==n-1||j==0||j==m-1)&&board[i][j]=='O'&&visited[i][j]==false)
                {
                    DFSUtil(i,j,visited,board);
                }
            }

        }

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(board[i][j]=='O'&&visited[i][j]==false)
                    board[i][j]='X';

    }

    static void DFSUtil(int i, int j, boolean[][] visited, char[][] board) {

        int n=board.length;
        int m=board[0].length;

        if(i<0||i>=n||j<0||j>=m)
            return;

        visited[i][j]=true;

        int x1=i-1,x2=i,x3=i,x4=i+1;
        int y1=j,y2=j-1,y3=j+1,y4=j;

        if(x1>=0&&x1<n&&y1>=0&&y1<m)
            if(board[x1][y1]=='O'&&visited[x1][y1]==false)
                DFSUtil(x1,y1,visited,board);

        if(x2>=0&&x2<n&&y2>=0&&y2<m)
            if(board[x2][y2]=='O'&&visited[x2][y2]==false)
                DFSUtil(x2,y2,visited,board);

        if(x3>=0&&x3<n&&y3>=0&&y3<m)
            if(board[x3][y3]=='O'&&visited[x3][y3]==false)
                DFSUtil(x3,y3,visited,board);

        if(x4>=0&&x4<n&&y4>=0&&y4<m)
            if(board[x4][y4]=='O'&&visited[x4][y4]==false)
                DFSUtil(x4,y4,visited,board);


    }
}
