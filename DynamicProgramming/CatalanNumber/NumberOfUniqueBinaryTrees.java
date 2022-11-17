// problem -- https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i < dp.length;i++){
            // find the value of the ith catalan number
            int ptr1 = 0;
            int ptr2 = i-1;
            
            while(ptr1 < i && ptr2 >= 0){
                dp[i] += (dp[ptr1] * dp[ptr2]);
                ptr1++;
                ptr2--;
            }
        }
        
        return dp[n];
    }
}


// ROUGH WORK





