import java.util.*;
import java.lang.*;
import java.io.*;

class UCL
{
    public static void main(String[] args)throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);

        int t;
        t=sc.nextInt();
        String s[]=new String[4];

        for(int i=0;i<t;i++)
        {
            s[2]="";
            s[3]="";
            int g[]=new int[4];
            int d[]=new int[4];
            int p[]=new int[4];
            s[0]=sc.next();
            g[0]=sc.nextInt();
            String x=sc.next();
            g[1]=sc.nextInt();
            s[1]=sc.next();
            if(g[0]>g[1])
            {
                p[0]=p[0]+3;
                d[0]=d[0]+(g[0]-g[1]);
                d[1]=d[1]+(g[1]-g[0]);
            }
            else
            {
                if(g[0]<g[1])
                {
                    p[1]=p[1]+3;
                    d[0]=d[0]+(g[0]-g[1]);
                    d[1]=d[1]+(g[1]-g[0]);
                }
                else
                {
                    p[0]=p[0]+1;
                    p[1]=p[1]+1;
                    d[0]=d[0]+(g[0]-g[1]);
                    d[1]=d[1]+(g[1]-g[0]);
                }
            }
            String s1,s2;
            int p1,p2;
            for(int j=0;j<11;j++)
            {

                s1=sc.next();
                if(!(s1.equals(s[0]))&&!(s1.equals(s[1]))&&(s[2]==""))
                    s[2]=s1;
                else if(!(s1.equals(s[0]))&&!(s1.equals(s[1]))&&!(s1.equals(s[2]))&&(s[3]==""))
                    s[3]=s1;

                if(s1.equals(s[0]))
                {
                    p1=0;
                    g[0]=sc.nextInt();
                    x=sc.next();
                }
                else if(s1.equals(s[1]))
                {
                    p1=1;
                    g[1]=sc.nextInt();
                    x=sc.next();
                }
                else if(s1.equals(s[2]))
                {
                    p1=2;
                    g[2]=sc.nextInt();
                    x=sc.next();
                }
                else
                {
                    p1=3;
                    g[3]=sc.nextInt();
                    x=sc.next();
                }

                int a=sc.nextInt();
                s2=sc.next();

                if(!(s2.equals(s[0]))&&!(s2.equals(s[1]))&&(s[2]==""))
                    s[2]=s2;
                else if(!(s2.equals(s[0]))&&!(s2.equals(s[1]))&&!(s2.equals(s[2]))&&(s[3]==""))
                    s[3]=s2;

                if(s2.equals(s[0]))
                {
                    g[0]=a;
                    p2=0;
                }
                else if(s2.equals(s[1]))
                {
                    g[1]=a;
                    p2=1;
                }
                else if(s2.equals(s[2]))
                {
                    g[2]=a;
                    p2=2;
                }
                else
                {
                    g[3]=a;
                    p2=3;
                }

                if(g[p1]>g[p2])
                {
                    p[p1]=p[p1]+3;
                    d[p1]=d[p1]+(g[p1]-g[p2]);
                    d[p2]=d[p2]+(g[p2]-g[p1]);
                }
                else
                {
                    if(g[p1]<g[p2])
                    {
                        p[p2]=p[p2]+3;
                        d[p1]=d[p1]+(g[p1]-g[p2]);
                        d[p2]=d[p2]+(g[p2]-g[p1]);
                    }
                    else
                    {
                        p[p1]=p[p1]+1;
                        p[p2]=p[p2]+1;
                        d[p1]=d[p1]+(g[p1]-g[p2]);
                        d[p2]=d[p2]+(g[p2]-g[p1]);
                    }
                }
            }
            int q1,q2,q3,q4,r1,r2,r3,r4;
            q1=p[0];
            q2=p[1];
            q3=p[2];
            q4=p[3];
            r1=p[0]+d[0];
            r2=p[1]+d[1];
            r3=p[2]+d[2];
            r4=p[3]+d[3];

            if((q1>q2||(q1==q2&&r1>r2))&&(q1>q3||(q1==q3&&r1>r3))&&(q1>q4||(q1==q4&&r1>r4)))
            {
                System.out.print(s[0]+" ");
                if((q2>q3||(q2==q3&&r2>r3))&&(q2>q4||(q2==q4&&r2>r4)))
                    System.out.print(s[1]);
                else
                {
                    if((q3>q2||(q3==q2&&r3>r2))&&(q3>q4||(q3==q4&&r3>r4)))
                        System.out.print(s[2]);
                    else
                        System.out.print(s[3]);
                }
            }
            else if((q2>q1||(q2==q1&&r2>r1))&&(q2>q3||(q2==q3&&r2>r3))&&(q2>q4||(q2==q4&&r2>r4)))
            {
                System.out.print(s[1]+" ");
                if((q1>q3||(q1==q3&&r1>r3))&&(q1>q4||(q1==q4&&r1>r4)))
                    System.out.print(s[0]);
                else
                {
                    if((q3>q1||(q3==q1&&r3>r1))&&(q3>q4||(q3==q4&&r3>r4)))
                        System.out.print(s[2]);
                    else
                        System.out.print(s[3]);
                }
            }
            else if((q3>q1||(q3==q1&&r3>r1))&&(q3>q2||(q3==q2&&r3>r2))&&(q3>q4||(q3==q4&&r3>r4)))
            {
                System.out.print(s[2]+" ");
                if((q1>q2||(q1==q2&&r1>r2))&&(q1>q4||(q1==q4&&r1>r4)))
                    System.out.print(s[0]);
                else
                {
                    if((q2>q1||(q2==q1&&r2>r1))&&(q2>q4||(q2==q4&&r2>r4)))
                        System.out.print(s[1]);
                    else
                        System.out.print(s[3]);
                }
            }
            else if((q4>q1||(q4==q1&&r4>r1))&&(q4>q2||(q4==q2&&r4>r2))&&(q4>q3||(q4==q3&&r4>r3)))
            {
                System.out.print(s[3]+" ");
                if((q1>q2||(q1==q2&&r1>r2))&&(q1>q3||(q1==q3&&r1>r3)))
                    System.out.print(s[0]);
                else
                {
                    if((q2>q1||(q2==q1&&r2>r1))&&(q2>q3||(q2==q3&&r2>r3)))
                        System.out.print(s[1]);
                    else
                        System.out.print(s[2]);
                }
            }
            if(i<t-1)
                System.out.println();

        }
    }}

