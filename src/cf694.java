import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class cf694
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

        /*
       // A :
         int t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n;
            n=sc.nextInt();
            long x;
            x=sc.nextLong();

            long[] arr=new long[n];
            long sum=0;
            long min,max=0;
            for(int j=0;j<n;j++) {
                arr[j] = sc.nextLong();
                sum = sum + arr[j];
                max+=(arr[j]+x-1)/x;
            }


            min=(sum+x-1)/x;

            System.out.println(min+" "+max);

            }
         */

//_______________________________________________________________________________________

        /*
       // B :

       int t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n;
            n=sc.nextInt();
            long x;
            x=sc.nextLong();

            long[] arr=new long[n];
            int[] dp=new int[n];
            long sum=0;
            //int end=n;
            for(int j=0;j<n;j++) {
                arr[j] = sc.nextLong();
                sum = sum + arr[j];

                //if(arr[j]%x!=0)
                  //  end=Math.min(end,j);

                if(j==0)
                    dp[j]=poww(arr[j],x);
                else
                    dp[j]=Math.min(dp[j-1], poww(arr[j],x));

            }

            for(int j=0;j<n;j++)
            {
                sum=sum+arr[j]*Math.min(dp[j],dp[n-1]+1);
            }



            System.out.println(sum);

        }
        }



  public  static int poww(long a, long x)
    {
        int i=0;
        while(a%x==0)
        {
            ++i;
            a=a/x;
        }

        return i;
    }

         */

        //________________________________________________________________________________________

        // C :

        int t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n,m;
            n=sc.nextInt();
            m=sc.nextInt();
            int[] fr=new int[n];
            int[] dp=new int[m];
            for(int j=0;j<n;j++) {
                fr[j] = sc.nextInt();
                dp[fr[j]-1] += 1;
            }

            long[] pr=new long[m];
            TreeMap<Long, Integer> mp=new TreeMap<>();

            for(int j=0;j<m;j++) {
                pr[j] = sc.nextLong();

                if (!mp.containsKey(pr[j]))
                    mp.put(pr[j], 1);
                else
                    mp.put(pr[j], mp.get(pr[j]) + 1);
            }

            long s=0;
            for(int j=m-1;j>-1;--j)
            {
                while(dp[j]>0) {
                    for (Map.Entry<Long, Integer> entry : mp.entrySet()) {
                        long x = entry.getKey();
                        int y = entry.getValue();
                        if (x == pr[j]) {
                            s = s + x * dp[j];
                            dp[j] = 0;
                            mp.put(pr[j], 0);
                            break;
                        } else {
                            if (y > 0) {
                                s = s + x;
                                mp.put(x, y - 1);
                                dp[j] -= 1;
                                break;
                            }
                        }
                    }
                }
            }



            System.out.println(s);

        }
    }

}




