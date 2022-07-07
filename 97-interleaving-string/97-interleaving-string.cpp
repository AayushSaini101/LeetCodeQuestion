class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int x = s1.length();
        int y = s2.length();
        int z = s3.length();
        if(z!=x+y)
            return false;
        bool dp[x+1][y+1];
        for(int i=0;i<=x;i++)
        {
            for(int j=0;j<=y;j++)
            {
                if(i==0 && j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[i][j] = dp[i][j-1] && s2[j-1]==s3[j-1];
                else if(j==0)
                    dp[i][j] = dp[i-1][j] && s1[i-1]==s3[i-1];
                else
                    dp[i][j] = ((dp[i][j-1] && s2[j-1]==s3[i+j-1]) || (dp[i-1][j] && s1[i-1]==s3[i+j-1]));
            }
        }
        return dp[x][y];
    }
};