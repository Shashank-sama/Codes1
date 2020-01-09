import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;


class LAPD
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


        long t, A, B, C, M;
        t = sc.nextLong();
        M = 1000000007;
        for (int i = 0; i < t; i++) {
            A = sc.nextLong();
            B = sc.nextLong();
            C = sc.nextLong();

            long s = 0;
            for (long j = 2; j <= A; j++) {
                for (long k = 1; k <= B; k++) {
                    if ((k * k - 1) >= (j * C - j - C))
                        break;
                    for (long l = ((k*k-1+j)/(j-1)); l <= C; l++) {
                        if ((k * k - 1) == (j * l - j - l)) {
                            s = (s + (C - l)) % M;
                            break;
                        } else if ((k * k - 1) < (j * l - j - l)) {
                            s = (s + (C - l + 1)) % M;
                            break;
                        }
                    }
                }
            }
            s=s%M;
            System.out.println(s);
        }
    }}