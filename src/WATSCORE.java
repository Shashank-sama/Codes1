import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class WATSCORE
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

        int t, n;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            int m[] = new int[8];
            int p, s;
            for (int j = 0; j < n; j++) {
                p = sc.nextInt();
                s = sc.nextInt();
                if (p < 9) {
                    if (m[p - 1] < s)
                        m[p - 1] = s;
                }
            }
            int a = 0;
            for (int k = 0; k < 8; k++)
                a = a + m[k];

            System.out.println(a);
        }
    }
}


