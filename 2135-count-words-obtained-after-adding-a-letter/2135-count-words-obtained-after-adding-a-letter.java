class Solution {
    public char[] sort(char ch[]){
        Arrays.sort(ch);
        return ch;
    }
   public int wordCount(String[] startWords, String[] targetWords) {
     List<String>sortedTargetWords=new ArrayList<>();
     HashSet<String>H=new HashSet<>();
     for(String elements:startWords){
         H.add(new String(sort(elements.toCharArray())));
     }
     for(String elements:targetWords){
         sortedTargetWords.add(new String(sort(elements.toCharArray())));
     }
        int count=0;
        for(int i=0;i<sortedTargetWords.size();++i){
            StringBuffer string=new StringBuffer(sortedTargetWords.get(i));
            for(int j=0;j<string.length();++j){
                //removing every word and checking 
                StringBuffer temp=new StringBuffer(string.substring(0,j)).append(string.substring(j+1,string.length()));
               
                if(H.contains(temp.toString())){// System.out.println(temp);
                    ++count;
                    break;
                }
            }
        }
          return count;
    }
  
  
}