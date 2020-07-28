import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class kickb3 {
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

        int t;
        long M=1000000000L;
        String s;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            s=sc.next();
            int l=s.length();

            long W=1,H=1;
            long w=0,h=0;

            long op[][]=new long[2000][3];
            int p=-1;
            for(int j=0;j<s.length();j++)
            {
                if((int)s.charAt(j)<=57&&(int)s.charAt(j)>47)
                {
                    /*int x=0,z=0,p1=0;
                    String s1="",ss;
                    l=s.length();
                    for(int k=j+1;k<l;k++)
                    {
                        //int x=0,z=0,p1=0;
                        //String s1="",ss;
                        if(s.charAt(k)=='(')
                        {
                            x+=1;
                            if(x==1) {
                                ss = s.substring(j, k);
                                z = Integer.valueOf(ss);
                                p1=k;
                            }
                            }

                        if(s.charAt(k)==')')
                            x-=1;

                        if(x==0)
                        {
                            String sx=s.substring(p1+1,k);
                            for(int q=0;q<z;q++)
                            {
                                s1=s1+sx;
                            }

                            if(k<(l-1))
                                s=s.substring(0,j)+s1+s.substring(k+1);
                            else
                                s=s.substring(0,j)+s1;

                            break;
                        }

                    }

                    j=j-1;
                    */
                   p+=1;
                   op[p][0]=(int)s.charAt(j)-48;
                   op[p][1]=0;
                   op[p][2]=0;


                }
                else if(s.charAt(j)==')') {
                    p -= 1;
                    if(p==-1)
                    {
                        w=w+op[0][0]*op[0][1];
                        h=h+op[0][0]*op[0][2];
                    }
                    else
                    {
                        op[p][1]+=op[p+1][0]*op[p+1][1];
                        op[p][2]+=op[p+1][0]*op[p+1][2];
                        op[p][1]%=M;
                        op[p][2]%=M;
                    }
                }
                else
                {
                    char a=s.charAt(j);

                    if(p==-1) {
                        if (a == 'N') {
                            h -= 1;
//                        if(h<1)
//                            h+=1000000000;
                        } else if (a == 'S') {
                            h += 1;
//                        if(h>1000000000)
//                            h-=1000000000;
                        } else if (a == 'W') {
                            w -= 1;
//                        if(w<1)
//                            w+=1000000000;
                        } else if (a == 'E') {
                            w += 1;
//                        if(w>1000000000)
//                            w-=1000000000;
                        }
                    }
                    else
                    {
                        if (a == 'N')
                            op[p][2]-=1;
                        else if (a == 'S')
                            op[p][2]+=1;
                        if (a == 'W')
                            op[p][1]-=1;
                        if (a == 'E')
                            op[p][1]+=1;
                    }

                }
            }

//            for(int j=0;j<2000;j++)
//            {
//                if(op[j][0]==0)
//                    break;
//
//                w=w+op[j][0]*op[j][1];
//                h=h+op[j][0]*op[j][2];
//            }

            w=w%M;
            h=h%M;
            W=W+w;
            H=H+h;

            while(W<1) {
                if (W < 1)
                    W += 1000000000;
            }
            while(H<1) {
                if (H < 1)
                    H += 1000000000;
            }

            while(W>1000000000) {

                    W -= 1000000000;
            }
            while(H>1000000000) {

                    H -= 1000000000;
            }

            System.out.println("Case #"+(i+1)+": "+W+" "+H);

        }



    }
}