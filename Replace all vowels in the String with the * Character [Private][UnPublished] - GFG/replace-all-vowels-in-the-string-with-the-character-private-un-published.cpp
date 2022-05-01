// { Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++
class GFG {

  public:
    string replaceVowels(string st) {
           string vowels = "aeiouAEIOU";
    for(int i=0;i<st.length();i++){
        if(vowels.find(st[i])!= string::npos){
            st[i] = '*';
        }
    }
    return st;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string st;

        cin >> st;

        GFG ob;

        cout << ob.replaceVowels(st) << endl;
    }
    return 0;
};  // } Driver Code Ends