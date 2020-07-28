import java.io.*;
import java.util.*;

public class hash20 {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int B, L, D;
        B=sc.nextInt();   //no. of books
        L=sc.nextInt();    //no. of libraries
        D=sc.nextInt();     //no. of days

        Map<Integer,Integer> boo=new HashMap<>();
        for(int i=0;i<B;i++)
        {
            boo.put(i,1);
        }
        int books_val[]=new int[B];    //store value of book[i] in array
        for(int i=0;i<B;i++)
            books_val[i]=sc.nextInt();

        int lib_dat[][]=new int[L][3];     //store no. of books, signup days, max capacity of library
        int lib_boo[][]=new int[L][B+1];     // store books in library[i]

        //TreeMap<Integer, Integer> mp=new TreeMap<>(Collections.reverseOrder());
        int sum[][]=new int[2][L];
        int s=0;
        for(int i=0;i<L;i++)
        {
            s=0;
            lib_dat[i][0]=sc.nextInt();     //total no. of books in lib[i]
            lib_dat[i][1]=sc.nextInt();    //signup days of lib[i]
            lib_dat[i][2]=sc.nextInt();     //max capacity of lib[i]
            for(int j=0;j<=lib_dat[i][0];j++)
            {
                if(j==lib_dat[i][0]) {
                    lib_boo[i][j] = -1;
                    sum[0][i]=s;
                    sum[1][i]=i;
                    break;
                }
                lib_boo[i][j]=sc.nextInt();   //books in lib[i]
                s=s+books_val[lib_boo[i][j]];
            }
        }

        sum=sort(sum,0,L-1);

        out.println(L);
        int a,d=D,coun=0;

        //for (Map.Entry<Integer,Integer>  entry : mp.entrySet())
        //while(!mp.isEmpty())
        for(int i=L-1;i>-1;--i)
        {
            a=sum[1][i];
            out.print(a+" ");
            if(((d-lib_dat[a][1])*lib_dat[a][2])<lib_dat[a][0])
            {
                for(int j=0;j<lib_dat[a][0];j++) {
                    if (boo.containsKey(lib_boo[a][j]))
                        ++coun;
                }
                    out.print(coun);
                if(coun!=0)
                    out.println();
                for(int j=0;j<lib_dat[a][0];j++)
                {
                    if(boo.containsKey(lib_boo[a][j])) {
                        out.print(lib_boo[a][j] + " ");
                        boo.remove(lib_boo[a][j]);
                    }
                }
                out.println();
            }
            else
            {
                out.print(lib_dat[a][0]);
                out.println();
                for(int j=0;j<lib_dat[a][0];j++) {
                    out.print(lib_boo[a][j] + " ");
                    boo.remove(lib_boo[a][j]);
                }
                out.println();
            }
            d=d-lib_dat[a][1];
            //mp.remove(mp.lastKey());
            coun=0;
        }

//        Set set = mp.entrySet();
//        Iterator i = set.iterator();
//
//        // Traverse map and print elements
//        while (i.hasNext()) {
//            Map.Entry me = (Map.Entry)i.next();
//            a=me.getKey();
//            System.out.println(me.getValue()+" "+lib_dat[me.getValue()][0]);
//        }


        out.flush();
        out.close();
    }

    static int[][] sort(int arr[][], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }

        return arr;
    }

    static int[][] merge(int arr[][], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[][] = new int [2][n1];
        int R[][] = new int [2][n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
            L[0][i] = arr[0][l + i];
            L[1][i] = arr[1][l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[0][j] = arr[0][m + 1 + j];
            R[1][j] = arr[1][m + 1 + j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[0][i] <= R[0][j])
            {
                arr[0][k] = L[0][i];
                arr[1][k]=L[1][i];
                i++;
            }
            else
            {
                arr[0][k] = R[0][j];
                arr[1][k]=R[1][j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[0][k] = L[0][i];
            arr[1][k]=L[1][i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[0][k] = R[0][j];
            arr[1][k]=R[1][j];
            j++;
            k++;
        }

        return arr;
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader fileReader) {
            br = new BufferedReader(fileReader);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}