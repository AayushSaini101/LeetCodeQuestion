class Solution {
   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		//set to hold all words
        Set<String> dict = new HashSet<>(wordList);
        //if endword does not exists return 0
		if(!dict.contains(endWord)) {
            return 0;
        }
        
        int level=1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
		//iterate bfs level wise
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                String word = queue.poll();
				//if current word is end word return count
                if(word.equals(endWord)) {
                    return level;
                }
				//iterate and try every character change for ith index in word
                for(int i=0;i<word.length();i++) {
                    for(int ch='a';ch<='z';ch++) {
                        char[] arr = word.toCharArray();
						//don't need to replace same character again.
                        if((char)ch!=arr[i]) {
                            arr[i]=(char)ch;
                            String newWord = new String(arr);
								//if set contains newWord add it to queue and remove it from set to avoid further processing
                            if(dict.contains(newWord)) {
                                queue.add(newWord);
                                dict.remove(newWord);
                            }
                        }
                    }        
                }
            }
            level++;
        }
        return 0;
    }
}