class Solution {

    // binarysearch and lower bound
    // lower bound gives the number itself OR just greater than it.
    // feel -> It is like space optimization only
    // ex 1,3,2,4 ->[1], [1,3], [1,2], [1,3,4], [1,2,4]
    // to reduce these many ans arrays so when we already have [1,3] and 2 comes,
    // it can safely replace 3 -> then 4 can be appended to 1,3 / 1,2 doesnt matter
    // size of the array is ans -> NOTE: can only be used for finding lenght, not actual LIS

    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int lbIdx = lowerBound(ans, curr);
            if(lbIdx == -1) {
                ans.add(curr);
            } else {
                ans.set(lbIdx, curr);
            }
        }
        return ans.size();
    }

    int lowerBound(List<Integer> nums, int target) {
        int ans = -1;
        int st = 0;
        int end = nums.size() - 1;
        while(st <= end) {
            int mid = (st + end) / 2;
            if(target == nums.get(mid)) {
                return mid;
            } 
            else if(target < nums.get(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }


    // Recursion based
    // Subs -> Take / Not take
    // public int lengthOfLIS(int[] nums) {
    //     return LIS(nums, 0, -1);
    // }

    // int LIS(int[] nums, int i, int prevLargest) {
    //     if(i == nums.length) {
    //         return 0;
    //     }

    //     int a1 = 0;
    //     if(nums[i] > prevLargest) {
    //         a1 = 1 + LIS(nums, i + 1, nums[i]);    
    //     }
    //     int a2 = LIS(nums, i + 1, prevLargest);
    //     return Math.max(a1, a2);
    // }

}
