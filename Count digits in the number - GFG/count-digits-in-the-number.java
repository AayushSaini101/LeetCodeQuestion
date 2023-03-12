import java.util.*;
public class Main {

  static  public int isArmstrong(int n) {
    int sum = 0, temp = n;
    int digits = (int) (Math.floor(Math.log(n)/Math.log(10)) + 1); // count number of digits
    while (temp > 0) {
        int digit = temp % 10;
        sum += Math.pow(digit, digits);
        temp /= 10;
    }
    if (sum == n) {
        return 1;
    }
    return 0;
}

static int countArmstrongNumbers(List<Integer>nums) {
    int count = 0;
    for (int i = 0; i < nums.size(); i++) {
        if (isArmstrong(nums.get(i))==1) {
            count++;
        }
    }
    return count;
}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t=scan.nextInt();

        while(t-->0){

            int n=scan.nextInt();

            int x=scan.nextInt();

            int count=0;

            while(n>0){
                int rem=n%10;

                if(rem==x){
                    ++count;
                }
                n/=10;
            }
            System.out.println(count);
        }


    }
}