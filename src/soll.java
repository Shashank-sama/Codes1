import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Question - You are given a string consisting of lowercase english alphabets(a-z),
// in which you are allowed to change at most k consonants into a vowel(a,e,i,o,u).
// Find the longest substring that consists of only vowels after changing at most k consonants into vowels.


public class soll {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();

        String s=sc.next();

        int max=0,curr=0,cc=0;

        Queue<Integer> q = new LinkedList<>();

        char c;
        for(int i=0;i<n;i++)
        {
            c=s.charAt(i);

            if(c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u')
            {
                q.add(i);

                if(cc<k)
                {
                    ++cc;
                    ++curr;

                    if(max<curr)
                        max=curr;
                }
                else
                {
                    int x=q.remove();
                    curr=i-x;

                    if(max<curr)
                        max=curr;
                }
            }
            else
            {
                ++curr;

                if(max<curr)
                    max=curr;
            }
        }

        System.out.println(max);

    }
}