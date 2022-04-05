# include <iostream>
#include <cctype>
using namespace std;

int main(){
   int t;
   cin>>t;
   while(t--){
       string s;
         cin>>s;

       for(int i=0;i<s.length();++i){

           char ch=s[i];
           ch=toupper(s[i]);
           if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
               cout<<"*";
           }
           else{
               cout<<s[i];
           }
       }
       cout<<endl;

   }
}