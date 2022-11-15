// problem -- https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        int[] lis = new int[n];
        int[] lds = new int[n];
        
        for(int i = 0; i < n;i++){
            lis[i] = 1;
            
            for(int j = i-1; j >= 0; j--){
                if(nums[j] < nums[i] && lis[j]+1 > lis[i])
                    lis[i] = lis[j]+1;
            }
        }
        
        for(int i = n-1; i >= 0; i--){
            lds[i] = 1;
            
            for(int j = i+1; j < n;j++){
                if(nums[j] < nums[i] && lds[j]+1 > lds[i])
                    lds[i] = lds[j]+1;
            }
        }
        
        int longestBitonicSequenceLength = 0;
        
        for(int i = 0; i < n;i++){
            if(lis[i] > 1 && lds[i] > 1)
                longestBitonicSequenceLength = Math.max(longestBitonicSequenceLength, lis[i]+lds[i]-1);
        }
        
        return n-longestBitonicSequenceLength;
    }
}



// ROUGH WORK





