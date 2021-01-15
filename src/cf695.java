import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class cf695
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

        //A :
        /*
        int t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n;
            n=sc.nextInt();


            if(n>=2) {
                System.out.print("98");
                n = n - 2;
            }
            int x=9;
            for(int j=0;j<n;j++) {
                int y=(x+j)%10;
                System.out.print(y);
            }

            System.out.println();

         */

        //B : WA

        int t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n;
            n=sc.nextInt();


            long[] arr=new long[n];
            int[] dp=new int[n];
            for(int j=0;j<n;j++) {
                arr[j]=sc.nextLong();
            }

            int cn=0;
            for(int j=1;j<n-1;j++){
                if(arr[j]<arr[j-1]&&arr[j]<arr[j+1]) {
                    ++cn;
                    dp[j] = -1;
                }
                else if(arr[j]>arr[j-1]&&arr[j]>arr[j+1]) {
                    ++cn;
                    dp[j] = 1;
                }
            }

            int f=1;
            for(int j=1;j<n-1;j++) {
                if(dp[j-1]*dp[j]==-1&&dp[j]*dp[j+1]==-1)
                    f=Math.max(f,3);
                else if(dp[j-1]*dp[j]==-1||dp[j]*dp[j+1]==-1)
                    f=Math.max(f,2);
            }


                cn=Math.max(0,cn-f);


            System.out.println(cn);


        }
    }}




