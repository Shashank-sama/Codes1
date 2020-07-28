import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class jam1c2 {
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

        int t,u;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {

            u=sc.nextInt();
            String d="";
            int arr[]=new int[26];
            int flag=0;

            Map<Character, Integer> mp=new HashMap<>();
            Map<Character, Integer> mp0=new HashMap<>();

            for(int j=0;j<10000;j++)
            {
                long m=sc.nextLong();
                String s=sc.next();

                if(m>=0) {
                    if (s.length() == u) {
                        for (int k = 0; k < s.length(); k++) {
                            char c = s.charAt(k);
                            if (k == 0) {
                                int z = firstDigit(m);
                                if (!mp.containsKey(c)) {
                                    mp.put(c, z);

                                    mp0.put(c, -1);
                                } else {
                                    mp.put(c, Math.min(z, mp.get(c)));

                                    mp0.put(c, -1);
                                }
                            } else {
                                if (!mp.containsKey(c)) {
                                    mp.put(c, 9);

                                    if (!mp0.containsKey(c))
                                        mp0.put(c, 0);

                                }
                            }

                        }
                    } else {
                        for (int k = 0; k < s.length(); k++) {
                            char c = s.charAt(k);

                            if (!mp.containsKey(c)) {
                                mp.put(c, 9);
                            }

                            if (k == 0) {
                                if (!mp0.containsKey(c))
                                    mp0.put(c, -1);
                            } else {
                                if (!mp0.containsKey(c))
                                    mp0.put(c, 0);
                            }
                        }
                    }
                }
                else {
                    //int y = 1;
                    flag=1;
                    for (int k = 0; k < s.length(); k++) {
                        char c = s.charAt(k);

                        if (!mp.containsKey(c))
                            mp.put(c, 9);

                        if (k == 0) {
                            //if (!mp0.containsKey(c))
                            mp0.put(c, -1);

                            ++arr[(int)(c-'A')];
                        } else {
                            if (!mp0.containsKey(c))
                                mp0.put(c, 0);
                        }
                    }
                }

            }



            for(Character key: mp0.keySet())
            {
                int val=mp0.get(key);
                if(val==0)
                {
                    d=d+key;
                    mp.remove(key);
                    break;
                }
            }

            if(flag==0) {
                for(int x=1;x<=9;x++)
                {
                    for(Character key: mp.keySet())
                    {
                        int val=mp.get(key);
                        if(val==x)
                        {
                            d=d+key;
                            //mp.remove(key);
                            //break;
                        }
                    }
                }
            }
            else
            {
                int z=0,p1=-1;
                for(int x=1;x<=9;x++)
                {
                    for(int p=0;p<26;p++)
                    {
                        if(z<arr[p])
                        {
                            z=arr[p];
                            p1=p;
                        }
                    }
                    d=d+(char)(p1+'A');
                    z=0;
                    arr[p1]=0;
                }
            }





            System.out.println("Case #"+(i+1)+": "+d);

        }



    }

    static int firstDigit(long n)
    {
        // Remove last digit from number
        // till only one digit is left
        while (n >= 10)
            n /= 10;

        // return the first digit
        return (int)n;
    }
}