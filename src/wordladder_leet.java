import java.util.*;
import java.lang.*;
import java.io.*;

class wordladder_leet
{
    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);


        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList =new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        int ans=ladderLength(beginWord,endWord,wordList);       //Using 1-D BFS, much slower
        //ans=ladderLength1(beginWord,endWord,wordList);        //Using 2-D BFS, much faster
        System.out.println(ans);


    }

    //_________________________________________________________________________________________________________

    //METHOD - 1 , Using 1-directional BFS [O(n^2 + m)] OR [O(m^2 + n)]
    // (Much slower compared to 2-Directional BFS)

    static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord))
            return 0;

        int len=beginWord.length();
        int n;
        if(wordList.contains(beginWord))
            n=wordList.size();
        else
            n=wordList.size()+1;

        String[] words=new String[n];
        words[0]=beginWord;

        int k=1,ans_ind=-1;
        for(int i=0;i<wordList.size();i++)
        {
            if((wordList.get(i)).compareTo(beginWord)!=0) {
                words[k] = wordList.get(i);

                if (words[k].compareTo(endWord) == 0)
                    ans_ind = k;

                ++k;
            }
        }

        int dist[]=new int[n];
        for(int i=0;i<n;i++)
            dist[i]=Integer.MAX_VALUE;

        LinkedList<Integer> adj[]=new LinkedList[n];
        for(int i=0;i<n;i++)                            //o(n*n + O(len)), n is no. of words in dict,
        {                                               //len is length of each word
            adj[i]=new LinkedList<>();
            for(int j=0;j<n;j++)
            {
                boolean z=almostsame(words[i],words[j]);
                if(z==true)
                    adj[i].add(j);
            }
        }

        BFS(0,words,dist,adj);

        if(dist[ans_ind]==Integer.MAX_VALUE)
            return 0;
        else
            return dist[ans_ind];

    }

    static void BFS(int s,String[] words, int[] dist,LinkedList<Integer> adj[]) {       //1-Directional BFS

        int n=words.length;
        boolean visited[]=new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s]=true;
        dist[s]=1;
        queue.add(s);

        while(queue.size()!=0)
        {
            s=queue.poll();

            Iterator<Integer> i=adj[s].listIterator();
            while(i.hasNext())
            {
                int x=i.next();
                if(visited[x]==false)
                {
                    visited[x]=true;
                    dist[x]=dist[s]+1;
                    queue.add(x);
                }
            }
        }

    }

    static boolean almostsame(String s1, String s2) {   //check if two words have only one different letter

        int l=s1.length();      //assuming both strings are of same length
        if(l!=s2.length())
            return false;

        int i=0;
        int count=0;
        while(i<l) {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(count==1)
                    return false;

                ++count;
                ++i;
            }
            else
                ++i;

        }

        return count==1;
    }


    //_________________________________________________________________________________________________________________


    //METHOD - 2 ; Bi-directional BFS   (Much faster than 1-D BFS)


    static int ladderLength1(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord))
            return 0;

        Set<String> dict = new HashSet<>(wordList);
        Set<String> qstart = new HashSet<>();   //words from starting end
        Set<String> qend = new HashSet<>();     //words from ending point
        Set<String> visited = new HashSet<>();

        qstart.add(beginWord);

        if (dict.contains(endWord))
            qend.add(endWord); // all transformed words must be in dict (including endWord)

        for (int len = 2; !qstart.isEmpty(); len++) {
            Set<String> nextq = new HashSet<>();    //to store all adjacent words from qstart

            for (String w : qstart) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself

                        ch[j] = c;
                        String new_word = String.valueOf(ch);
                        if (qend.contains(new_word))
                            return len; // meet from two ends
                        if (dict.contains(new_word) && (!visited.contains(new_word)))
                        {
                            visited.add(new_word);
                            nextq.add(new_word); // not meet yet, vis is safe to use
                        }
                    }
                }
            }

            qstart=(nextq.size() < qend.size()) ? nextq : qend; //switch to small one to traverse from other end
            qend = (qstart == nextq) ? qend : nextq;
        }

        return 0;
    }

    //_______________________________________________________________________________________________________________

}
