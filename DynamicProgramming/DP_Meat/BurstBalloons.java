// problem -- https://leetcode.com/problems/burst-balloons/
Class Solution{
	public int maxCoins(int[] nums){
		int n = nums.length;

		// dp[i][j] = maximum coins obtained by bursting the balloons in [i ... j]
		// NOTE : while calculating dp[i][j], We don't assume that the balloons have been burst in ISOLATION.
		int[][] dp = new int[n][n];

		for(int gap = 0; gap < dp.length ; gap++){
			for(int i = 0, j = gap; j < dp.length ; i++, j++){

				// burst the balloons [i ... j]
				dp[i][j] = Integer.MIN_VALUE; // since we want the maximum value
				// burst the kth balloon at the last
				for(int k = i ; k <= j ; k++){

					int left = (k == i) ? 0 : dp[i][k-1];
					int right = (k == j) ? 0 : dp[k+1][j];

					// the value we will get by bursting the kth balloon, as left and right part would have been bursted already.
					int val = (i == 0 ? 1 : nums[i-1]) * nums[k] * (j == n-1 ? 1 : nums[j+1]);

					dp[i][j] = Math.max(dp[i][j], left + right + val);
				}

			}
		}

		return dp[0][n-1];
	}
}



// ROUGH WORK





