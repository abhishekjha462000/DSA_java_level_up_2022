// problem -- https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/optimal-bst-official/ojquestion
Class Solution{
	private static int optimalbst(int[] keys, int[] frequency, int n) {
		int[][] dp = new int[n][n];

		for(int gap = 0; gap < n; gap++){
			for(int row = 0, col = gap; col < n; row++, col++){
				if(gap == 0){
					dp[row][col] = frequency[row];
				}else if(gap == 1){
					int f1 = frequency[row];
					int f2 = frequency[col];

					dp[row][col] = Math.min(f1 + 2 * f2, f2 + 2 * f1);	
				}else{
					int xFactor = 0;

					for(int i = row; i <= col;i++){
						xFactor += frequency[i];
					}

					dp[row][col] = Integer.MAX_VALUE;

					for(int k = row; k <= col ; k++){
						int val1 = (k-1 >= 0) ? dp[row][k-1] : 0;
						int val2 = (k+1 < n) ? dp[k+1][col] : 0;

						dp[row][col] = Math.min(dp[row][col], val1 + val2 + xFactor);

					}
				}
			}
		}

		return dp[0][n-1];
	}
}




// ROUGH WORK








