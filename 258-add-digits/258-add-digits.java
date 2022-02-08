class Solution {
    public int addDigits(int num) {
     int answer=0;
        if(num<=9){
            answer=num;
            return answer;
        }
        else{
            while(num>9){
                int changeNumber=num;
                int sum=0;
                while(changeNumber!=0){
                    sum+=changeNumber%10;
                    changeNumber/=10;
                }
                
               num=sum;
            }
            return num;
        }
    }
}