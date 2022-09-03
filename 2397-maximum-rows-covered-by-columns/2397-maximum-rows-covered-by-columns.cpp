class Solution {
public:
    
    bool valid(int n,int cols){
        int cnt=0;
        for(int bit=0;bit<12;bit++){
            if((n>>bit)&1)
                cnt++;
        }
        return cnt==cols;
    }
    int fun(vector<vector<int>>& mat,int x,int m,int n){
        
        int answer=0;
        
        for(int i=0;i<m;++i){
            
            int check=0;
            
            for(int j=0;j<n;++j){
                
                if(mat[i][j]==1){
                    
                    if((x&(1<<j))==0){
                        
                        check=1;
                        
                        break;
                    }
                }
            }
            if(check==0){
                
                ++answer;
            }
        }
        return answer;
       
    }
    int maximumRows(vector<vector<int>>& mat, int cols) {
        int m=mat.size();
        int n=mat[0].size();
        int ans=0;
        for(int i=0;i<(1<<n);i++){
            if(valid(i,cols))
                ans=max(ans,fun(mat,i,m,n));
        }
        return ans;
    }
};