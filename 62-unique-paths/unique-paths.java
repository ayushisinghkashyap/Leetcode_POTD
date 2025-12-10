class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return f(m-1,n-1,dp);

    }
    public int f(int r, int c, int[][] dp){
        if(r<0 || c<0) return 0;
        if(r==0 && c==0) return 1;
        
        if(dp[r][c]!=-1) return dp[r][c];
        int left = f(r-1,c,dp);
        int right = f(r,c-1,dp);
        return dp[r][c]= left+right;
    }
}