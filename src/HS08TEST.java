import java.util.*;
import java.lang.*;
import java.io.*;

class HS08TEST
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        double a,b,c;

        a=sc.nextDouble();
        b=sc.nextDouble();
        if(a>(b-0.5)||(a%5!=0))
            System.out.printf("%.2f", b);
        else
        {
            c=b-(a+0.5);
            System.out.printf("%.2f", c);
        }
    }
}
