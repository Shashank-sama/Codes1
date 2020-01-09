import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class SUBSPLAY
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t,n;
        String s;
        t=sc.nextInt();
        for(int i=0;i<t;i++) {
            n = sc.nextInt();
            s = sc.next();

            /*int m[][] = new int[(int) n + 1][(int) n + 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if ((s.charAt(j - 1) == s.charAt(k - 1)) && j!=k)
                        m[j][k] = m[j - 1][k - 1] + 1;
                    else
                        m[j][k] = Math.max(m[j - 1][k], m[j][k - 1]);
                }
            }*/

            int a,b=0,x=n-1;

            for (int j = 0; j < n-1; j++)
            {
                for(int k=j+1;((k<n)&&(k<j+x+1));k++)
                {
                    if(s.charAt(j)==s.charAt(k))
                    {
                        a=n-(k-j);
                        b=Math.max(b,a);
                        x=Math.min(x,(k-j));
                    }
                }
            }

            /*if(m[n][n]<b)
                m[n][n]=b;

            System.out.println(m[(int) n][(int) n]);*/
            System.out.println(b);
        }


    }
}