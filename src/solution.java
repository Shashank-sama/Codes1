import java.io.*;
import java.util.*;


 class Solution {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n=sc.nextInt();
        String []tickets=new String[n];

        for (int i = 0; i < n; i++) {
            String ticketsItem = sc.nextLine();
            tickets[i] = ticketsItem;
        }

        long result = winningLotteryTicket(tickets);
        out.println(result);
        out.flush();
        out.close();


    }

     static long winningLotteryTicket(String[] tickets) {

         int n=tickets.length;

         Map<String, Integer> mpall=new HashMap<>();
         Map<String, Integer> mp0=new HashMap<>();
         Map<String, Integer> mp1=new HashMap<>();
         Map<String, Integer> mp2=new HashMap<>();
         Map<String, Integer> mp3=new HashMap<>();
         Map<String, Integer> mp4=new HashMap<>();
         Map<String, Integer> mp5=new HashMap<>();
         Map<String, Integer> mp6=new HashMap<>();
         Map<String, Integer> mp7=new HashMap<>();
         Map<String, Integer> mp8=new HashMap<>();
         Map<String, Integer> mp9=new HashMap<>();



         char c;
         String s;
         for(int i=0;i<n;i++)
         {
             s=tickets[i];
             mpall.put(s,1);

             if(s.contains("0"))
                 mp0.put(s,1);


             if(s.contains("1"))
                 mp1.put(s,1);

             if(s.contains("2"))
                 mp2.put(s,1);

             if(s.contains("3"))
                 mp3.put(s,1);

             if(s.contains("4"))
                 mp4.put(s,1);


             if(s.contains("5"))
                 mp5.put(s,1);

             if(s.contains("6"))
                 mp6.put(s,1);

             if(s.contains("7"))
                 mp7.put(s,1);

             if(s.contains("8"))
                 mp8.put(s,1);

             if(s.contains("9"))
                 mp9.put(s,1);

         }

         Map<String, Integer> mpnew=new HashMap<>();
         Map<String, Integer> mpnew2=new HashMap<>();
         long sum=0;

         for(int i=0;i<n;i++)
         {
             s=tickets[i];
             mpnew.putAll(mpall);
             mpnew2.putAll(mpall);

             if(!s.contains("0")) {
                 mpnew.keySet().removeAll(mp0.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }



             if(!s.contains("1")) {
                 mpnew.keySet().removeAll(mp1.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }

             if(!s.contains("2")) {
                 mpnew.keySet().removeAll(mp2.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }

             if(!s.contains("3")) {
                 mpnew.keySet().removeAll(mp3.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }

             if(!s.contains("4")) {
                 mpnew.keySet().removeAll(mp4.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }


             if(!s.contains("5")) {
                 mpnew.keySet().removeAll(mp5.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }

             if(!s.contains("6")) {
                 mpnew.keySet().removeAll(mp6.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }

             if(!s.contains("7")) {
                 mpnew.keySet().removeAll(mp7.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }

             if(!s.contains("8")) {
                 mpnew.keySet().removeAll(mp8.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }

             if(!s.contains("9")) {
                 mpnew.keySet().removeAll(mp9.keySet());
                 mpnew2.keySet().removeAll(mpnew.keySet());
                 mpnew.putAll(mpall);
             }


             sum+=mpnew2.size();
         }

         sum=sum/2;

         return sum;

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