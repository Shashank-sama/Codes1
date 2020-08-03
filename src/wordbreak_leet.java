import java.util.*;
import java.lang.*;
import java.io.*;

class wordbreak_leet
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        String s="abcabcabc";


        List<String> wD=new ArrayList<>();
        wD.add("abc");
        wD.add("abcabc");
        wD.add("abcabcabc");

        List<String> ans=new ArrayList<>();

         ans=wordBreak(s,wD);
        System.out.println(ans);
    }

    static List<String> wordBreak(String s, List<String> wordDict) {

        int l=s.length();
        boolean[] dp=new boolean[l+1];
        dp[0]=true;

        List<String> ans[]=new ArrayList[l+1];
        for (int i = 0; i < l+1; ++i)
            ans[i] = new ArrayList();

        for(int i=1;i<=l;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j]==true && wordDict.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    if(j==0)
                    ans[i].add(s.substring(j,i));
                    else {
                        Iterator<String> x = ans[j].listIterator();
                        while (x.hasNext()) {
                            String ss = x.next();
                            ans[i].add(ss + " " + s.substring(j, i));
                        }
                    }
                }
            }
        }

        return ans[l];

    }


}
