import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class FUZZYLIN {
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

        int n, q;
        n = sc.nextInt();
        long m[] = new long[n];
        for (int i = 0; i < n; i++)
            m[i] = sc.nextLong();

        q = sc.nextInt();
        long k[] = new long[q];
        long k1[]= new long[q];
        for (int i = 0; i < q; i++) {
            k[i] = sc.nextLong();
            //for (int j = 0; j < n; j++)
             //   if (k[i] % m[j] == 0)
             //       k1[i] += 1;
        }

        /*long a,b;
        a=(n*(n+1))/2-((n*(n+1))/2)/2;
        b=((n*(n+1))/2)/2;
        long u[]=new long[(int)a];
        long v[]=new long[(int)b];

        int x=0,y=0;
        long t;
        for(int i=0;i<n;i++)
            for(int j=0;j<n-i;j++) {
                t = m[j];
                for (int l = j; l <= i + j; l++)
                    t = gcd(t, m[l]);

                if (x < a) {
                    u[x] = t;
                    ++x;
                } else {
                    v[y] = t;
                    ++y;
                }
            }

        for(int i=0;i<a;i++)
            for(int j=0;j<q;j++)
                if(k[j]%u[i]==0)
                    k1[j]+=1;

        for(int i=0;i<b;i++)
            for(int j=0;j<q;j++)
                if(k[j]%v[i]==0)
                    k1[j]+=1;*/



        /*long x;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i;j++)
            {
                x=m[i];
                for(int l=i;l<=i+j;l++)
                {
                   x=gcd(x,m[l]);
                }
                if(x==1)
                {
                    for(int r=0;r<q;r++)
                        k1[r]+=(n-i-j);
                    break;
                }
                else
                    {
                    for (int r = 0; r < q; r++)
                        if (k[r] % x == 0)
                            k1[r] += 1;
                }
            }
        }*/

        for(int i=0;i<q;i++)
            System.out.println(k1[i]);
    }

    static long gcd(long a, long b)
    {
        if(a==0)
            return b;
        return gcd(b%a, a);
    }
}

