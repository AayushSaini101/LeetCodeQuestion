class Solution {
    int sum1=0;
    int min1=Integer.MAX_VALUE;
    public int max(int start,int end,int arr[]){
        int  max=0;
        for(int i=start;i<=end;++i){
            max=Math.max(arr[i],max);
        }
        return max;
    }
    public int find(int start,int end,int arr[],Integer dp[][],int build[]){
        //Only one element is present that is the leaf node
        if(end-start==1){
            return arr[start]*arr[end];
        }
        if(start==end){
           return 0;
        }
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        int min=Integer.MAX_VALUE;
        for(int i=start;i<end;++i){
            
             int left=find(start,i,arr,dp,build);
            
             int right=find(i+1,end,arr,dp,build);
           //We are finding the maximum value before teh number 
            //if we want to maximum value 
            int rangeleft=findrange(start,i,arr,build);
            
            int rangeRight=findrange(i+1,end,arr,build);
         
            min=Math.min(min,left+right+rangeleft*rangeRight);
            
        }
       
        dp[start][end]=min;
        return min;
    }
    //use the segment tree
    public int build(int arr[],int start,int end,int build[],int count){
        if(start==end){
          return  build[count]=arr[start];
           
        }
        int mid=(start+end)>>1;
        
      return   build[count]=Math.max(build(arr,start,mid,build,2*count+1),build(arr,mid+1,end,build,2*count+2));
     
        
    }
    // 1 and 2 
    //0
public int rangemax(int start,int end,int i,int j,int build[],int count){
    
    //Checking the base case
   //  System.out.println(start+" "+end+" "+i+" "+j+" "+ count);
    if(i>=start&&j<=end){
        if(count<build.length)
        return build[count];
    }
     if(i>=j){
         return 0;
    }
     if(j<start||end<i){
         return 0;
     }
    
    int mid=(i+j)>>1;
 
    int left=rangemax(start,end,i,mid,build,2*count+1);
    
    int right=rangemax(start,end,mid+1,j,build,2*count+2);
    
    return Math.max(left,right);
    
}
 public int findrange(int start,int end,int arr[],int build[]){
     return rangemax(start,end,0,arr.length-1,build,0);
 }
    public int mctFromLeafValues(int[] arr) {
     int start=0;
     int end=arr.length-1;
  
     int build[]=new int[4*arr.length];
     build(arr,0,arr.length-1,build,0);
     Integer dp[][]=new Integer[arr.length][arr.length];
     return find(start,end,arr,dp,build);
    }
}