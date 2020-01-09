import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class BINXOR {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t, n;
        long M=1000000007;
        String a, b;
        t=sc.nextInt();

        long f[]=new long[100001];
        f[0]=1;
        for(int i=1;i<100001;i++)
        {
            f[i]=(f[i-1]*i)%M;
        }
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            a = sc.next();
            b = sc.next();

            int l1 = 0, l2 = 0, max, min;
            for (int j = 0; j < n; j++) {
                if (a.charAt(j) == '1')
                    ++l1;
                if (b.charAt(j) == '1')
                    ++l2;
            }

            if ((l1 + l2) <= n)
                max = l1 + l2;
            else
                max = 2 * n - (l1 + l2);

            if (l1 > l2)
                min = l1 - l2;
            else
                min = l2 - l1;

            long s=0,x;

            /*BigInteger N=fact(n);
            BigInteger p =fact(min);
            BigInteger q=fact(n-min);
            BigInteger z=BigInteger.ZERO;
            for(int j=min;j<=max;j+=2)
            {
                BigInteger r=(N.divide(p.multiply(q)));
                z=z.add(r);
                x=(j+1)*(j+2);
                p = p.multiply(BigInteger.valueOf(x));
                x=(n-j)*(n-j-1);
                if(x>0)
                q = q.divide(BigInteger.valueOf(x));
            }*/

            //BigInteger z=BigInteger.ZERO;
            long d;
            for(int j=min;j<=max;j+=2)
            {
                //BigInteger r=binomial(n,j);
                //z=z.add(r);
                //d=modBinomial(n,j,M);
                d=C(n,j,M,f);
                s=s+d;
            }

            //s=z.mod(BigInteger.valueOf(M)).longValue();
            s=s%M;

            System.out.println(s);

        }
    }

    /*static BigInteger fact(int z) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= z; i++)
            ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }*/

   /* static BigInteger binomial(final int N, final int K) {

        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }*/

    static long modPow(long a, long x, long p) {
        //calculates a^x mod p in logarithmic time.
        long res = 1;
        while(x > 0) {
            if( x % 2 != 0) {
                res = (res * a) % p;
            }
            a = (a * a) % p;
            x /= 2;
        }
        return res;
    }

   static long modInverse(long a, long p) {
        //calculates the modular multiplicative of a mod m.
        //(assuming p is prime).
        return modPow(a, p-2, p);
    }
 /*   static long modBinomial(long n, long k, long p) {
// calculates C(n,k) mod p (assuming p is prime).

        long numerator = 1; // n * (n-1) * ... * (n-k+1)
        for (int i=0; i<k; i++) {
            numerator = (numerator * (n-i) ) % p;
        }

        long denominator = 1; // k!
        for (int i=1; i<=k; i++) {
            denominator = (denominator * i) % p;
        }

        // numerator / denominator mod p.
        return ( numerator* modInverse(denominator,p) ) % p;
    }*/

    static long C(int n, int r, long MOD, long f[])
    {
        return(f[n]*((modInverse(f[r], MOD) * modInverse(f[n-r], MOD)) % MOD)) % MOD;
    }
}