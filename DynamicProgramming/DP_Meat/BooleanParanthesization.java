// problem -- https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/boolean-parenthesization-official/ojquestion
Class Solution{
	public static int solution(String str1, String str2) {
		int n = str1.length();

		int[][] dpt = new int[n][n];
		int[][] dpf = new int[n][n];

		for(int gap = 0; gap < n; gap++){
			for(int row = 0, col = gap; col < n; row++, col++){
				if(gap == 0){
					char ch = str1.charAt(row); // str1.charAt(col)
					if(ch == 'T'){
						dpt[row][col] = 1;
						dpf[row][col] = 0;
					}else{
						dpt[row][col] = 0;
						dpf[row][col] = 1;
					}
				}else {
					for(int k = row; k < col; k++){
						char operator = str2.charAt(k);
						int leftTrueCount = dpt[row][k];
						int leftFalseCount = dpf[row][k];

						int rightTrueCount = dpt[k+1][col];
						int rightFalseCount = dpf[k+1][col];

						int totalCounts = leftTrueCount * rightTrueCount + leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount + leftFalseCount * rightFalseCount;

						if(operator == '&'){
							dpt[row][col] += leftTrueCount * rightTrueCount;
							dpf[row][col] += totalCounts - (leftTrueCount * rightTrueCount);
						}else if(operator == '|'){
							dpf[row][col] += leftFalseCount * rightFalseCount;
							dpt[row][col] += totalCounts - (leftFalseCount * rightFalseCount);
						}else {
							dpt[row][col] += leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount;
							dpf[row][col] += totalCounts - (leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount);
						}

					}
				}
			}
		}

		return dpt[0][n-1];

	}
}




// ROUGH WORK







