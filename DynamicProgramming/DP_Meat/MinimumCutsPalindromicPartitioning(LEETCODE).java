// problem -- https://leetcode.com/problems/palindrome-partitioning-ii/
class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        boolean[][] trueFalse = new boolean[n][n];
        
        for(int gap = 0; gap < n; gap++){
            for(int row = 0, col = gap ; col < n; row++, col++){
                if(gap == 0){
                    trueFalse[row][col] = true;
                }else if(gap == 1){
                    if(s.charAt(row) == s.charAt(col)) trueFalse[row][col] = true;
                }else{
                    if(s.charAt(row) == s.charAt(col)) trueFalse[row][col] = trueFalse[row+1][col-1];
                }
            }
        }
        
        // totalCuts[i] = minimum number of palindromic cuts for the string s[0 ... i]
        // our final answer would be in totalCuts[n-1]
        int[] totalCuts = new int[n];
        
        for(int i = 0; i < n;i++){
            // we are discussing about the string s[0 ... i]
            // This string is of length i+1
            // so the maximum number of cuts that are possible is i
            
            int min = i;
            
            if(trueFalse[0][i]) {
                // This means that s[0 ... i] is a palindrome, thus 
                totalCuts[i] = 0;
                continue;
            }
            
            // s[0 ... i] is not a palindrome
            // so we will try to place a cut after every index
            
            for(int j = 0; j < i;j++){
                // we are placing a cut after the j th index only if the remaining string is a palindrome
                // So check if s[j+1 ... i] is a palindrome or not
                if(trueFalse[j+1][i]){
                    min = Math.min(min, totalCuts[j]+1);
                }
            }
            
            totalCuts[i] = min;
        }
        
        return totalCuts[n-1];
    }
}




// ROUGH WORK





