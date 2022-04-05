class Solution {
    public long sumScores(String s) {
       //Use the concept of the Z algorithm 
        long answer=0;
        
        int z[]=new int[s.length()];
        
        int l=0;
        int r=0;
        for(int i=1;i<s.length();++i){
            
            if(i<=r){
                z[i]=Math.min(r-i+1,z[i-l]);
            }
            
            while(i+z[i]<s.length()&&s.charAt(z[i])==s.charAt(i+z[i])){
                //Increasing the count of the characters 
                z[i]++;
            }
            
            if(i+z[i]-1>r){
                l=i;
                r=i+z[i]-1;
            }
        }
        
       long sum=s.length();
        for(int elements:z){
            sum+=elements;
        }
        return sum;
        
    }
}