// problem -- https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/matrix-chain-multiplication-official/ojquestion
Class Solution{
	public static int mcm(int[] nums){
		int[][] dp = new int[nums.length-1][nums.length-1];

		// This is GAP DP
		for(int gap = 0; gap < dp.length;gap++){
			for(int row = 0, col = gap; col < dp.length; row++, col++){
				if(gap == 0){
					dp[row][col] = 0;
				}else if(gap == 1){
					dp[row][col] = nums[row] * nums[row+1] * nums[col+1];
				}else{
					// Ai ... Aj
					// dp[i][j] = minimum cost to multiply matrices from i to j

					dp[row][col] = Integer.MAX_VALUE;

					for(int k = row; k < col;k++){

						int left = dp[row][k]; // its dimension would be nums[row] * nums[k+1]
						int right = dp[k+1][col]; // its dimension would be nums[k+1] * nums[col+1]
						int cost = nums[row] * nums[k+1] * nums[col+1];
						
						dp[row][col] = Math.min(dp[row][col], left + right + cost);
					}
				}
			}
		}

		return dp[0][dp.length-1];
	}
}



// ROUGH WORK







