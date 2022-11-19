// problem -- https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/number-of-ways-of-triangulation-official/ojquestion
Class Solution{
	public int polygonTriangulation(int n){
		// The total number of ways of triangulating a polygon of N vertices is the N-2 th catalan number

		n = n - 2;

		int[] dp = new int[n+1];

		// The usual catalan dp
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








