import java.math.*;
        import java.util.*;
        import java.lang.*;
        import java.io.*;


class CRECT {
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
            long sum=0;
            n=sc.nextInt();
            int m[][]=new int[n][2];
            int min_sq=10000000,min_rec=10000000,  count=0;
            for(int j=0;j<n;j++)
            {
                m[j][0]=sc.nextInt();
                m[j][1]=sc.nextInt();

                if(m[j][1]>3&&(m[j][1]%4<2))
                {
                    if(m[j][0]<min_sq)
                        min_sq=m[j][0];
                }

                if(m[j][1]%4>1)
                {
                    if(m[j][0]<min_rec)
                        min_rec=m[j][0];

                    ++count;
                }

                sum=sum+m[j][0]*(m[j][1]-m[j][1]%2);

            }

            if(count%2!=0)
            {
                sum=sum-2*Math.min(min_rec,min_sq);
            }

            System.out.println(sum);

        }



    }
}
