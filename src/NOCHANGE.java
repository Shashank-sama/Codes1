
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NOCHANGE {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,n;
        long p;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            p=sc.nextLong();
            long D[]=new long[n];

            long c=0,f=0;
            Map<Integer, Integer> mp=new HashMap<>();
            for(int j=0;j<n;j++) {
                D[j] = sc.nextLong();
                mp.put((int)D[j],j);
                if(p%D[j]==0)
                    ++c;
                else
                    f=D[j];
            }

            if(c==n) {
                Arrays.sort(D);
                long c1=0,a=0,b=0;
                for(int j=0;j<n-1;j++)
                {
                    if(D[j+1]%D[j]==0)
                        ++c1;
                    else
                    {
                        a=D[j];
                        b=D[j+1];
                    }
                }
                if(c1==n-1)
                out.print("NO");
                else
                {
                    long x,y;
                    y=p/b-1;
                    x=b/a+1;
                    out.print("YES ");
                    long z[]=new long[n];
                    z[mp.get((int)b)]=y;
                    z[mp.get((int)a)]=x;
                    for(int j=0;j<n;j++)
                        out.print(z[j]+" ");
                }
                out.flush();
            }
            else {
                /*int loc=0;
               // long d[]=new long[n];
                long []d1=new long[n];
                out.print("YES ");

                Arrays.sort(D);
                for(int j=n-1;j>-1;--j)
                {
                    if(p%D[j]==0)
                        d1[j]=-1;
                    else
                        loc=j;
                }

                long sum=p;
                int flag=0,loc2=0;
                for(int j=n-1;j>-1;--j)
                {
                    if(d1[j]!=-1)
                    {
                        if(j!=loc)
                        {
                            loc2=j;
                            if(sum%D[j]!=0)
                            {
                                d1[j]=sum/D[j];
                                sum=sum%D[j];
                            }
                            else
                                d1[j]=0;
                        }
                        else
                        {
                            if(sum%D[j]!=0)
                            {
                                d1[j]=sum/D[j]+1;
                                sum=sum%D[j];
                            }
                            else
                            {
                                d1[j]=0;
                                flag=1;
                            }
                        }
                    }
                }
                if(flag==1)
                for(int j=loc2;j<n;j++)
                {
                    if(d1[j]!=-1)
                    {
                        if(sum%D[j]!=0)
                        {
                            d1[j]=d1[j]+sum/D[j]+1;
                            break;
                        }
                    }

                }

                long x[]=new long[n];
                int a;
                for(int j=0;j<n;j++)
                {
                    a=mp.get((int)D[j]);
                    x[a]=d1[j];
                }
                for(int j=0;j<n;j++) {
                    if(x[j]!=-1)
                        out.print(x[j]+" ");
                    else
                        out.print("0 ");
            }*/
                out.print("YES ");
                long h = p / f + 1;
                for (int j = 0; j < n; j++) {
                    if (D[j] == f)
                        out.print(h + " ");
                    else
                        out.print("0 ");
                }

                out.flush();
            }




            out.println();
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