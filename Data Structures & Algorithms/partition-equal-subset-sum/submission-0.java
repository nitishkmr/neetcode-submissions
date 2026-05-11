class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        return findSum(nums, target, 0);
    }

    boolean findSum(int[] nums, int target, int i) {
        if(target == 0) {
            return true;
        }
        if(target < 0 || i == nums.length) {
            return false;
        }

        return findSum(nums, target - nums[i], i + 1) || findSum(nums, target, i + 1);
    }
}
