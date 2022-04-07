#include<bits/stdc++.h>
#include <fcntl.h>
#include <unistd.h>

using namespace std;

mt19937 rng(0);
long long get_random(){
    long long rdx = rng();
    return llabs(rdx);
}

long long get_range(long long start, long long end){
    if(end - start + 1 <= 0){
        return 0;
    }
    return start + (get_random() % (end - start + 1));
}

// t = 100 n = 1000
// t = 10 n = 10000
// t = 1 n = 100000
// t = 1 n = 100000
int32_t main(){

/*
5
1 2 3 4 5
~
*/

    //need_for_speed();
    int t=0;;
   cin>>t;
   while(t--){
         int N;
         cin>>N;
         int element;
         cin>>element;
         vector<int>v;
         for(int i=0;i<N;++i){
             int number=0;
             cin>>number;
             v.push_back(number);
         }
       

         v.insert(v.begin(),element);

         for(int i=0;i<v.size();++i){
             cout<<v[i]<<" ";
         }
         
         cout<<endl;
       


 
       
       
   
}



}