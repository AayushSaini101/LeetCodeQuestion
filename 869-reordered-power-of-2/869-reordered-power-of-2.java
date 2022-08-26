class Solution {
    
    public void findFrequency(int freq[],int number,int check){
        
        while(number!=0){
            
            int remainder=number%10;
            
            if(check==1){
                
                freq[remainder]++;
                
            }
            else{
                
                freq[remainder]--;
            }
            
            number/=10;
        }
    }
    public boolean canformPower(int power,int number){
        
        int freq[]=new int[10];
        
        findFrequency(freq,power,1);
        
        findFrequency(freq,number,0);
        
     
        
        for(int i=0;i<freq.length;++i){
            
            if(freq[i]!=0)return false;
        }
        
        return true;
        
    }
        
       
    public boolean reorderedPowerOf2(int n) {
        
      for(int i=0;i<31;++i){
          
          boolean check=canformPower(1<<i,n);
          
          
          if(check==true) return true;
      }
        
        return false;
    }
}