import java.util.*;
import java.lang.*;
import java.io.*;

class DSTAPLS
{
    public static void main(String[] args)throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);

        int t;
        long n,k;
        t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            n=sc.nextLong();
            k=sc.nextLong();
            long a=n/k;

            if(a%k==0)
                System.out.println("NO");
            else
                System.out.println("YES");



        }
    }}