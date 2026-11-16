/*
find the subarray with the largest sum, and return its sum.
*/class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the previous subarray or start fresh from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update the global maximum subarray sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
