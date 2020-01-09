import java.util.*;
import java.lang.*;
import java.io.*;

class DESTCELL
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t,n,m;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            m=sc.nextInt();
            int z[][]=new int[n][m];
            int p,a,b;
            System.out.print(n*m + " ");
            for(int k=1;k<(n*m);k++)
            {
                int x=0;
                for(p=0;p<(n*m);p+=(k+1))
                {
                    a=p/m;
                    b=p%m;
                    if(z[a][b]!=k+1)
                    {
                        z[a][b]=k+1;
                        ++x;
                    }
                    a=p%n;
                    b=p/n;
                    if(z[a][b]!=k+1)
                    {
                        z[a][b]=k+1;
                        ++x;
                    }
                }


                /*for(int j=0;j<n;j++)
                    for(int l=0;l<m;l++)
                    {
                        if(z[j][l]==k+1)
                            ++x;
                    }*/

                System.out.print(x+" ");

            }
            System.out.println();
        }
    }}