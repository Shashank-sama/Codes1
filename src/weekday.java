//Made for checking LONGCOOK
import java.io.*;
import java.util.*;


public class weekday {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,n;
        t=sc.nextInt();
        if(t!=-1)
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            int m[][]=new int[2][n+1];
            int p;
            if(n>=2020)
            {
                m[1][2020]=6;
                m[0][2020]=2020;
                for(int j=2021;j<=n;j++)
                {
                    m[0][j]=j;
                    p=leap(j-1);
                    if(p==1)
                        m[1][j]=(m[1][j-1]+2)%7;
                    else
                        m[1][j]=(m[1][j-1]+1)%7;
                }
                for(int j=2019;j>-1;--j)
                {
                    m[0][j]=j;
                    p=leap(j);
                    if(p==1)
                        m[1][j]=(m[1][j+1]-2+7)%7;
                    else
                        m[1][j]=(m[1][j+1]-1+7)%7;
                }
            }


                for (int k = 0; k <= n; k++)
                    out.print(m[0][k] + "="+m[1][k]+",");
                out.println();

            out.flush();
        }
        else
        {
            int t1,n1;
            t1=sc.nextInt();
            for(int i=0;i<t1;i++)
            {
                n1=sc.nextInt();
                long y=n1;
                int x=2;
                long a,b,c;
                a=y/400;
                y=y%400;
                if(y>100&&y!=200&&y!=300)
                    x=(x-1+7)%7;
                b=y/100;
                if(b>0)
                    x=(x+6+((int)(b-1)*5)%7)%7;
                y=y%100;
                c=y/4;
                x=(x+((int)c*5)%7)%7;
                y=y%4;
                if(y>0)
                    x=(x+2+(int)y-1 )%7;

                out.println(x);
                out.flush();
            }
        }
        out.flush();
        out.close();
    }

    static int leap(int y)
    {
        int f=0;
        if((y%4==0&&y%100!=0)||(y%400==0))
            f=1;
        return f;
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader fileReader) {
            br = new BufferedReader(fileReader);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}