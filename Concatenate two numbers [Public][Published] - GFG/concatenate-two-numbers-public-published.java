// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            int numbers[]= new int[N];
            for(int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countPairs(N, X, numbers); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countPairs(int N, int X, int numbers[]) 
    { 
        // code here
        HashMap<Integer,Integer>H=new HashMap<>();
        for(int elements:numbers){
            H.put(elements,H.getOrDefault(elements,0)+1);
        }
       //Iterating on the digits of the number 
       String number=""+X;
       long count=0;
       for(int i=0;i<number.length();++i){
           
           if(i==0){
             
               continue;
           }
           else{
               int first=Integer.parseInt(number.substring(0,i));
               int second=Integer.parseInt(number.substring(i,number.length()));
               if(Integer.parseInt(""+first+second)!=X){
                   continue;
               }
             if(H.containsKey(first)==false||H.containsKey(second)==false){
                continue;
             }
             //System.out.println(first+" "+second);
             
              if(first==second){
                  count+=(long)H.get(first)*(H.get(first)-1);
              }
              else{
                   count+=(long)H.get(first)*H.get(second);
              }
           }
       }
       return count;
    }
} 