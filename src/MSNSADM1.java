import java.util.*;
import java.lang.*;
import java.io.*;

class MSNSADM1
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t,n;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            int g[]=new int[n];
            int f[]=new int[n];
            int p[]=new int[n];

            for(int j=0;j<n;j++)
                g[j]=sc.nextInt();

            for(int j=0;j<n;j++)
                f[j]=sc.nextInt();

            int p1,c=0;
            for(int j=0;j<n;j++)
            {
                p1=g[j]*20 - f[j]*10;

                if(p1>=0)
                    p[j]=p1;
                else
                    p[j]=0;

                if(p[j]>c)
                    c=p[j];
            }

            System.out.println(c);
        }
    }}