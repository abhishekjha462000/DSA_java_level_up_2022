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



    // 1. You are given an array of integers(arr) and a number K.

    // 2. You have to find the count of subarrays whose sum is divisible by K.

    // Sample Input

    // 6

    // 2 7 6 1 4 5

    // 3
    // Sample Output

    // 5

