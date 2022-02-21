// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// User function Template for C++

int minimum_coins(int N) {
    // Write your code here.
    int available_coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int coins_needed = 0;
     for (int i = 9 - 1; i >= 0; i--) {
          // number of coins we can take of this denomination
        int coins = (int)(N / available_coins[i]);
        coins_needed += coins;
        N -= (coins * available_coins[i]);
    }
  
    return coins_needed;
}


// { Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {

        int N;
        cin >> N;
        cout << minimum_coins(N) << endl;
    }

    return 0;
}
  // } Driver Code Ends