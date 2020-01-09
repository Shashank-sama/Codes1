import java.util.*;
import java.lang.*;
import java.io.*;

class EID2
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t,z;
        int a[] = new int[3];
        int c[] = new int[3];
        t = sc.nextInt();
        for (int i = 0; i < t; i++)
        {
            z=0;
            for(int j=0;j<3;j++)
                a[j]=sc.nextInt();
            for(int j=0;j<3;j++)
                c[j]=sc.nextInt();

            for(int j=0;j<2;j++)
            {
                for(int k=j+1;k<3;k++)
                {
                    if(!((a[j]<a[k]&&c[j]<c[k])||(a[j]>a[k]&&c[j]>c[k])||(a[j]==a[k]&&c[j]==c[k])))
                     ++z;
                }
            }

            if(z==0)
                System.out.println("FAIR");
            else
                System.out.println("NOT FAIR");
        }
    }}