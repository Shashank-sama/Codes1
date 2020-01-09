import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class DOOFST {

    public static void main(String[] args) {
        FastReader sc = new FastReader();


        int n,m,k=0,x,y,p;
        n=sc.nextInt();
        m=sc.nextInt();
        int a[][]=new int[m][2];
        for(int j=0;j<61;j++)
        {
            p=n/(int)(Math.pow(2,j));
            if(p<1||(p==1&&((int)Math.pow(2,j))*p==n))
            {
                k=j;
                break;
            }
        }
        for(int i =0;i<m;i++)
        {
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }


        String s;

        if(k*n<=1000000)
        {
            System.out.println(k);
            for(int i=k-1;i>=0;i--)
            {
                x=(int)Math.pow(2,i);
                s=stri(x,n);
                System.out.println(s);
            }
        }
        else
            System.out.println("-1");

        //String t;
        //int z1,z0;

        /*if(k*n<=1000000) {
            System.out.println(k);
            t=str("1",(k))+str("0",(n-k));
            System.out.println(t);
            for (int i = 1; i < k; i++) {
                z1=(i+1)%2;
                z0=i%2;
                t = t.substring(0,i)+str(String.valueOf(z1),(x-i+1))+str(String.valueOf(z0),(n-1-i-x))+t.substring(n-i);
                System.out.println(t);
            }
        }
        else
            System.out.println("-1");*/





    }

    /*static String str(String y, int z)
    {
        String t="";
        for(int i=0;i<z;i++)
            t=t+y;
        return t;
    }*/

    static String stri(int y, int z)
    {
        int x;
        String t="";
        for(int i=0;i<z;i++)
        {
            x=((i+y)/y)%2;
            t=t+String.valueOf(x);
        }
        return t;
    }

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
}