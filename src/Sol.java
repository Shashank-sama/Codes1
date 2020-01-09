import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;


class Sol {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int h, w,M=1000000007;
        String s;
        h = sc.nextInt();
        w = sc.nextInt();
        char m[][] = new char[h][w];
        int dp[][]=new int[h][w];
        dp[0][0]=1;
        for (int i = 0; i < h; i++) {
            s = sc.nextLine();
            for (int j = 0; j < w; j++)
            {
                m[i][j] = s.charAt(j);

                if(m[i][j]=='#')
                    dp[i][j]=0;
                else if(i==0&&j>0)
                    dp[i][j]=dp[i][j-1]%M;
                else if(j==0&&i>0)
                    dp[i][j]=dp[i-1][j]%M;
                else if(i>0&&j>0)
                    dp[i][j]=((dp[i-1][j]%M)+(dp[i][j-1]%M))%M;
            }}

        System.out.println(dp[h-1][w-1]);
        //System.out.println(Maze(m, h, w));
    }


/*    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    static int Maze(char matrix[][], int n, int m) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0, 0));
        int count = 0;

        while (!q.isEmpty()) {
            pair p = q.peek();
            q.remove();
            if (p.first == n - 1 && p.second == m - 1)
                count++;
            if (p.first + 1 < n &&
                    matrix[p.first + 1][p.second] == '.') {
                q.add(new pair(p.first + 1, p.second));
            }
            if (p.second + 1 < m &&
                    matrix[p.first][p.second + 1] == '.') {
                q.add(new pair(p.first, p.second + 1));
            }
        }
        return count;
    }*/

}
