import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


public class subrem {
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

        long n;
        long M=998244353L;
        long ans;
        String s;
        n=sc.nextLong();
        s=sc.next();
        long l=1,r=1;
        char a,b;
        a=s.charAt(0);
        b=s.charAt((int)n-1);

        for (int i = 1; i < (int)n; i++)
            if (s.charAt(i) == a)
                ++l;
            else
                break;

        for (int i = (int)n - 2; i > 0; i--)
            if (s.charAt(i) == b)
                ++r;
            else
                break;


        if(a!=b) {
            ans = l + r +1 ;
        }
        else
        {
//                if(l==r&&r==n)
//                {
//                    ans=n*(n+1)/2 + 1;
//                }
//                else
                {
                    ans=l+r+l*r+1;
                }
        }

        ans=ans%M;
        System.out.println(ans);


    }
}