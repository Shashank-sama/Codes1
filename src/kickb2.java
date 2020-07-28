import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class kickb2 {
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

        int t,n;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {

            n=sc.nextInt();
            long d=sc.nextLong();
            long m[]=new long[n];
            long max=d;
            for(int j=0;j<n;j++)
            {
                m[j]=sc.nextLong();
                //long x=(d/m[j])*m[j];
                //if(x<=max)
                   // max=x;
            }

            for(int j=n-1;j>-1;j--)
            {
                long x=(max/m[j])*m[j];
                if(x<=max)
                    max=x;
            }



            System.out.println("Case #"+(i+1)+": "+max);

        }



    }
}