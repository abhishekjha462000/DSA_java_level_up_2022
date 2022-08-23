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