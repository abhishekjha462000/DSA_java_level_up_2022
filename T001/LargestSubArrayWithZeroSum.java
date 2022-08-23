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