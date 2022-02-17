// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        while (t-- > 0) {

            int n = scan.nextInt();

            Solution ob = new Solution();

            System.out.println(ob.minimum_coins(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimum_coins(int N) {

       List<Integer> lst = new ArrayList<>();

        lst.add(1);
        lst.add(2);
        lst.add(5);
        lst.add(10);
        lst.add(20);
        lst.add(50);
        lst.add(100);
        lst.add(500);
        lst.add(1000);

        int coins_needed = 0;

        for (int i = lst.size() - 1; i >= 0; --i) {
            int coins = (N / lst.get(i));
            coins_needed += coins;
            N -= (coins * lst.get(i));
        }

        return coins_needed;
    }
}