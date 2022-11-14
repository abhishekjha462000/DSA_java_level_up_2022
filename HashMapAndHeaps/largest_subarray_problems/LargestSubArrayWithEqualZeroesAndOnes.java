private static void largestSubArrayWithEqualZeroesAndOnes(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        int diff = 0;

        int maxLength = 0;

        for(int i = 0; i < nums.length;i++){
            int val = nums[i];

            if(val == 0) diff--;
            if(val == 1) diff++;

            if(map.containsKey(diff)){
                int firstIndex = map.get(diff);

                int length = i - firstIndex;

                maxLength = Math.max(maxLength,length);
            }else{
                map.put(diff,i);
            }
        }

        System.out.println(maxLength);
    }



    // 1. You are given an array that contains only 0s and 1s.

    // 2. You have to find length of the longest subarray with equal number of 0s and 1s.

    // Sample Input

    // 6

    // 0 1 1 0 1 1
    // Sample Output

    // 4


