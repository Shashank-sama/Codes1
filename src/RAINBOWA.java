import java.util.*;
import java.lang.*;
import java.io.*;

class RAINBOWA
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);


        int t,n,x;
        t = sc.nextInt();
        for (int i = 0; i < t; i++)
        {
            x=0;
            n=sc.nextInt();
            int m[]=new int[n];
            for(int j=0;j<n;j++)
                m[j]=sc.nextInt();

            int a[]=new int[7];

            for(int j=0;j<n;j++)
            {
                if(m[j]==1)
                    a[0]++;
                else if(m[j]==2)
                    a[1]++;
                else if(m[j]==3)
                    a[2]++;
                else if(m[j]==4)
                    a[3]++;
                else if(m[j]==5)
                    a[4]++;
                else if(m[j]==6)
                    a[5]++;
                else if(m[j]==7)
                    a[6]++;
                else
                {
                    x++;
                    break;
                }

            }

            int y=0;

            if((a[0]==0||a[1]==0||a[2]==0||a[3]==0||a[4]==0||a[5]==0||a[6]==0)||(a[0]%2==1||a[1]%2==1||a[2]%2==1||a[3]%2==1||a[4]%2==1||a[5]%2==1))
                x=1;
            else
            {
                for(int j=0;j<6;j++)
                {

                    if(j>0)
                        y=y+(a[j-1]/2);
                    for(int k=y;k<(y+a[j]/2);k++) {
                        if (!(m[k] == (j + 1) && m[n - 1 - k] == (j + 1)))
                            x++;
                    }
                }
                }

            if(x==0)
                System.out.println("yes");
            else
                System.out.println("no");
            }

        }

    }