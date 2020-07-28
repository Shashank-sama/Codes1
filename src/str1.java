import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


public class str1 {
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

        int t,ans=0;
        t=sc.nextInt();
        String s,r,z,x;
        for(int i=0;i<t;i++)
        {
            ans=0;
            s=sc.next();
            r=sc.next();
            z="";
            int j1,f;
            for(int j=0;j<r.length();j++)
            {
                x=s;
                j1=j;
                if(x.indexOf(r.charAt(j1))==-1)
                {
                    ans=-1;
                    break;
                }
                else
                {
                    ++ans;
                    f=x.indexOf(r.charAt(j1));
                    while(f!=-1) {
                        x = x.substring(f + 1);
                        ++j1;
                        if(j1==r.length())
                            break;
                        f=x.indexOf(r.charAt(j1));

                    }

                    j=j1-1;

                }
            }



            System.out.println(ans);

        }

    }
}