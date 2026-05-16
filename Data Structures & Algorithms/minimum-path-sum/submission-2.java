class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // this is important case here since 
                    // it feels the [0][0] will automatically get filled but it doesnt happen
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int up = i >= 1 ? dp[i-1][j] : Integer.MAX_VALUE;
                int left = j >= 1 ? dp[i][j - 1] : Integer.MAX_VALUE;
                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }
}