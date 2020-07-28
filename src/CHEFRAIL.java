import java.io.*;
import java.util.*;


public class CHEFRAIL {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,n,m;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            m=sc.nextInt();
            long z;
            Map<Long,Integer> xx=new HashMap<>();
            Map<Long,Integer> yy=new HashMap<>();
            for(int j=0;j<n;j++) {
                z=sc.nextLong();
                xx.put(z,1);
            }
            for(int j=0;j<m;j++) {
                z=sc.nextLong();
                yy.put(z,1);
            }

            long a,b,c=0;
            for(Long e1 : xx.keySet())
            {
                if(e1!=0) {
                    a = -(e1 * e1);
                    for (Long e2 : yy.keySet()) {
                        if (e2 != 0)
                            if (((a / e2) * e2) == a) {
                                b = a / e2;
                                if (yy.containsKey(b))
                                    ++c;
                            }
                    }
                }
            }

            for(Long e1 : yy.keySet())
            {
                if(e1!=0) {
                    a = -(e1 * e1);
                    for (Long e2 : xx.keySet()) {
                        if (e2 != 0)
                            if (((a / e2) * e2) == a) {
                                b = a / e2;
                                if (xx.containsKey(b))
                                    ++c;
                            }
                    }
                }
            }

            c=c/2;

            if(yy.containsKey(0L))
                c=c+(m-1)*n;
            if(xx.containsKey(0L))
                c=c+m*(n-1);

            out.println(c);
            out.flush();
        }
        out.flush();
        out.close();
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