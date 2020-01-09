import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class BINADD
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t;
        String s1, s2, s;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l1, l2, L;
            s1 = sc.next();
            s2 = sc.next();
            l1 = s1.length();
            l2 = s2.length();

            if (s2.equals("0"))
                System.out.println("0");
            else if (s1.equals("0"))
                System.out.println("1");
            else {
                int l, p = 1, q = 1, z;
                char a, b;
                l = Math.min(l1, l2);


                for (int j = 0; j <l; j++) {

                    a = s1.charAt(l1 - 1 - j);
                    b = s2.charAt(l2-1-j);
                    q = 1;
                    if (a == '1' && b == '1') {
                        ++q;
                        z = j + 1;

                        if(l==l1) {
                            s = s2;
                            L = l2;
                        }
                        else {
                            s = s1;
                            L = l1;
                        }

                        int flag=0;
                        if(z<l)
                        {
                            while((z<l)&&(flag==0)) {
                                if (s1.charAt(l1 - 1 - z) != s2.charAt(l2 - 1 - z)) {
                                    ++q;
                                    ++z;
                                }
                                else
                                    flag=1;
                            }
                            while((z<L)&&(flag==0))
                            {
                                if(s.charAt(L-1-z)=='1')
                                {
                                    ++q;
                                    ++z;
                                }
                                else
                                    flag=1;
                            }
                        }
                        else {
                            while ((z < L) && (flag == 0)) {
                                if (s.charAt(L - 1 - z) == '1') {
                                    ++q;
                                    ++z;
                                } else
                                    flag = 1;
                            }
                        }

                       /* while (((s1.charAt(l1 - 1 - z) != s2.charAt(l2 - 1 - z)) && (z < l)) || ((z >= l) && (s.charAt(L - 1 - z) == '1'))) {
                            ++q;
                            ++z;
                        }*/

                        if (p < q)
                            p = q;
                    }
                }

                System.out.println(p);
            }
        }
    }}




