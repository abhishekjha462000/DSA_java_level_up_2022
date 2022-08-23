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