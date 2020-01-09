import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class PLMU
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
            long a;
            int p = 0, q = 0;
            for (int j = 0; j < n; j++) {
                a = sc.nextLong();
                if (a == 0)
                    ++p;
                if (a == 2)
                    ++q;
            }

            long s;
            s = (p * (p - 1) / 2) + (q * (q - 1) / 2);

            System.out.println(s);
        }
    }}

