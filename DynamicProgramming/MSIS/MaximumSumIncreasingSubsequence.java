// problem -- https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/msis-official/ojquestion
class Solution{
	private static int MIS(int[] nums){
        int[] dp = new int[nums.length];
        int mis = 0;

        for(int i = 0; i < dp.length;i++){
            dp[i] = nums[i];

            for(int j = i-1; j >= 0;j--){
                if(nums[j] <= nums[i] && dp[j]+nums[i] > dp[i])
                    dp[i] = dp[j]+nums[i];
            }

            mis = Math.max(mis, dp[i]);
        }

        return mis;
    }
}


// ROUGH WORK




