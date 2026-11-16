 /*We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
   */
class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        for (size_t i = 1; i< nums.size(); ++i){
            nums[i] += nums[i-1];
        }
        return nums;
        
    }
};
