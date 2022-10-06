
import com.sun.source.tree.Tree;

import java.util.*;

import java.io.*;

class TimeMap {
  
    
    HashMap<String,TreeMap<Integer,String>>H;
    
    public TimeMap() {
    
        H=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
       	if(H.containsKey(key)==false){
			
			H.put(key,new TreeMap<>());
		}

		H.get(key).put(timestamp,value);
       
    }
   
   
    public String get(String key, int timestamp) {
        
  //  System.out.println(H);
        
      if(H.containsKey(key)==false){
          
          return "";
      }
      else{

          TreeMap<Integer,String>t=H.get(key);
          
          if(t.floorKey(timestamp)==null)
          return "";
          
          else{
              return t.get(t.floorKey(timestamp));
          }
         
      }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */