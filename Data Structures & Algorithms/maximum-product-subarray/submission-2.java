class Solution {
    public int maxProduct(int[] nums) {
        int minProd = nums[0];
        int maxProd = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int a1 = minProd * nums[i];
            int a2 = maxProd * nums[i];
            maxProd = Math.max(a1, Math.max(a2, nums[i]));
            minProd = Math.min(a1, Math.min(a2, nums[i]));
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }
}
