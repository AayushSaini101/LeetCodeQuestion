//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
   static boolean isDigit(char ch){

        if(ch>='0'&&ch<='9')return true;

        return false;
    }

    static void append(StringBuffer str,int number,Stack<Character>S){

        for(int i=0;i<number;++i){

            for(int j=0;j<str.length();++j){

                S.add(str.charAt(j));
            }
        }

    }
    static String decodedString(String s){
        // code here

        Stack<Character>S=new Stack<>();

        for(int i=0;i<s.length();++i){

            if(s.charAt(i)==']'){

                StringBuffer str=new StringBuffer("");

                int number=0;

                int power=1;

                while(S.size()!=0&&(S.peek())!='['){


                      char ch=S.pop();

                      str.append(ch);



                }


                if(str.length()!=0){

                    str.reverse();

                }

                S.pop();

                while(S.size()!=0&&isDigit((S.peek()))){


                    int digit=(S.peek())-'0';

                    number=digit*power+number;

                    power*=10;

                    S.pop();

                }

                if(number!=0){

                    append(str,number,S);
                }

                 //System.out.println(str+" "+number);

            }

            else{

                 S.add(s.charAt(i));

              }


        }

        StringBuffer answer=new StringBuffer();
        
        while(S.size()!=0){

            answer.append(S.pop());

        }

        answer.reverse();

        return answer.toString();

    }
}