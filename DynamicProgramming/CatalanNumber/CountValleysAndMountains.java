Class Solution{
	// The answer would be same as the nth catalan number
	private static int countOfValleysAndMountains(int n){
		int[] dp = new int[n+1];

		dp[0] = dp[1] = 1;
    
	    for(int i = 2; i <= n;i++){
	        int ptr1 = 0;
	        int ptr2 = i-1;

	        while(ptr1 != i && ptr2 != -1){
	            dp[i] += dp[ptr1] * dp[ptr2];
	            ptr1++;
	            ptr2--;
	        }
	    }

    	return dp[n];
	}
}


// ROUGH WORK





