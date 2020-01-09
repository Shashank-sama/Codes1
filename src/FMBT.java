import java.util.*;
import java.lang.*;
import java.io.*;

class FMBT
{
    public static void main(String[] args)throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);

        int t,n,c=0,d=0;
        String a,b="",s="";
        t=sc.nextInt();
        for(int j=0;j<t;j++)
        {
            c=0;
            d=0;
            n=sc.nextInt();
            if(n==0)
                System.out.println("Draw");
            else
            {
                a=sc.next();
                ++c;
                for(int i=0;i<n-1;i++)
                {
                    s=sc.next();
                    if(s.equals(a))
                        ++c;
                    else
                    {
                        b=s;
                        ++d;
                    }
                }
                if(c>d)
                    System.out.println(a);
                else
                {
                    if(c<d)
                        System.out.println(b);
                    else
                    if(c==d)
                        System.out.println("Draw");
                }
            }
        }
    }}