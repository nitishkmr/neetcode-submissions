class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    int count_(int m, int n) {
        if(m == 0 && n == 0) {
            return 1;
        }
        if(m == 0 || n == 0) {
            return 1;
        }

        return count_(m-1, n) + count_(m, n-1);
    }
}
