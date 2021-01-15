import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class edu102
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

        int test;
        test = sc.nextInt();
        for (int i = 0; i < test; i++) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                if (j < k)
                    a[j] = j + 1;
                else
                    a[j] = 2 * k - (j + 1);
            }





            /*int n=sc.nextInt();
            int m=sc.nextInt();

            String s=sc.next();
            int[][] q=new int[m][2];
            for(int j=0;j<m;j++)
            {
                q[j][0]=sc.nextInt();
                q[j][1]=sc.nextInt();
            }*/



        }
    }



    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }
}





