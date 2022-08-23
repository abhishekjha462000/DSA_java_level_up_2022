    private static void countSubArrayWithKSum(int[] nums,int k){

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);


        int count = 0;

        int sum = 0;

        for(int i : nums){
            sum += i;

            int remValue = sum-k;

            Integer freqOfRemValue = map.get(remValue);

            if(freqOfRemValue == null){
                map.put(sum,map.getOrDefault(sum,0)+1);
            }else{
                count += freqOfRemValue;

                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        System.out.println(count);

    }