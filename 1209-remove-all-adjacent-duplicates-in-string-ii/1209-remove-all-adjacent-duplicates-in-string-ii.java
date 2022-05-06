class Solution {
    public class Pair {

        int frq;
        char ch;
        Pair(int frq, char ch) {
            this.frq = frq;
            this.ch = ch;
        }
    }
    public String removeDuplicates(String s, int k) {

        if (s.length() < k) {

            return s;
        }

        //Using the Stack datastructure 
        Stack < Pair > S = new Stack < > ();

        for (int i = 0; i < s.length(); ++i) {

            if (S.size() == 0) {

                S.add(new Pair(1, s.charAt(i)));
            } else {

                int freq = 0;

                if (S.peek().ch == s.charAt(i)) {

                    freq = S.peek().frq + 1;
                
                  // System.out.println(freq+" "+i);
                    
                    
                    if (freq == k) {

                      
                        
                        S.add(new Pair(1,s.charAt(i)));
                        
                        while (S.size() != 0 && freq-- > 0) {

                            //Removing the value 
                            
                            S.pop();

                        }
                    } else {
                       // System.out.println();

                        S.add(new Pair(freq , s.charAt(i)));

                    }
                    
                   // System.out.println(freq+" "+i);

                } else {

                    S.add(new Pair(1, s.charAt(i)));

                }



            }



        }

        StringBuffer answer = new StringBuffer("");

        while (S.size() != 0) {

            answer.append(S.pop().ch);
        }

        answer.reverse();

        return answer.toString();
    }
}