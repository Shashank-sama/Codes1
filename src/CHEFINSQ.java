import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class CHEFINSQ
{
 static BigInteger fact(int z)
    {
        BigInteger ret = BigInteger.ONE;
        for(int i=1;i<=z;i++)
            ret=ret.multiply(BigInteger.valueOf(i));
        return ret;
        }


    public static void main(String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t, n, k ;
        long c;
        t = sc.nextInt();
        for (int i = 0; i < t; i++)
        {
            c=0;
            n=sc.nextInt();
            k=sc.nextInt();
            int m[]=new int[n];
            for(int j=0;j<n;j++)
                m[j]=sc.nextInt();
            Arrays.sort(m);

            int x,a=0,b=0;
            x=m[k-1];
            for(int j=0;j<n;j++)
            {
                if(m[j]==x)
                {
                   ++a;
                   if(j<k)
                       ++b;
                }
            }
            BigInteger A = fact(a);
            BigInteger B = fact(b);
            BigInteger C = fact(a-b);
            c=(A.divide(B.multiply(C))).longValue();
            System.out.println(c);
        }
    }}