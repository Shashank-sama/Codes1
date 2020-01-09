import java.util.*;
import java.lang.*;
import java.io.*;

class MEDIC
{
    public static void main(String[] args)throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);

        int t;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String s=sc.next();
            int y=1000*((int)s.charAt(0)-48)+100*((int)s.charAt(1)-48)+10*((int)s.charAt(2)-48)+((int)s.charAt(3)-48);
            int m=10*((int)s.charAt(5)-48)+((int)s.charAt(6)-48);
            int d=10*((int)s.charAt(8)-48)+((int)s.charAt(9)-48);
            int a=d;
            int b=d;
            int c=0;

            int z=0;
            while(z==0)
            {
                if((y%100==0&&y%400==0 )||(y%100!=0&&y%4==0))
                {
                    for(int k=m;k<13;k++)
                    {
                        if(z==1)
                            break;
                        if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
                        {
                            for(int p=d;p<32;p=p+2)
                            {
                                a=a+2;
                                b=b+2;
                                c=++c;
                            }

                            z=1;
                            break;

                        }
                        else
                        {

                            if(k==4||k==6||k==9||k==11)
                            {

                                for(int p=d;p<31;p=p+2)
                                {
                                    a=a+2;
                                    b=b+2;
                                    c=++c;
                                }
                                d=a-28;
                                c=++c;
                            }
                            else
                            {
                                for(int p=d;p<30;p=p+2)
                                {
                                    a=a+2;
                                    b=b+2;
                                    c=++c;
                                }
                                z=1;
                                break;
                            }
                        }
                        a=d;
                        b=d;
                    }
                }
                else
                {
                    for(int k=m;k<13;k++)
                    {
                        if(z==1)
                            break;
                        if(k==1||k==3||k==5||k==7||k==8||k==10||k==12)
                        {
                            for(int p=d;p<32;p=p+2)
                            {
                                a=a+2;
                                b=b+2;
                                c=++c;
                            }

                            z=1;
                            break;

                        }
                        else
                        {

                            if(k==4||k==6||k==9||k==11)
                            {

                                for(int p=d;p<31;p=p+2)
                                {
                                    a=a+2;
                                    b=b+2;
                                    c=++c;
                                }
                                d=a-28;
                                c=++c;
                            }
                            else
                            {
                                for(int p=d;p<29;p=p+2)
                                {
                                    a=a+2;
                                    b=b+2;
                                    c=++c;
                                }
                                d=a-26;
                                c=++c;
                            }
                        }
                        a=d;
                        b=d;
                    }
                }
                z=1;
            }
            System.out.println(c);
        }
    }}







