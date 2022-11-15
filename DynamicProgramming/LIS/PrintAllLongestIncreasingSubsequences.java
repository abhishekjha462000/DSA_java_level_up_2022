// problem -- https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lis-re-official/ojquestion
public class Solution{
    
    public static void printAllLIS(int []nums){
        
        // find lis
        
        int lis = 0;
        
        int[] dp = new int[nums.length];

        for(int i = 0; i < dp.length;i++){
            dp[i] = 1;

            for(int j = i-1; j >= 0;j--){
                if(nums[j] <= nums[i] && dp[j]+1 > dp[i]) dp[i] = dp[j]+1;
            }

            lis = Math.max(dp[i], lis);
        }

        System.out.println(lis);

        Queue<Pair> queue = new ArrayDeque<>();

        for(int i = 0; i < dp.length;i++){
            if(dp[i] == lis){
                queue.add(new Pair(lis, i, nums[i], nums[i]+""));
            }
        }

        // classic breadth first search
        while(queue.size() > 0){
            Pair rem = queue.remove();

            int length = rem.l;
            int val = rem.v;
            int index = rem.i;
            String psf = rem.psf;

            if(length == 1){
                System.out.println(psf);
            }

            for(int j = index-1; j >= 0;j--){
                if(nums[j] <= nums[index] && dp[j] == length-1){
                    queue.add(new Pair(dp[j], j, nums[j], nums[j] + " -> " + psf));
                }
            }
        }
    }

    public static class Pair {
        int l;
        int i;
        int v;
        String psf;
        
        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
}




// ROUGH WORK




