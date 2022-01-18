class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int dp[]=new int[flowerbed.length];
        if(flowerbed.length==1){
            if(n==1&&flowerbed[0]==0||n==0){
                return true;
            }
            return false;
        }
        //We can plant only when their is not adjacent plants 
        for(int i=0;i<flowerbed.length;++i){
            if(dp[i]==1){
                continue;
            }
            if(i==0){
                if(flowerbed[i]==0&&i+1<flowerbed.length&&flowerbed[i+1]!=1){
                     dp[i]=1;
                     dp[i+1]=1;
                    --n;
                }
            }
            else
                if(i==flowerbed.length-1){
                    if(i-1>=0&&flowerbed[i-1]!=1&&flowerbed[i]==0){
                        --n;
                    }
                }
            else{
                if(i-1>=0&&i+1<flowerbed.length&&flowerbed[i-1]==0&&flowerbed[i+1]==0&&flowerbed[i]==0){
                    --n;
                    dp[i+1]=1;
                 
                    dp[i]=1;
                }
            }
        }
        return (n<=0)?true:false;
    }
}