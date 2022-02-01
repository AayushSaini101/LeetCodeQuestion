class Solution {
    public int maxProfit(int[] prices) {
         int buy1=Integer.MIN_VALUE;
        int sell1=0;
        for(int i=0;i<prices.length;++i){
            buy1=Math.max(buy1,-prices[i]);
        
            sell1=Math.max(sell1,buy1+prices[i]);
        //    System.out.println(sell1);
        }
        
        return sell1;
    }
}

