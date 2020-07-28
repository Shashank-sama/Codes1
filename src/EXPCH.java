
import java.io.*;
import java.util.*;

public class EXPCH {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t;
        long n;
        String s;
        //char c;
        long p,q,M=1000000007,sum=0;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            sum=0;
            n=sc.nextLong();
            s=sc.next();
//            long arr[]=new long[n];
//            long nc=0,no=0;
//            for(int j=0;j<n;j++)
//            {
//                nc=no=0;
//                for(int k=j;k<n;k++)
//                {
//                    if(s.charAt(k)==')')
//                        ++nc;
//                    else if(s.charAt(k)=='(')
//                        ++no;
//                    if(nc>no) {
//                        nc -= 1;
//                        no += 1;
//                        sum = sum + (n-k);
//                    }
//
//                }
//            }

            // Map<Integer, Integer> bus = new HashMap<>();
            //TreeMap<Integer, Integer> stack = new TreeMap<>();
            int st[]=new int[(int)n];
            int cn=0,u=-1;
            //int z=0;
            long s_even=0, s_odd=0;
            int index[]=new int[(int)n];
            // for(int k=0;k<n;k++)
            //     index[k]=-1;
            for(int j=0;j<n;j++)
            {
                if(s.charAt(j)=='(')
                {
                    //stack.put(++z,j);
                    st[++u]=j;
                }
                else if(s.charAt(j)==')')
                {
                    if(u>-1)
                    {
                        index[st[u]]=j;
                        //stack.remove(stack.lastKey());
                        //--z;
                        --u;
                    }
                    else {
                        //bus.put(j, -1);
                        ++cn;
                        if(cn%2==1)
                            s_odd+=n-j;
                        else
                            s_even+=n-j;
                    }
                }
            }

            int y;
            long ss;
            //long indsum[]=new long[(int)n];
            for(int j=0;j<n;j++)
            {
                sum+=s_odd;
                if(s.charAt(j)=='(')
                {
                    //indsum[j]+=s_odd;
                    if(index[j]!=0)
                    {
                        y=index[j];
                        //bus.put(y,-1);
                        ss=s_even;
                        s_even=s_odd;
                        s_odd=ss+(n-y);
                    }
                }
                else if(s.charAt(j)==')')
                {
                    //indsum[j]+=s_odd;

                    //bus.remove(j);
                    ss=s_even;
                    s_even=s_odd-(n-j);
                    s_odd=ss;
                }
                //else
                //indsum[j]+=s_odd;

                //sum+=indsum[j];

            }

            // for(int j=n-2;j>-1;--j)
            // {
            //     if(s.charAt(j)=='*')
            //     {
            //         indsum[j]=indsum[j+1];
            //     }
            // }


            // for(int j=0;j<n;j++)
            //     sum+=indsum[j];


            p=sum;
            q=n*(n+1)/2;
            //p=50000L*50001L*200005L/6L;
            //q=50000L*100001L;
            long g=gcd(p,q);
            p=p/g;
            q=q/g;
            long inv = modInverse(q,M);
            long ans = ((p%M)*(inv%M))%M;


            out.println(ans);
            out.flush();
        }
        out.flush();
        out.close();
    }

    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long modPow(long a, long x, long p) {
        //calculates a^x mod p in logarithmic time.
        long res = 1;
        while(x > 0) {
            if( x % 2 != 0) {
                res = ((res%p) * (a%p)) % p;
            }
            a = ((a%p) * (a%p)) % p;
            x = x/2;
        }
        return res;
    }

    static long modInverse(long a, long p) {
        //calculates the modular multiplicative of a mod m.
        //(assuming p is prime).
        return modPow(a, p-2, p);
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