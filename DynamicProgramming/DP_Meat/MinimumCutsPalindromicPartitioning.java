Class Solution{
	public static int minPalindromicCut(String s) {

		// trueFalse[i][j] = The substring s[i ... j] is a palindrome or not
		boolean[][] trueFalse = new boolean[s.length()][s.length()];

		for(int gap = 0; gap < trueFalse.length;gap++){
			for(int row = 0, col = gap; col < trueFalse.length;row++, col++){
				if(gap == 0){
					// This means that we only have one character
					trueFalse[row][col] = true;
				}else if(gap == 1){
					// We have two characters, if the characters match that means that we have a palindrome
					if(s.charAt(row) == s.charAt(col)) trueFalse[row][col] = true;
				}else{
					// If the first and the last character match, then we just need to verify if s[row+1 ... col-1] is a palindrome
					if(s.charAt(row) == s.charAt(col)) trueFalse[row][col] = trueFalse[row+1][col-1];
				}
			}
		}


		// dp[i][j] = minimum number of palindromic cuts in s[i ... j]
		int[][] dp = new int[s.length()][s.length()];

		for(int gap = 0; gap < dp.length;gap++){
			for(int row = 0, col = gap; col < dp.length;row++, col++){
				// if s[row ... col] is a palindrome, then minimum number of cuts is 0.
				if(trueFalse[row][col]){
					dp[row][col] = 0;
					continue;
				}

				dp[row][col] = Integer.MAX_VALUE;

				for(int k = row; k < col ;k++){
					int one = dp[row][k];
					int two = dp[k+1][col];

					dp[row][col] = Math.min(dp[row][col], one + two + 1);
				}

			}
		}

		// Since our final string is s[0 ... s.length()-1], so the answer would be stores in dp[0][s.length()-1]
		return dp[0][s.length()-1];
	}
}





// ROUGH WORK









