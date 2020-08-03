import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);



        int n,d,x;
        n=sc.nextInt();
        int m[][]=new int[n][2];
        for(int i=0;i<n;i++)
            m[i][0]=sc.nextInt();
        if(n<=3)
            out.println("Yes");
        else {
            d = m[1][0] - m[0][0];
            x = m[1][0] + d;
            for (int i = 2; i < n; i++) {
                if (x == m[i][0]) {
                    x = m[i][0] + d;
                    m[i][1] = -1;
                }

            }
            int sf = 0, p = 0, q = 0, z, c = 0, e;
            for (int i = 2; i < n; i++)
                if (m[i][1] != -1) {
                    ++c;
                    if (c == 1)
                        p = i;
                    else if (c == 2) {
                        q = i;
                        break;
                    }
                }

            z = m[q][0] - m[p][0];
            e = m[q][0] + z;

            int f1 = 0;

            for (int i = q + 1; i < n; i++) {
                if (m[i][1] != -1) {
                    if (e == m[i][0]) {
                        e = m[i][0] + z;
                    } else
                        f1 = 1;
                }

            }
            if (f1 == 0)
                out.println("Yes");
            else {
                for(int i=0;i<n;i++) {
                    m[i][1]=0;
                }
                d = m[2][0] - m[0][0];
                x = m[2][0] + d;
                m[2][1] = -1;
                for (int i = 3; i < n; i++) {
                    if (x == m[i][0]) {
                        x = m[i][0] + d;
                        m[i][1] = -1;
                    }

                }
                sf = 0;
                p = 0;
                q = 0;
                c = 0;
                for (int i = 1; i < n; i++)
                    if (m[i][1] != -1) {
                        ++c;
                        if (c == 1)
                            p = i;
                        else if (c == 2) {
                            q = i;
                            break;
                        }
                    }

                z = m[q][0] - m[p][0];
                e = m[q][0] + z;

                int f2 = 0;

                for (int i = q + 1; i < n; i++) {
                    if (m[i][1] != -1) {
                        if (e == m[i][0]) {
                            e = m[i][0] + z;
                        } else
                            f2 = 1;
                    }

                }
                if (f2 == 0)
                    out.println("Yes");
                else {
                    for(int i=0;i<n;i++) {
                        m[i][1]=0;
                    }
                    d = m[2][0] - m[1][0];
                    x = m[2][0] + d;
                    m[2][1] = -1;
                    m[1][1] = -1;
                    for (int i = 3; i < n; i++) {
                        if (x == m[i][0]) {
                            x = m[i][0] + d;
                            m[i][1] = -1;
                        }

                    }
                    sf = 0;
                    p = 0;
                    q = 0;
                    c = 0;
                    for (int i = 0; i < n; i++)
                        if (m[i][1] != -1) {
                            ++c;
                            if (c == 1)
                                p = i;
                            else if (c == 2) {
                                q = i;
                                break;
                            }
                        }

                    z = m[q][0] - m[p][0];
                    e = m[q][0] + z;

                    int f3 = 0;

                    for (int i = q + 1; i < n; i++) {
                        if (m[i][1] != -1) {
                            if (e == m[i][0]) {
                                e = m[i][0] + z;
                            } else
                                f3 = 1;
                        }

                    }
                    if (f3 == 0)
                        out.println("Yes");
                    else
                        out.println("No");

                }

            }
        }




        //out.println("Hello");
        out.flush();
        out.close();
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