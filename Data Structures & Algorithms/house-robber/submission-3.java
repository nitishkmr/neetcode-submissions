class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob_(nums, 0, memo);
    }

    int rob_(int[] nums, int x, int[] memo) {
        if(x >= nums.length) {
            return 0;
        }
        if(memo[x] != -1) {
            return memo[x];
        }
        return memo[x] = Math.max(nums[x] + rob_(nums, x+2, memo), rob_(nums, x+1, memo));
    }
}
