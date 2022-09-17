class Solution {
    
    class Trie{
        
        Trie ob[];
        
        int index;
        
        List<Integer>lst;
        
        Trie(){
            
            this.lst=new ArrayList<>();
            
            this.ob=new Trie[26];
            
            this.index=-1;
        }
    }
    public boolean pallindrom(int left,int right,String str){
        if(right<0)return false;
        
        while(left<=right){
            
            if(str.charAt(left)!=str.charAt(right))return false;
            
            ++left;
            
            --right;
        }
        
        return true;
    }
    public void insert(String str,Trie head,int index){
        
        
      Trie temp=head;
        
      for(int i=str.length()-1;i>=0;--i){
          
          int key=str.charAt(i)-'a';
          
          if(temp.ob[key]==null){
              
              temp.ob[key]=new Trie();
          }
          
          if(pallindrom(0,i,str)){
              
            
              
              temp.lst.add(index);
          }
          
          temp=temp.ob[key];
      }
        
      temp.index=index;
        
        
        
    }
    public void search(String word,Trie head,int wordIdx,List<List<Integer>>answer){
        
  
        Trie root=head;
        
        for (int i = 0; i < word.length(); i++) {
            if (root.index != -1 && wordIdx != root.index && pallindrom(i, word.length() - 1,word)) {
                answer.add(Arrays.asList(wordIdx, root.index));
            }
            
            char c = word.charAt(i);
            root = root.ob[c - 'a'];
            if (root == null) return;
        }
        

        if (root.index != wordIdx && root.index != -1) {
            answer.add(Arrays.asList(wordIdx, root.index));
        }
        

        for (Integer k : root.lst) {
            answer.add(Arrays.asList(wordIdx, k));
        }
        
        return ;    
        
        
     
        
       
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        
        //This is the conecpt of the trie datastructure
        
        Trie head=new Trie();
        
        List<List<Integer>>pairs = new ArrayList<>();
        
        for(int i=words.length-1;i>=0;--i){
        
            
            insert(words[i],head,i);
        }
        
        for(int i=0;i<words.length;++i){
            
            search(words[i],head,i,pairs);
            
        }
        
        return pairs;
        
        
        
    }
}