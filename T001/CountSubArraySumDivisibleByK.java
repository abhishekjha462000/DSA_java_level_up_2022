/**
 * link -- https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/
 **/

private static void run(int[] nums,int k){

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        int count = 0 ;
        int sum = 0;
        for(int i : nums){
            sum += i;

            sum = sum % k;

            if(sum < 0) sum +=k;

            if(map.containsKey(sum)){
                int freq = map.get(sum);

                count += map.get(sum);

                map.put(sum, freq+1);
            }else{
                map.put(sum,1);
            }

        }


        System.out.println(count);

    }