import java.util.*;
import java.lang.*;
import java.io.*;

class gfg1ruling {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = sc.nextInt();
            System.out.println(RulingPair(array, n));

            t--;
        }


    }

    static int RulingPair(int arr[], int n) {

        int a[][] = new int[82][2];
        for (int i = 0; i < 82; i++) {
            a[i][0] = -1;
            a[i][1] = -1;
        }

        int k;
        for (int i = 0; i < n; i++) {
            k = sumd(arr[i]);

            if (a[k][0] == -1)
                a[k][0] = arr[i];
            else if (a[k][1] == -1)
                a[k][1] = arr[i];
            else {
                if (arr[i] > Math.min(a[k][0], a[k][1])) {
                    if (a[k][0] < a[k][1])
                        a[k][0] = arr[i];
                    else
                        a[k][1] = arr[i];
                }
            }

        }

        long max = -1, ss = -2;
        for (int i = 0; i < 82; i++) {
            if (a[i][0] != -1 && a[i][1] != -1)
                if(ss<(a[i][0]+a[i][1]))
                ss = a[i][0] + a[i][1];
        }

        if (max < ss)
            max = ss;

        return (int) max;

    }

    public static int sumd(int n) {
        int s = 0;
        while (n > 0) {
            s = s + n % 10;
            n = n / 10;
        }

        return s;
    }

}