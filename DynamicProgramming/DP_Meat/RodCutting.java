Class Solution{
	// prices[i] = cost by selling the rod of length i without cutting it
	public static int maxCost(int[] prices){
		// create a new array to shift the prices
		int n = prices.length;

		int[] np = new int[n+1];

		for(int i = 0; i < n;i++) np[i+1] = prices[i];

		// dp[i] = the maximum cost that could be achieved by selling the rod of length i
		int[] dp = new int[n+1];

		dp[0] = 0;
		dp[1] = np[1];

		// This is left right strategy
		for(int i = 2; i < dp.length;i++){
			// This is the default price
			dp[i] = np[i];

			int p1 = 1; // part one can be atleast of length 1
			int p2 = i-1; //  part two then has to be atleast of length i-1

			while(p1 <= p2){
				dp[i] = Math.max(dp[i], dp[p1]+dp[p2]);
				p1++;
				p2--;
			}
		}

		// dp[n] = maximum cost acheived by selling the rod of length n
		return dp[n];
	}
}




// ROUGH WORK










