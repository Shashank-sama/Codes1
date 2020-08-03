import java.util.*;
import java.lang.*;
import java.io.*;

class maxproduct_array
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int[] nums={2,3,-2,4};

        int ans1=maxProduct(nums);
        int ans2=easymaxProduct(nums);

        System.out.println("Maximum contiguous subarray product is "+ans1);

    }

    //__________________________________________________________________________________________________

    //METHOD - 2 , Easy solution in O(n)

    static int easymaxProduct(int[] nums) {

    int n=nums.length;
    if(n==0)
        return 0;
    if(n==1)
        return nums[0];

    int max=Integer.MIN_VALUE;

    int p1=1,p2=1;

    for(int i=0;i<n;i++)
    {
        p1=p1*nums[i];
        if(p1>max)
            max=p1;
        if(p1==0)
            p1=1;

        p2=p2*nums[n-1-i];
        if(p2>max)
            max=p2;
        if(p2==0)
            p2=1;
    }

    return max;

}

//____________________________________________________________________________________________________


    //METHOD - 1 ; Recursive solution using partition for 0 values

    static int maxProduct(int[] nums) {

        return partition(nums,0,nums.length-1);

    }

    static int partition(int[] arr, int low,int high) {

        if(low>high)
            return 0;

        int l=0,r=0,p=0;
        for(int i=low;i<=high;i++)
        {
            if(arr[i]==0)
            {
                l=partition(arr,low,i-1);
                r=partition(arr,i+1,high);
                r=Math.max(0,r);

                return Math.max(l,r);
            }
        }

        p=maxprod(arr,low,high);

        return p;

    }

    static int maxprod(int[] arr, int low, int high) {

        if(low>high)
            return 0;

        int left_i=-1,right_i=-1,cn=0;
        int p=1,p1=1,p2=1;

        for(int i=low;i<=high;i++)
        {
            if(arr[i]<0&&cn==0)
            {
                ++cn;
                left_i=i;
                right_i=i;
            }
            else if(arr[i]<0)
            {
                ++cn;
                right_i=i;
            }

            p=p*arr[i];
        }

        if(cn>0&&(cn%2==1))
        {
            for(int i=low;i<right_i;i++)
                p1=p1*arr[i];

            if(low==right_i)
                p1=arr[low];

            for(int i=left_i+1;i<=high;i++)
                p2=p2*arr[i];

            if(left_i==high)
                p2=arr[high];
        }
        else
        {
            return p;
        }

        return Math.max(p1,p2);

    }
}
