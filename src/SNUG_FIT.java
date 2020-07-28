
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SNUG_FIT {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,n;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            long A[]=new long[n];
            long B[]=new long[n];
            for(int j=0;j<n;j++)
                A[j]=sc.nextLong();
            for(int j=0;j<n;j++)
                B[j]=sc.nextLong();

            Arrays.sort(A);
            Arrays.sort(B);

            long s=0;
            for(int j=0;j<n;j++)
            {
                s=s+Math.min(A[j],B[j]);
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