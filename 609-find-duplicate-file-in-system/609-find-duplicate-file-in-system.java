class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
  
        List<List<String>>answer=new ArrayList<>();
        
        //The answer will be the root file path, and the file name 
        
        HashMap<String,List<String>>H=new HashMap<>();
        
        
        for(int i=0;i<paths.length;++i){
            
            //Segration the multiple files present int the particular location 
           
            String msg[]=paths[i].split(" ");
            
           // System.out.println(Arrays.toString(msg));
            
            String rootPath="";
            
            for(int j=0;j<msg.length;++j){
                
                
                if(j==0){
                    
                    rootPath=msg[j];
                }
                else{
                    
                     String filePath[]=msg[j].split("[.]");

                    if(H.containsKey(filePath[1])==false){
                        
                        H.put(filePath[1],new ArrayList<>());
                    }
                
                 //   System.out.println(Arrays.toString(filePath));
                    
                    H.get(filePath[1]).add(rootPath+"/"+filePath[0]);
                    
                    
                    
                   // H.get(msg[j]).add(rootP)
                }
                
            }
            
           
            
           
        }
        
       // System.out.println(H);
         
        for(String elements:H.keySet()){
            
            List<String>str=H.get(elements);
            
            if(str.size()==1)continue;
            
            List<String>commonPath=new ArrayList<>();
            
            for(int i=0;i<str.size();++i){
                
                commonPath.add(str.get(i)+"."+"txt");
            }
            
            answer.add(new ArrayList<>(commonPath));
        }
        return answer;
        
        
    }
}