class WordDictionary {
//We have to desing such  type of  datastructure that 
//Find check whether the String is present in O(1): For this we have Set 
//Second case, we pattern bad  b..  //inorder to check we have to check the String of length 
//Similar to the pottern so we need to find all the Strings of a length n. In this case we can use a HashMap<Integer,List>

    Set<String>string;
    HashMap<Integer,List<String>>stringMap;
    public WordDictionary() {
        string=new HashSet<>();
        stringMap=new HashMap<>();
        
    }
    
    public void addWord(String word) {
        //Adding the word in the both set and mao 
        string.add(word);
        stringMap.computeIfAbsent(word.length(),k->new ArrayList<String>()).add(word);
        
    }
    
    public boolean search(String word) {
    
        //First searching the word in the Set
        if(this.string.contains(word)){
            return true;
        }
        else{
            //Might be case the searching word is a kind of pattern
          //We have to check whether it is a pattern or not 
              if(!this.stringMap.containsKey(word.length())){
                  return false;
              }
               List<String>lst=this.stringMap.get(word.length());
               
               for(int i=0;i<lst.size();++i){
                   int index=0;
               
                  for(int j=0;j<word.length();++j){
                     if(word.charAt(j)=='.'){
                         continue;
                     }   
                     else{
                         if(!(word.charAt(j)==lst.get(i).charAt(j))){
                             index=-1;
                             break;
                         }
                     }
                  
                   }
                   if(index!=-1){
                       return true;
                   }
                  
                
            }
            return false;
            
        }
       
    
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */