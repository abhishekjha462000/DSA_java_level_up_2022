private static void largestSubArrayWithZeroSum(int[] nums){

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        int sum = 0;

        int length = 0;

        for(int i = 0;i < nums.length;i++){
            sum += nums[i];

            if(map.containsKey(sum)){
                int firstIndex = map.get(sum);

                int newMaxLength = i - firstIndex;

                if(length < newMaxLength){
                    length =  newMaxLength;
                }
            }else{
                map.put(sum,i);
            }
        }


        System.out.println(length);

    }

    // 1. You are given an array(arr) of integers.

    // 2. You have to find the length of the largest subarray with sum 0.


    // Sample Input

    // 8

    // 15 -2 2 -8 1 7 10 23
    // Sample Output

    // 5

