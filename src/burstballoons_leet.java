import java.util.*;
import java.lang.*;
import java.io.*;


/*

    Question :-
    Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
    You are asked to burst all the balloons. If the you burst balloon i you will get nums[left]*nums[i]*nums[right] coins.
    Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

    Find the maximum coins you can collect by bursting the balloons wisely.

    Note:

    You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
    0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
    Example:

    Input: [3,1,5,8]
    Output: 167
    Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
                coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

class burstballoons_leet
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);


        int[] arr={3,1,5,8};

        int ans=maxCoins(arr);
        System.out.println(ans);
    }

    static  int maxCoins(int[] iNums) {

        //Example - iNums[]={3,1,5,8};

        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        //Now, nums[]={1,3,1,5,8,1} ;   n=6

        //dp[i][j] represents maxCoins if all balloons from index i to (j-2) in original iNums
        // OR index (i+1) to (j-1) in nums[] are bursted
        // i.e. i & j is the boundary (exclusive) between which all balloons are bursted in nums[]


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)     //(k-1) represents no. of ballons bursted in that turn; k=2 to 5
        {
            for(int left=0;left<n-k;++left) //left represnts left boundary(adjacent) of last balloon bursted
            {
                int right = left + k;     //right represents right boundary(adjacent) of last balloon bursted
                //All balloons between left and right boundary will be bursted so we know these boundaries for last balloon
                for (int i = left + 1; i < right; ++i)  //i is for selecting last balloon to be bursted in given range of (k-1) balloons(all of which are going to be bursted)
                {
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left]*nums[i]*nums[right] + dp[left][i] + dp[i][right]);

                    //Math.max is for selecting appropriate value of i(last balloon to be bursted) so that maximum maxCoins are earned when bursting all balloons in given range
                    //when selecting i as last balloon so profit = nums[left]*nums[i]*nums[right] + all balloons to the left of i be bursted
                    // i.e. dp[left][i] + all balloons to the right of i be bursted beforehand i.e. dp[i][right]

                    /*

                    Dp[][] for example : iNums[]={3,1,5,8} & nums[]={1,3,1,5,8,1} is

            dp[][]=
                     i/j| 0   1   2   3   4   5   |
                    ____|_________________________|_
                      0 | 0   0   3   30  159 167 |
                      1 | 0   0   0   15  135 159 |
                      2 | 0   0   0   0   40  48  |
                      3 | 0   0   0   0   0   40  |
                      4 | 0   0   0   0   0   0   |
                      5 | 0   0   0   0   0   0   |

                      Here,
                      dp[0][2] means {3} is gonna be bursted , so maxCoins = (left=1) 1*3*1 (right=1) = 3
                      dp[1][3] means {1} is gonna be bursted , so maxCoins=3*1*5 = 15
                      dp[2][4] means {5} is gonna be bursted , so maxCoins=1*5*8 = 40
                      dp[3][5] means {8} is gonna be bursted , so maxCoins=5*8*1 = 40

                      dp[0][3] means {3,1} is gonna be bursted in order 1->3,
                      so maxCoins=(3*1*5) + (1*3*5) = 15(from dp[1][3]) + 15(last balloon) = 30

                      dp[1][4] means {1,5} is gonna be bursted in order 1->5,
                      so maxCoins=(3*1*5) + (3*5*8) = 15(from dp[1][3]) + 120(last balloon) = 135

                      dp[2][5] means {5,8} is gonna be bursted in order 5->8,
                      so maxCoins=(1*5*8) + (1*8*1) = 40(from dp[2][4]) + 8(last balloon) = 48

                      dp[0][4] means {3,1,5} is gonna be bursted in order 1->5->3,
                      so maxCoins=(3*1*5 + 3*5*8) + (1*3*8) = 135(from dp[1][4]) + 24(last balloon = 159

                      dp[1][5] means {1,5,8} is gonna be bursted in order 1->5->8,
                      so maxCoins=(3*1*5 + 2*5*8) + (3*8*1) = 135(from dp[1][4]) + 24(last balloon) = 159

                      dp[0][5] means {3,1,5,8} is gonna be bursted in order 1->5->3->8,
                      so maxCoins=(3*1*5 + 3*5*8 + 1*3*8) + (1*8*1) = 159(from dp[0][4]) + 8(last balloon) = 167

                      */
                }
            }
        }

        return dp[0][n - 1];    //dp[0][5] for original array of length 4 i.e i=0(i) to 3(j-2), all balloons bursted
    }


}
