import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class GDSUB
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


        int n, k;
        long M=1000000007;
        n = sc.nextInt();
        k = sc.nextInt();
        int m[] = new int[n];
        for (int i = 0; i < n; i++)
            m[i] = sc.nextInt();

        Arrays.sort(m);

        int n1=1;
        for(int i=1;i<n;i++)
        {
            if(m[i]>m[i-1])
                ++n1;
        }

        int m1[]=new int[n1];
        m1[0]=1;
        int x=0;
        for(int i=1;i<n;i++) {
            if (m[i] == m[i - 1])
                ++m1[x];
            else if (m[i] > m[i - 1]) {
                ++x;
                ++m1[x];
            }
        }

        long C[]=new long[n1+1];
        C[0]=m1[0];
        C[1]=1;
        for(int p=2;p<=n1;p++)
        {
            C[p]=1;
            for(int q=p-2;q>=0;q--)
            {
                C[q+1]=(C[q]+C[q+1]*m1[p-1])%M;
            }
            C[0]=(C[0]*m1[p-1])%M;
        }

        long sum=0;
        if(k>n1)
            k=n1;
        for(int i=0;i<=k;i++)
        {
            sum=(sum+C[n1-i])%M;
        }
        sum =sum%M;
        System.out.println(sum);
    }}

