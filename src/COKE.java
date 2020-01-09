import java.util.*;
import java.lang.*;
import java.io.*;

class COKE
{
    public static void main(String[] args)throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);

        int t,n,m,k,l,r,q;
        t=sc.nextInt();
        int x[]=new int[t];
        for(int i=0;i<t;i++)
        {
            int y=1000001;
            int z=-1;
            n=sc.nextInt();
            m=sc.nextInt();
            k=sc.nextInt();
            l=sc.nextInt();
            r=sc.nextInt();
            int c[]=new int[n];
            int p[]=new int[n];
            for(int j=0;j<n;j++)
            {
                c[j]=sc.nextInt();
                p[j]=sc.nextInt();
            }

            for(int j=0;j<n;j++)
            {
                if(c[j]<k)
                {
                    if((k-c[j])>m)
                        c[j]=c[j]+m;
                    else
                        c[j]=k;
                }
                else
                {
                    if(c[j]>k)
                    {
                        if((c[j]-k)>m)
                            c[j]=c[j]-m;
                        else
                            c[j]=k;
                    }
                }
                if(c[j]>=l&&c[j]<=r)
                {
                    if(p[j]<y)
                        y=p[j];
                }}
            if(y!=1000001)
                z=y;
            x[i]=z;
        }
        for(int i=0;i<t;i++)
            System.out.println(x[i]);
    }}