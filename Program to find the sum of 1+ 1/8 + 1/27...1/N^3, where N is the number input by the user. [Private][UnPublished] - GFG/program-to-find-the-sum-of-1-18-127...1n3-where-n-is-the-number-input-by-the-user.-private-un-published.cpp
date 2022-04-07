#include <iostream>

using namespace std;


int main(){
   
   int t;
   cin>>t;
   while(t--){
         int N; 
         cin >> N;
         double sum =0.0;
         
         for(double i=1;i<=N;i++)
         {
             sum = sum + (1.0/(i*i*i));
         }
         
         cout << sum <<endl;
   } return 0;
}