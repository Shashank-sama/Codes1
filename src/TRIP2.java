import java.util.*;
import java.lang.*;
import java.io.*;

class TRIP2
{
    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t, n, k, x,y;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            x = 0;
            y=0;
            n = sc.nextInt();
            k = sc.nextInt();
            int m[] = new int[n];
            int a[]=new int [n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
                a[j] = m[j];
            }

            if(n>1) {
                if (k > 2) {
                    for (int j = 0; j < n; j++) {
                        if (m[j] == -1) {
                            for (int l = 1; l <= k; l++) {
                                if (j > 0 && j < n - 1) {
                                    if (l != m[j - 1] && l != m[j + 1]) {
                                        m[j] = l;
                                        break;
                                    }
                                } else {
                                    if (j == 0 && l != m[j + 1]) {
                                        m[j] = l;
                                        break;
                                    } else if (j == (n - 1) && l != m[j - 1]) {
                                        m[j] = l;
                                        break;
                                    }
                                }
                            }
                        }
                        if (j > 0)
                            if (m[j] == -1 || m[j] == m[j - 1]) {
                                ++x;
                                break;
                            }

                    }

                    if (x == 0) {
                        System.out.println("YES");
                        for (int j = 0; j < n; j++)
                            System.out.print(m[j] + " ");
                    } else
                        System.out.print("NO");

                    System.out.println();
                } else {
                    for (int j = 0; j < n; j++) {
                        if (m[j] == -1) {

                            if (j > 0 && j < n - 1) {
                                if ((m[j - 1] != 1 && m[j + 1] != 1)||(a[j-1]!=2&&a[j+1]!=2)) {
                                    m[j] = 1;
                                    a[j] = 2;
                                } else if ((m[j - 1] != 2 && m[j + 1] != 2)||(a[j-1]!=1&&a[j+1]!=1)) {
                                    m[j] = 2;
                                    a[j] = 1;
                                }
                            } else {
                                if ((j == 0 && m[j + 1] != 1)||(j == 0 && a[j + 1] != 2)) {
                                    m[j] = 1;
                                    a[j] = 2;
                                } else if ((j == 0 && m[j+1]!=2)||(j == 0 && a[j + 1] != 1)) {
                                    m[j] = 2;
                                    a[j] = 1;
                                } else if ((j == (n - 1) && m[j - 1] != 1)||(j == (n - 1) && a[j - 1] != 2)) {
                                    m[j] = 1;
                                    a[j] = 2;
                                } else if ((j == (n - 1) && m[j - 1] != 2)||(j == (n - 1) && a[j - 1] != 1)) {
                                    m[j] = 2;
                                    a[j] = 1;
                                }
                            }
                        }

                        if (j > 0) {
                            if (m[j] == -1 || m[j] == m[j - 1])
                                ++x;
                            if (a[j] == -1 || a[j] == a[j - 1])
                                ++y;
                        }

                        if (x != 0 && y != 0)
                            break;

                    }

                    if (x != 0 && y != 0)
                        System.out.println("NO");
                    else {
                        System.out.println("YES");
                        for (int j = 0; j < n; j++) {
                            if (x == 0)
                                System.out.print(m[j] + " ");
                            else
                                System.out.print(a[j] + " ");

                        }
                        System.out.println();
                    }
                }
            }
            else
            {
                if(m[0]!=-1)
                {
                    System.out.println("YES");
                    System.out.println(m[0]);
                }
                else
                {
                    System.out.println("YES");
                    System.out.println("1");
                }
            }
        }
    }}