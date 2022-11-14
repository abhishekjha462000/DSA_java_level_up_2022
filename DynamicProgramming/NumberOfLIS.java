// problem -- https://leetcode.com/problems/number-of-longest-increasing-subsequence/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        
        for(int i = 0; i < nums.length;i++){
            dp[i] = 1;
            cnt[i] = 1;
            
            for(int j = 0; j < i;j++){
                if(nums[j] < nums[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        cnt[i] = cnt[j];
                    }else if(dp[j]+1 == dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < dp.length;i++){
            max = Math.max(max, dp[i]);
        }
        
        int count = 0;
        for(int i = 0; i < dp.length;i++){
            if(dp[i] == max) count += cnt[i];
        }
        
        return count;
    }
}



// ROUGH WORK




