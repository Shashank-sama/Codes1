import java.util.*;
import java.lang.*;
import java.io.*;

class AND
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int n;
        long s=0;
        n=sc.nextInt();
        long m[]=new long[n];

        for(int i=0;i<n;i++)
            m[i]=sc.nextInt();



        for(int i=0;i<n-1;i++)
        {
            if(m[i]!=0)
            {
                for(int j=i+1;j<n;j++)
                {
                    s=s+(m[i]&m[j]);
                }

            }
        }
        System.out.println(s);


    }
}
