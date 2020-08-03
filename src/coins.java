import java.util.*;
import java.lang.*;
import java.io.*;

class coins
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int m=6;
        int coins[]={1,2,3};


        int a=coinChange(coins,m);
        System.out.println(a);


    }

    static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange1(coins, amount, new int[amount]);
    }

    static int coinChange1(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange1(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
