
import java.io.*;
import java.util.*;


public class LONGCOOK {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t,m1,m2;
        long y1,y2;
        t=sc.nextInt();
        int arr[]=new int[400];
        Map<Integer,Integer> mp=new HashMap<>();
        arr[0]=0;
        mp.put(0,0);
        int p,q;
        for(int i=1;i<400;i++)
        {
            arr[i]=arr[i-1];
            p=leap(i);
            q=feb(i);
            if(q==6||(p==0&&q==0))
            {
                arr[i]+=1;
                mp.put(i,1);
            }
            else
                mp.put(i,0);
        }
        for(int i=0;i<t;i++)
        {
            m1=sc.nextInt();
            y1=sc.nextLong();
            m2=sc.nextInt();
            y2=sc.nextLong();

            if(m1<3) {
                y1-=1; m1=12;
            }
            if(m2<2) {
                y2-=1; m2=12;
            }

            long c=0,a;
            //int m[]={3, 9, 14, 15, 20, 25, 26, 31, 37, 42, 43, 48, 53, 54, 59, 65, 70, 71, 76, 81, 82, 87, 93, 98, 99, 105, 110, 111, 116, 121, 122, 127, 133, 138, 139, 144, 149, 150, 155, 161, 166, 167, 172, 177, 178, 183, 189, 194, 195, 200, 201, 206, 207, 212, 217, 218, 223, 229, 234, 235, 240, 245, 246, 251, 257, 262, 263, 268, 273, 274, 279, 285, 290, 291, 296, 302, 303, 308, 313, 314, 319, 325, 330, 331, 336, 341, 342, 347, 353, 358, 359, 364, 369, 370, 375, 381, 386, 387, 392, 397, 398};
            if(y2-y1>=400)
            {
                a=(y2-y1)/400;
                c=c+a*101;
                y1=y1+a*400;
            }



            if(y1<y2)
            {
                y1=y1%400;
                y2=y2%400;
                if(y1<=y2)
                    c+=arr[(int)y2]-arr[(int)y1];
                else
                    c+=arr[(int)y2]+(101-arr[(int)y1]);
            }

            /*long c=0,a;
            int m[]={3, 9, 14, 15, 20, 25, 26, 31, 37, 42, 43, 48, 53, 54, 59, 65, 70, 71, 76, 81, 82, 87, 93, 98, 99, 105, 110, 111, 116, 121, 122, 127, 133, 138, 139, 144, 149, 150, 155, 161, 166, 167, 172, 177, 178, 183, 189, 194, 195, 200, 201, 206, 207, 212, 217, 218, 223, 229, 234, 235, 240, 245, 246, 251, 257, 262, 263, 268, 273, 274, 279, 285, 290, 291, 296, 302, 303, 308, 313, 314, 319, 325, 330, 331, 336, 341, 342, 347, 353, 358, 359, 364, 369, 370, 375, 381, 386, 387, 392, 397, 398};
            if((y2-y1)>=400)
            {
                a=(y2-y1)/400;
                c=c+a*101;
                y1=y1+a*400;
            }
            if(m1>2)
                y1=y1+1;
            if(m2<2)
                y2-=1;

            a=y2-y1;
            y1=y1%400;
            y2=(y1+a)%400;
            for(int j=0;j<101;j++)
            {
                if(y1<=y2) {
                    if (m[j] >= y1 && m[j] <= y2)
                        ++c;
                }
                else
                {
                    if(m[j]<=y2||m[j]>=y1)
                        ++c;
                }
//                if(m[j]>y2)
//                    break;
            }
            /*int p,q;
            while(y1<=y2)
            {
                if(y1<y2)
                {
                    if(m1<3)
                    {
                        q=leap(y1);
                        p=feb(y1);
                        if(q==1&&p==6) {
                            ++c;
                            //out.print(y1+" ");
                        }
                        if(q==0&&(p==0||p==6)) {
                            ++c;
                            //out.print(y1+" ");
                        }
                    }
                }
                else
                {
                    if(m1<=m2)
                        if(m1<3&&m2>1)
                        {
                            q=leap(y1);
                            p=feb(y1);
                            if(q==1&&p==6) {
                                ++c;
                                //out.print(y1+" ");
                                 }
                            if(q==0&&(p==0||p==6))  {   // p=0 represents sunday
                                ++c;
                                //out.print(y1+" ");
                                }
                        }
                }
                ++y1;
                m1=1;
            }*/

            //out.println();
            out.println(c);
            out.flush();
        }
        out.flush();
        out.close();
    }
//3 9 14 15 20 25 26 31 37 42 43 48 53 54 59 65 70 71 76 81 82 87 93 98 99 105 110 111 116 121 122 127 133 138 139 144 149 150 155 161 166 167 172 177 178 183 189 194 195 200 201 206 207 212 217 218 223 229 234 235 240 245 246 251 257 262 263 268 273 274 279 285 290 291 296 302 303 308 313 314 319 325 330 331 336 341 342 347 353 358 359 364 369 370 375 381 386 387 392 397 398
    static int leap(long y)
    {
        int f=0;
        if((y%4==0&&y%100!=0)||(y%400==0))
            f=1;
        return f;
    }

   static int feb(long y)
    {
        int x=2;
        long a,b,c;
        a=y/400;
        y=y%400;
        if(y>100&&y!=200&&y!=300)
            x=(x-1+7)%7;
        b=y/100;
        if(b>0)
            x=(x+6+((int)(b-1)*5)%7)%7;
        y=y%100;
        c=y/4;
        x=(x+((int)c*5)%7)%7;
        y=y%4;
        if(y>0)
            x=(x+2+(int)y-1 )%7;

        return x;
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