import java.util.*;
import java.lang.*;
import java.io.*;

class TLG
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int n,c;
        n=sc.nextInt();
        int a[][]=new int[n][2];
        int b[][]=new int[n][2];
        a[0][0]=sc.nextInt();
        a[0][1]=sc.nextInt();
        if(a[0][0]>=a[0][1])
        {
            b[0][0]=a[0][0]-a[0][1];
            b[0][1]=1;
            c=0;
        }
        else{
            b[0][0]=a[0][1]-a[0][0];
            b[0][1]=2;
            c=0;
        }
        for(int i=1;i<n;i++)
        {
            a[i][0]=a[i-1][0]+sc.nextInt();
            a[i][1]=a[i-1][1]+sc.nextInt();

            if(a[i][0]>=a[i][1])
            {
                b[i][0]=a[i][0]-a[i][1];
                b[i][1]=1;
            }
            else{
                b[i][0]=a[i][1]-a[i][0];
                b[i][1]=2;
            }

            if(b[i][0]>b[c][0])
                c=i;
        }

        System.out.println(b[c][1]+" "+b[c][0]);

    }
}