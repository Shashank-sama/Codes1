
import java.io.*;
import java.util.*;


public class DECOGCD {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,n;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            int m[]=new int[n];
            int g,flag=0,c=0;
            m[0]=sc.nextInt();
            g=m[0];

            for(int j=1;j<n;j++) {
                m[j] = sc.nextInt();
                g=gcd(g,m[j]);
            }

            if(g!=1) {
                out.println("-1");
                out.flush();
            }
            else
            {

                int k,f=0;
                for(int j=0;j<n;j++)
                {
                    if(f==1)
                        break;
                    k=j+1;
                    g=m[j];
                    if(g==1) {
                        ++c;
                    }
                    else
                    {
                        while(g!=1)
                        {
                            if(k<n)
                            g=gcd(g,m[k]);
                            ++k;

                            if(g==1)
                            {
                                ++c;
                                j=k-1;
                                break;
                            }
                            if(k>=n)
                            {
                                f=1;
                                break;
                            }
                        }
                    }
                    out.flush();
                }

                out.println(c);
                out.flush();


            }

        }
        out.flush();
        out.close();
    }

    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
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