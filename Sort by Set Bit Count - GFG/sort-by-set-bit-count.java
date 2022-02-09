// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Integer arr[] = new Integer[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            obj.sortBySetBitCount(arr, n);
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < n; i++)
            output.append(arr[i] + " ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute  
{ 
    static class Pair{
        int number;
        int index;
        int count;
        Pair(int number,int index,int count){
            this.number=number;
            this.index=index;
            this.count=count;
        }
    }
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
        //Sorting the number by the bit coint 
        
        List<Pair>lst=new ArrayList<>();
        for(int i=0;i<arr.length;++i){
            int number=arr[i];
            int index=i;
            int count=0;
            for(int j=0;j<61;++j){
                if((number&(1<<j))!=0){
                    ++count;
                }
            }
            lst.add(new Pair(number,index,count));
        }
        Collections.sort(lst,new Comparator<Pair>(){
            @Override
            public int compare(Pair first,Pair second ){
                
                if(first.count==second.count){
                    return first.index-second.index;
                }
                else{
                    return second.count-first.count;
                }
            }
        });
        
        for(int i=0;i<lst.size();++i){
            int number=lst.get(i).number;
            arr[i]=number;
        }
    } 
}
