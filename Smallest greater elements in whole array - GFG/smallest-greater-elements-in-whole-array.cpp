// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

int* greaterElement(int arr[], int n);

int main()
{
    int t,n;
    cin>>t;
    while(t--)
    {
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        int *b;
        b = greaterElement(arr, n);
        for(int i=0;i<n;i++){
            if(b[i] == -10000000)
                cout << "_ ";
            else
                cout << b[i] << " ";
        }
        cout<<endl;   
        
    }
    return 0;
}
// } Driver Code Ends


int* greaterElement(int arr[], int n)
{
    // Complete the function
     vector<int> ref(arr,arr+n);
    sort(ref.begin(),ref.end());
    int *ans = new int[n];
    memset(ans,0,sizeof(ans));
    for(int i=0;i<n;i++){
        int idx = upper_bound(ref.begin(),ref.end(),arr[i])-ref.begin();
        if(idx==n)
            ans[i]=-10000000;
        else
            ans[i]=ref[idx];
    }
    return ans;
}
