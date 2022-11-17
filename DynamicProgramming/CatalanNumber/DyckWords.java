// Given an integer N, the task is to count Dyck words possible of length n. A DYCK word is a word containing only characters ‘X’ and ‘Y’ such that in every prefix of the word frequency(‘X’) ≥ frequency(‘Y’)
Class Solution{
	public static int countDyckWords(int N){
		// answer would be Nth catalan number
		int[] dp = new int[N+1];

		dp[0] = dp[1] = 1;

		for(int i = 2; i <= N;i++){
			int ptr1 = 0;
			int ptr2 = i-1;

			while (ptr1 != i && ptr2 != -1) {
				dp[i] += dp[ptr1] * dp[ptr2];
				ptr1++;
				ptr2--;
			}
		}

		return dp[N];
	}
}



// ROUGH WORK






