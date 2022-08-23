private static void largestSubArrayWithSumDivisibleByK(int[] nums,int k){

        HashMap<Integer,Integer> map = new HashMap<>();;

        map.put(0,-1);

        int sum = 0;

        int maxLength = 0;
        
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];

            sum = sum % k;

            if(sum < 0) sum += k;

            if(map.containsKey(sum)){
                int firstIndex = map.get(sum);

                int length = i - firstIndex;

                maxLength = Math.max(maxLength,length);
                
            }else{
                map.put(sum,i);
            }
        }

        System.out.println(maxLength);

    }



    // 1. You are given an array of integers(arr) and a number K.

    // 2. You have to find length of the longest subarray whose sum is divisible by K.

    // Sample Input

    // 6

    // 2 7 6 1 4 5

    // 3
    // Sample Output

    // 4

