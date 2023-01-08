class Solution {
  
    public boolean possible(char first,char second,int arr1[],int arr2[]){
        
        arr1[first-'a']--;
        
        arr2[first-'a']++;
        
        arr2[second-'a']--;
        
        arr1[second-'a']++;
        
        int count=0;
        
        for(int i=0;i<arr1.length;++i){
            
            if(arr1[i]!=0)++count;
        }
        
     //   System.out.println(count);
    
        for(int i=0;i<arr2.length;++i){
            
            if(arr2[i]!=0)--count;
        }
        
        if(count==0)return true;
        
       
        arr1[first-'a']++;
        
        arr2[first-'a']--;
        
        arr2[second-'a']++;
        
        arr1[second-'a']--;
        
        return false;
    }
    public boolean isItPossible(String word1, String word2) {
        
      
        int first[]=new int[26];
        
        int second[]=new int[26];
        
        for(int i=0;i<word1.length();++i){
            
            int temp=word1.charAt(i)-'a';
            
            first[temp]++;
        }
        
        for(int i=0;i<word2.length();++i){
            
            int temp1 = word2.charAt(i)-'a';
            
            second[temp1]++;
        }
        
        for(char i='a';i<='z';++i){
            
            for(char j='a';j<='z';++j){
                
                if(first[i-'a']!=0&&second[j-'a']!=0){
               
                  //  System.out.println(i+" "+j);
                    if(possible(i,j,first,second))return true;
                }
            }
        }
        
        return false;
    }
}