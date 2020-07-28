import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


public class longpalin {
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

        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        String l="",r="",p="",s,s1="";
        int f=0,x, z=0;
        Map<String , Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            s1="";
            s=sc.next();
            if(f==0)
            {
               x=palin(s,m);
               if(x==1)
               {
                   f=1;
                   p=s;
               }
            }

            for(int j=0;j<m;j++)
            {
                s1=s.charAt(j)+s1;
            }

            if(mp.containsKey(s1))
            {
                z=z+2;
                l=l+s1;
                r=s+r;
                //mp.put(s,1);
            }
            else
                mp.put(s,1);

        }

        int ans=(z+f)*m;
        String a=l+p+r;

        System.out.println(ans);
        System.out.println(a);



    }

    static int palin(String s, int l)
    {
        int f=1;
        for(int i=0;i<l;i++)
        {
            if(s.charAt(i)!=s.charAt(l-1-i))
            {
                f=0;
                break;
            }
        }
        return f;
    }
}