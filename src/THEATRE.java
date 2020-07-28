
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class THEATRE {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,n,p=0;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            int arr[][]=new int[4][4];
            //int m[][]=new int[24][4];
            int a;
            char c;
            for(int j=0;j<n;j++)
            {
                c=(sc.next()).charAt(0);
                a=sc.nextInt();
                arr[(int)c-65][(a/3)%4]+=1;
            }

            int m[][]={{0,1,2,3},
                       {0,1,3,2},
                       {0,2,1,3},
                       {0,2,3,1},
                       {0,3,1,2},
                       {0,3,2,1},
                        {1,0,2,3},
                        {1,0,3,2},
                        {1,2,0,3},
                        {1,2,3,0},
                        {1,3,0,2},
                        {1,3,2,0},
                        {2,1,0,3},
                        {2,1,3,0},
                        {2,0,1,3},
                        {2,0,3,1},
                        {2,3,1,0},
                        {2,3,0,1},
                        {3,1,2,0},
                        {3,1,0,2},
                        {3,2,1,0},
                        {3,2,0,1},
                        {3,0,1,2},
                        {3,0,2,1}};

            int z[]=new int[4];
            int sum=0,s=0;
            for(int j=0;j<24;j++)
            {
                z[0]=arr[m[j][0]][0];
                z[1]=arr[m[j][1]][1];
                z[2]=arr[m[j][2]][2];
                z[3]=arr[m[j][3]][3];

                Arrays.sort(z);
                s=0;
                for(int k=0;k<4;k++)
                {
                    if(z[k]==0)
                        s-=100;
                    else
                        s=s+z[k]*((k+1)*25);
                }

                if(j==0)
                    sum=s;

                if(s>sum)
                    sum=s;
            }

            p=p+sum;
            out.println(sum);
            out.flush();
        }
        out.println(p);
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