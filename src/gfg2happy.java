import java.util.*;
import java.lang.*;
import java.io.*;

class gfg2happy {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int R = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            System.out.println(maxHappiness(a,b,n,R));


        }
    }

     static int maxHappiness(int a[], int b[], int n, int R)
    {
        int happy=0;
        PriorityQueue<int []> q= new PriorityQueue<>(Collections.reverseOrder((x,y)->y[0]==x[0]?x[1]-y[1]:x[0]-y[0]));
        for(int i=0;i<n;i++){                           //if there are 2 items x,y in pq then to arrange them
            int x[]=new int[2];                         //if x[0]==y[0] then if(x[1]>=y[1]) then x is higher than y
            x[0]=a[i];                                  //otherwise y is higher
            x[1]=b[i];                                  //if x[0]!=y[0] then the larger one if higher
            q.add(x);                                   //Higher in reverse collections means larger value towards head
        }
        for(int i=0;i<R;i++){
            int x[]=q.poll();                           //poll retrieves head & deletes it as well
            happy+=x[0];                                //in normal priority queue head is lowest value but here order
                                                        //is reversed
            x[0]=Math.max(0,x[0]-x[1]);

            q.add(x);
        }
        return happy%998244353;
    }

         /*static int maxHappiness(int a[], int b[], int n, int R)
        {
            long Mod=998244353;
            long sum=0;

            TreeMap<String,Integer> mp=new TreeMap<>();

            for(int i=0;i<n;i++)
            {
                String s1=String.valueOf(a[i]);
                String s2=String.valueOf(b[i]);
                String s=s1+"_"+s2;

                if(!mp.containsKey(s))
                {
                    mp.put(s,1);
                }
                else
                {
                    mp.put(s,mp.get(s)+1);
                }
            }

            while(R>0){

                if(mp.isEmpty())
                    break;
                String s=mp.lastKey();
                int x=s.indexOf('_');
                String s1=s.substring(0,x);
                String s2=s.substring(x+1);
                int aa=Integer.valueOf(s1);
                int bb=Integer.valueOf(s2);

                mp.put(s,Math.max(0,mp.get(s)-1));
                if(mp.get(s)==0)
                    mp.remove(s);

                sum=(sum+aa%Mod)%Mod;
                aa=Math.max(0,aa-bb);

                if(aa>0) {
                    s1 = String.valueOf(aa);
                    s = s1 + "_" + s2;

                    if (!mp.containsKey(s)) {
                        mp.put(s, 1);
                    } else {
                        mp.put(s, mp.get(s) + 1);
                    }
                }

                --R;
            }

            return (int)sum;
        }
        */


    }