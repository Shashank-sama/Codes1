import java.util.*;
import java.lang.*;
import java.io.*;

//Question - You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
//Example:

//Input: [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.

class countsmallernum_leet
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int[] nums={5,4,-1,0,0,11,-3,2,5,3,1};
        List<Integer> lt=countSmaller(nums);
        System.out.println(lt);


    }

    static List<Integer> countSmaller(int[] nums) {

        int n=nums.length;
        if(n==0)
            return new ArrayList<>();

        //________________________________________________________________________________________________________
        /*

        //METHOD - 1 (around 190ms), slower than mergesort but faster than O(n^2){O(n^2) - around 660ms}



        int[] arr=new int[n];       //to store nums[] from n-1 to 0 in sorted(ascending) manner
        int[] count=new int[n];     //to store count of smaller numbers
        List<Integer> lt=new ArrayList<>();     //to return answer in list form

        Arrays.fill(arr,Integer.MAX_VALUE);     //filling arr[]

        for(int i=n-1;i>=0;--i)
        {
            int idx=Arrays.binarySearch(arr,0,n-i-1,nums[i]);       //gives (expected)index of nums[i] in arr[] between index 0 & n-i-1 (both inclusive)
            if(idx<0)           //if nums[i] is not present then returns idx=-(expected index + 1)
                idx=-(idx+1);
            while(idx>0&&arr[idx-1]==nums[i])       //finding lowest index of nums[i] in arr[]
                --idx;

            count[i]=idx;               //storing count of smaller numbers of nums[i] in count[i]
            for(int j=Arrays.binarySearch(arr,0,n-1,Integer.MAX_VALUE); j>idx&&j<n; --j)
            {
                if(arr[j-1]!=Integer.MAX_VALUE)
                    arr[j]=arr[j-1];                //shifting all elements of arr[] to right from idx
            }
            arr[idx]=nums[i];           //inputting arr[idx] = nums[i]

        }

        for(int i=0;i<n;i++)
            lt.add(count[i]);

            return lt;


         */

//____________________________________________________________________________________________________________



        //METHOD - 2 , Using modified mergesort


        int[][] sorted=new int[3][n];
        //sorted[0][i] has nums[i], sorted[1][i] will have count of smaller nos., sorted[2][i] has original index
        for(int i=0;i<n;i++) {
            sorted[0][i]=nums[i];
            sorted[2][i]=i;             //storing original index
        }

        sorted=mrgsort(sorted,0,n-1);       //finding count by sorting & noticing how much RIGHT shift occurs for any given nums[i]

        int count[]=new int[n];
        for(int i=0;i<n;i++)
        {
            count[sorted[2][i]]=sorted[1][i];       //storing count using at original indices
        }

        List<Integer> lt=new ArrayList<>();

        for(int i=0;i<n;i++)
            lt.add(count[i]);

        return lt;

    }

    static int[][] mrgsort(int arr[][], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            mrgsort(arr, l, m);
            mrgsort(arr , m+1, r);

            merge(arr, l, m, r);
        }

        return arr;
    }

    static int[][] merge(int arr[][], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[][] = new int [3][n1];
        int R[][] = new int [3][n2];

        for (int i=0; i<n1; ++i) {
            L[0][i] = arr[0][l + i];
            L[1][i] = arr[1][l + i];
            L[2][i] = arr[2][l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[0][j] = arr[0][m + 1 + j];
            R[1][j] = arr[1][m + 1 + j];
            R[2][j] = arr[2][m + 1 + j];
        }


        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[0][i] <= R[0][j])
            {
                arr[0][k] = L[0][i];
                arr[2][k] = L[2][i];
                arr[1][k]=L[1][i]+Math.max(0, k-(l+i));     //updating count by calculating how much distance shifted to right
                i++;
            }
            else
            {
                arr[0][k] = R[0][j];
                arr[2][k] = R[2][j];
                arr[1][k]=R[1][j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[0][k] = L[0][i];
            arr[2][k] = L[2][i];
            arr[1][k]=L[1][i]+Math.max(0, k-(l+i));
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[0][k] = R[0][j];
            arr[2][k] = R[2][j];
            arr[1][k]=R[1][j];
            j++;
            k++;
        }

        return arr;
    }

    //________________________________________________________________________________________________________________
}
//around 15ms