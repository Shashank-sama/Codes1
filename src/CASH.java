
import java.io.*;
import java.util.*;


public class CASH {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,n,k;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            k=sc.nextInt();
            long A[]=new long[n];
            long fow[]=new long[n];
            long bac[]=new long[n];
            long f=0,b=0;

            for(int j=0;j<n;j++)
                A[j] = sc.nextLong();

            for(int j=0;j<n;j++) {
                fow[j]=A[j]%k+f;
                bac[n-1-j]=k-A[n-1-j]%k+b;
                f=fow[j];
                b=bac[n-1-j];
            }

            long s=fow[n-1];
            long s1;
            for(int j=n-2;j>=0;--j)
            {
                s1=fow[j]-bac[j+1];
                if(s1<0)
                    break;
                if(s1<s)
                    s=s1;
            }

            out.println(s);
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