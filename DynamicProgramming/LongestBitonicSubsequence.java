// problem -- 
class Solution{
    private static int LBIS(int[] nums){
        int[] lis = new int[nums.length];
        int[] lds = new int[nums.length];

        for(int i = 0; i < lis.length;i++){
            lis[i] = 1;

            for(int j = i-1; j >= 0;j--){
                if(nums[j] < nums[i] && lis[j]+1 > lis[i])
                    lis[i] = lis[j]+1;
            }
        }

        for(int i = lds.length-1; i >= 0; i--){
            lds[i] = 1;
            
            for(int j = i+1; j < lds.length;j++){
                if(nums[j] < nums[i] && lds[j]+1 > lds[i])
                    lds[i] = lds[j]+1;
            }
        }

        int ans = 0;

        for(int i = 0; i < lds.length;i++){
            ans = Math.max(ans,lis[i]+lds[i]-1);
        }

        return ans;
    }
}


// ROUGH WORK





