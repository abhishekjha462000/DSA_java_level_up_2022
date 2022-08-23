    private static void run(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();

        /**
         * The reason for putting this is empty subarray
         **/
        map.put(0,1);

        int count = 0;

        int sum = 0;

        for(int value : nums){
            sum += value;
            Integer freq = map.get(sum);


            if(freq != null){
                /**
                 * The sum is already present
                 **/
                count += freq;
                map.put(sum,freq+1);

            }else{
                /**
                 * This means that sum has ocuured for the first time, so store it in hashmap
                 **/
                map.put(sum,1);
            }
        }

        System.out.println(count);
    }
