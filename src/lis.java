import java.util.*;
import java.lang.*;
import java.io.*;

class lis
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);


        int nums[]={10,9,2,5,3,7,101,18};


        int a=lengthOfLIS(nums);
        System.out.println(a);


    }

    static int lengthOfLIS(int[] nums) {

/*
        //METHOD - 1 , Time Complexity O(n^2)

        int n=nums.length;
        if(n==0)
            return 0;
        int dp[]=new int[n];
        Arrays.fill(dp,1);

        int max=1;
        for(int i=n-2;i>-1;--i)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[j]>nums[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }

            if(max<dp[i])
                max=dp[i];
        }

        return max;
 */


//___________________________________________________________________________________________________________
/*
        //METHOD - 2 , Really time taking


        int n=nums.length;

        if(n==0)
            return 0;

        TreeMap<Integer,Integer> mp=new TreeMap<>();
        mp.put(nums[n-1],1);

        int max=1;
        for(int i=n-2;i>-1;--i)
        {
            mp.put(nums[i],1);

            int key=nums[i];
            while(key!=mp.lastKey())
            {
                key=mp.higherKey(key);
                int val=mp.get(key);
                mp.put(nums[i],Math.max(mp.get(nums[i]),val+1));
            }

            if(max<mp.get(nums[i]))
                max=mp.get(nums[i]);
        }

        return max;


         */
//______________________________________________________________________________________________________________

        //METHOD - 3, Time Complexity - O(nlogn)

        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);   //if element is not present in dp[], it returns
            if (i < 0) {                                    //i as [i= -(insertion point of num in dp) - 1]
                i = -(i + 1);                                // Therefore, insertion point = -(i+1)
            }
            dp[i] = num;                                    //Consider the example:
                                                            //input: [0, 8, 4, 12, 2]
            if (i == len) {                                 //dp: [0], len=1
                len++;                                      //dp: [0, 8], len=2
            }                                               //dp: [0, 4], len=2
        }                                                   //dp: [0, 4, 12], len=3
        return len;                                         //dp: [0 , 2, 12], len=3
                                                            //return 3;


    }
}
