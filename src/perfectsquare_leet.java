import java.util.*;
import java.lang.*;
import java.io.*;

class perfectsquare_leet
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);



        int n=13;
        int ans=numSquares(n);        /*Example 1:
                                        Input: n = 12, Output: 3 , Explanation: 12 = 4 + 4 + 4.
                                        Example 2:
                                        Input: n = 13, Output: 2, Explanation: 13 = 4 + 9.
                                       */

        System.out.println(ans);        //ans=minimum no. of perfect squares added to get sum = n

    }

    static int numSquares(int n) {

        if(n==0)
            return 0;

        int m=(int)Math.sqrt(n);

        int[] div=new int[m];
        for(int i=0;i<m;i++)
            div[i]=(i+1)*(i+1);

        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<n+1;i++)
            dp[i]=i;

        for(int i=1;i<=m;i++)
            dp[i*i]=1;

        for(int i=1;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if((i+div[j])<=n)
                dp[i+div[j]]=Math.min(dp[i+div[j]],dp[i]+1);
            }

        return dp[n];


    }


}
