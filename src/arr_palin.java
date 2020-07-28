import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


public class arr_palin {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t,ans=0;
        t=sc.nextInt();
        int n;
        for(int i=0;i<t;i++)
        {
            ans=0;
            n=sc.nextInt();
            int m[]=new int[n];
            Map<Integer, Integer> mp=new HashMap<>();
            for(int j=0;j<n;j++)
            {
                m[j]=sc.nextInt();
                if(mp.containsKey(m[j]))
                {
                    if(mp.get(m[j])<(j-1))
                    {
                        ans=1;
                    }
                }
                else
                {
                    mp.put(m[j],j);
                }
            }

            if(ans==0)
                System.out.println("NO");
            else if(ans==1)
                System.out.println("YES");

        }

    }
}