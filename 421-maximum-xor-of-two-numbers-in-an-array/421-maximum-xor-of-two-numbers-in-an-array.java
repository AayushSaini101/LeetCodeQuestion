class Solution {
     
    public class Trie{
        
        Trie childern[];
        Trie(){
          
            childern=new Trie[2];
            childern[0]=null;
            childern[1]=null;
        }
    }
    
    public void insertTrie(int value,Trie root){
        //Let's try to insert the values in 
        //the trie
        int bit=30;
        
        Trie temp=root;
        
        while(bit>=0){
            if((value&(1<<bit))!=0){
                //means the bit is set 
               if(temp.childern[1]==null){
                   temp.childern[1]=new Trie();
                   //Shift the value
                   temp=temp.childern[1];
               }
                else{
                    temp=temp.childern[1];
                }
                
            }
            else{
                 if(temp.childern[0]==null){
                   temp.childern[0]=new Trie();
                   //Shift the value
                   temp=temp.childern[0];
               }
                else{
                    temp=temp.childern[0];
                }
                
            }
            --bit;
        }
    }
    public int maxXor(int value,Trie root){
        int ans=0;
        
        int bit=30;
        
        Trie temp=root;
        
        while(bit>=0){
            
            if((value&(1<<bit))!=0){
                //Means the value the bit value is 1 and it is present in the trie
               // System.out.println(bit);
                if(temp.childern[1]!=null){
                      ans|=(1<<bit);
                     temp=temp.childern[1];
                }
                else{
                    temp=temp.childern[0];
                }
                
            }
            else{
                if(temp.childern[0]==null){
                    ans|=(1<<bit);
                    temp=temp.childern[1];
                }
                else{
                    temp=temp.childern[0];
                }
            }
            --bit;
        }
        return ans;
        
        
    }
    public int findMaximumXOR(int[] nums) {
        Trie root=new Trie();
        for(int elements:nums){
            insertTrie(elements,root);
        }
        int max=0;
        for(int elements:nums){
            int maxXor=maxXor(elements^Integer.MAX_VALUE,root);
            max=Math.max(max,maxXor^elements);
        }
        return max;
        
    }
}