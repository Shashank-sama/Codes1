import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class CHEFK1
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


        long t, n, m;
        t = sc.nextLong();
        for (int i = 0; i < t; i++)
        {
            n=sc.nextLong();
            m=sc.nextLong();
            if((m>=n-1)&&(m<=((n*(n+1))/2)))
            {
                if(m==0)
                    System.out.println("0");
                else if(m==1)
                    System.out.println("1");
                else if(m<=(n+1))
                    System.out.println("2");
                else if(m<=2*n)
                    System.out.println("3");
                else
                {
                    long k,z;
                    k=m/n;
                    z=2*k-1;
                    if(k*n==m)
                        System.out.println(z);
                    else if((k*n)<m)
                    {
                        long a,b,c;
                        a=m-(n*k);
                        b=n/2;
                        c=2*k;
                        if(a<=b)
                            System.out.println(c);
                        else
                            System.out.println(c+1);
                    }
                }
            }
            else
                System.out.println("-1");
        }
    }}