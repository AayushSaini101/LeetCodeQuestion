class Solution {
    public int ceil(int number){
        
        return (int)(Math.ceil((double)(Math.log10(number)/Math.log10(3))));
    }
    public int floor(int number){
        
        return (int)(Math.floor((double)(Math.log10(number)/Math.log10(3))));
    }
    public boolean isPowerOfThree(int n) {
      return n > 0 && 1162261467 % n == 0;
    }
}