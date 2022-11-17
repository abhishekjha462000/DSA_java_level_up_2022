// Given a circle with 2 * N points, find the maximum number of non intersecting chords that you can make out of this 2 * N pointsz
// The answer is Nth catalan number
Class Solution{
    public static long NumberOfChords(int n){
        long[] dp = new long[n+1];
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







