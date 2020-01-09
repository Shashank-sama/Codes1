import java.util.*;
import java.lang.*;
import java.io.*;

class KS2
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t,j;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            long n;
            n=sc.nextLong();

            long a,b;

            a=n;
            b=n;



            long s=0;
            while(b>0)
            {
                s=s + b%10;
                b=b/10;

            }


            for( j=0;j<10;j++)
            {
                s=s+j;
                if(s%10==0)
                    break;
                else
                    s=s-j;
            }



            System.out.println(n+""+j);


        }
    }}