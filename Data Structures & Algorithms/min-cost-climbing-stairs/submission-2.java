class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] memo1 = new int[cost.length];
        Arrays.fill(memo1, -1);

        int[] memo2 = new int[cost.length];
        Arrays.fill(memo2, -1);

       return Math.min(minCostClimbingStairs_(cost, 0, memo1), minCostClimbingStairs_(cost, 1, memo1));
    }
    
    private int minCostClimbingStairs_(int[] cost, int x, int[] memoize) {
        if(x >= cost.length) {
            return 0;
        }
        if(memoize[x] != -1) {
            return memoize[x];
        }

        int cost1 = minCostClimbingStairs_(cost, x + 1, memoize);
        int cost2 = minCostClimbingStairs_(cost, x + 2, memoize);
        return memoize[x] = Math.min(cost1, cost2) + cost[x];
    }
}
