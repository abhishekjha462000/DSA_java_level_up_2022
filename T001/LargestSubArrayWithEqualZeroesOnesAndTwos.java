private static void run(int[] nums){
        HashMap<String,Integer> map = new HashMap<>();

        map.put("0#0",-1);

        int diffOne = 0; // 1-0
        int diffTwo = 0; // 2-1

        int maxLength = 0;

        for(int i = 0; i < nums.length;i++){

            int val = nums[i];

            if(val == 0) diffOne--;

            if(val == 1){
                diffOne++;
                diffTwo--;
            }

            if(val == 2) diffTwo++;


            String code = diffOne + "#" + diffTwo;

            if(map.containsKey(code)){
                int firstIndex = map.get(code);

                int length = i - firstIndex;

                if(maxLength < length){
                    maxLength = length;
                }

            }else{
                map.put(code,i);
            }
        }

        System.out.println(maxLength);
    }