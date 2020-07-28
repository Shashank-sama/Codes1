import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class kickb1 {
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
            int s=0;
            n=sc.nextInt();
            int m[]=new int[n];
            for(int j=0;j<n;j++)
            {
                m[j]=sc.nextInt();
                if(j>1)
                {
                    if(m[j-1]>m[j-2]&&m[j-1]>m[j])
                        s+=1;
                }
            }

            System.out.println("Case #"+(i+1)+": "+s);

        }



    }
}