import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Leet1 {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {

        int l=s.length();
        char c;
        int f=0,l1,j,flag=0;
        long z;
        String s1,s2;

        for(int i=1;i<l/2+1;i++)
        {
            f=0;
            s1=s.substring(0,i);
            z=Long.valueOf(s1);
            j=i;
            if(s1.charAt(0)!='0')
                while(f==0&&j<l)
                {
                    z+=1l;
                    s2=String.valueOf(z);
                    l1=s2.length();
                    if((j+l1)<=l)
                    {
                        if((s.substring(j,j+l1)).equals(s2))
                            j=j+l1;
                        else
                            f=1;
                    }
                    else
                    {
                        f=1;
                    }

                }
            else
                f=1;

            if(f==0)
            {
                System.out.println("YES "+s1);
                flag=1;
                break;
            }

        }

        if(flag==0)
            System.out.println("NO");


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
