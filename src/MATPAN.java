import java.util.*;
import java.lang.*;
import java.io.*;

class MATPAN
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++)
        {
            int s1 = 0;
            int c = 0;
            int a[] = new int[26];
            for (int j = 0; j < 26; j++)
                a[j] = sc.nextInt();

            String s = sc.next();
            int l = s.length();

            for (int j = 97; j < 123; j++)
            {
                c = 0;
                for (int k = 0; k < l; k++)
                {
                    if (((char) j) == s.charAt(k))
                    {
                        c = 1;
                        break;
                    }
                }
                if (c == 0)
                    s1 = s1 + a[j - 97];
            }
            System.out.println(s1);
        }
    }}