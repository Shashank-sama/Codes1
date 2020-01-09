import java.util.*;
import java.lang.*;
import java.io.*;

class SALARY
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t, n, x,y,z,c;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            if(n>1)
            {
                x = 0;
                y=10001;
                z=-1;
                c=0;
                int m[] = new int[n];
                for (int j = 0; j < n; j++) {
                    m[j] = sc.nextInt();
                    if(m[j]<y)
                        y=m[j];
                }
                for(int j=0;j<n;j++)
                    c=c+(m[j]-y);
                System.out.println(c);
            }
            else
            {
                x=sc.nextInt();
                System.out.println("0");
            }
        }
    }}