import java.util.*;

import java.io.*;

class Solution {
    
    class Pair{
        
        String word;
        
        int freq;
        
        Pair(String word,int freq){
            
            this.word=word;
            
            this.freq=freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        
        TreeMap<String,Integer>T=new TreeMap<>();
        
        for(int i=0;i<words.length;++i){
            
            T.put(words[i],T.getOrDefault(words[i],0)+1);
        }
        
        List<Pair>lst=new ArrayList<>();
        
        for(String elements:T.keySet()){
            
            lst.add(new Pair(elements,T.get(elements)));
        }
        
        Collections.sort(lst,(a,b)->a.freq==b.freq?a.word.compareTo(b.word):b.freq-a.freq);
        
        List<String>answer=new ArrayList<>();
        
        int index=0;
        
        while(k-->0&&index<lst.size()){
            
             answer.add(lst.get(index).word);
            
             ++index;
            
        }
        
        return answer;
        
    }
}