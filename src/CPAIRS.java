import java.util.*;
import java.lang.*;
import java.io.*;

class CPAIRS
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t, n, e, o;
        t = sc.nextInt();
        //System.out.println("t="+t);                         //t
        for (int i = 0; i < t; i++) {
            e = 0;
            o = 0;
            n = sc.nextInt();
            //System.out.println("n="+n);                     //n
            int m[] = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
                if (m[j] % 2 == 0)
                    ++e;
                else
                    ++o;
               // System.out.print("m["+j+"]="+m[j]+" ");           //m[j]
            }
            //System.out.println("e="+e+" & o="+o);                   //e,o
            int a[] = new int[e];
            int b[] = new int[o];
            int k = 0, l = 0;
            for (int j = 0; j < n; j++) {
                if (m[j] % 2 == 0) {
                    a[k] = j;
                   // System.out.println("a["+k+"]="+a[k]+" ");           //a[k]
                    k++;
                } else {
                    b[l] = j;
                   // System.out.println("b["+l+"]="+b[l]+" ");               //b[l]
                    l++;
                }
            }

            int s = 0;
            for (int j = 0; j < e; j++) {
                for (int r = 0; r < o; r++) {
                    if (a[j] < b[r]) {
                        int z;
                        z= o-r;
                       // System.out.println("s="+s+" + ("+o+"-"+r+")="+(z));         //s=s+(e-r)
                        s = s + (o - r);

                        break;
                    }

                }
            }

            System.out.println(s);

        }
    }}