
import java.io.*;
import java.util.*;


public class DECOREST {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,n;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            long x,max=-1;
            //long A[][]=new long[n][2];
            long a[][]=new long[n][2];
            TreeMap<Long, Integer> mp=new TreeMap<>();
            for(int j=0;j<n;j++) {
               x = sc.nextInt();
               a[j][0]=x;
               if(max<x) {
                   max = x;
                   mp.put(x, j);
               }
               else
               {
                   a[mp.get(max)][1]=j;
                   mp.remove(max);
                   mp.put(x,j);
                   max=mp.lastKey();
               }
            }
            for(int j=n;j<2*n;j++)
            {
                max=mp.lastKey();
                a[mp.get(max)][1]=j;
                mp.remove(max);
                if(mp.isEmpty())
                    break;
            }

            for(int j=0;j<n;j++)
                out.print(a[j][1]+" ");
            out.println();
            out.flush();


            }


        out.flush();
        out.close();
    }

//    static int gcd(int a, int b)
//    {
//        if (b == 0)
//            return a;
//        return gcd(b, a % b);
//    }

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