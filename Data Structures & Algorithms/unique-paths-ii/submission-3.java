class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // prefill
        int i = 0;
        while(i < m && obstacleGrid[i][0] == 0) {
            dp[i][0] = 1;
            i++;
        }
        int j = 0;
        while(j < n && obstacleGrid[0][j] == 0) {
            dp[0][j] = 1;
            j++;
        }
            
        for(i = 1; i < m; i++) {
            for(j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }
}