import java.util.*;
import java.lang.*;
import java.io.*;

class PROXYC
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t, l, a;
        String s;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int c = 0, d = 0, z = 0;
            l = sc.nextInt();
            a = (int) (l/4);
            s = sc.next();
            for (int j = 0; j < l; j++) {
                if (s.charAt(j) == 'P')
                    ++c;
                else
                    ++d;
            }

            //System.out.println("l="+l+" , a="+a+" , s="+s+" , c="+c+" , d="+d);    //l,a,s,c,d

            if (d > a) {
                for (int j = 2; j < l - 2; j++) {
                    if (s.charAt(j) == 'A') {
                        if (((s.charAt(j - 2) == 'P') || (s.charAt(j - 1) == 'P')) && ((s.charAt(j + 1) == 'P') || (s.charAt(j + 2) == 'P'))) {
                            c = c + 1;
                            d = d - 1;
                            ++z;

                            //System.out.println("c="+c+" , d="+d+" , z="+z);         //c,d,z
                        }
                    }
                    if (d <= a) {
                        System.out.println(z);
                        break;
                    }

                }
                if (d > a)
                    System.out.println("-1");
            } else
                System.out.println("0");
        }
    }}