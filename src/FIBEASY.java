import java.util.*;
import java.lang.*;
import java.io.*;

class FIBEASY
{
    public static void main(String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t;
        long n;
        t = sc.nextInt();
        int g[]=new int[60];
        g[0]=0;
        g[1]=1;
        for(int i=2;i<60;i++)
            g[i]=(g[i-1]+g[i-2])%10;
        for (int i = 0; i < t; i++)
        {
            n=sc.nextLong();
            int z=0;
            long p,x;
            for(int j=0;j<61;j++)
            {
                p=n/(long)(Math.pow(2,j));
                if(p==1)
                {
                    z=j;
                    break;
                }
            }
            x=(long)Math.pow(2,z);

            long y=(x-1)%60;
            int a=(int)y;
            System.out.println(g[a]);
        }
    }}