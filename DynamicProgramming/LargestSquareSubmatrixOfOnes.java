// problem -- https://leetcode.com/problems/maximal-square/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i = matrix.length-1; i >= 0; i--){
            
            for(int j = matrix[0].length-1; j >= 0; j--){
                
                int val = matrix[i][j]-'0';
                
                if(val == 0) continue;
                
                if(j == matrix[0].length-1 || i == matrix.length-1){
                    
                    //means you are in last row or last column
                    // so the maximum square that you can form is 1
                    
                    if(val == 1) dp[i][j] = 1;
                }else{
                    int min = Math.min(dp[i+1][j], dp[i][j+1]);
                    min = Math.min(min, dp[i+1][j+1]);
                    
                    dp[i][j] = 1 + min;
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans * ans;
    }
}


// ROUGH WORK




