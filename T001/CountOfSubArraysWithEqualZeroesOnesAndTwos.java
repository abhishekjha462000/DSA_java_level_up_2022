private static void run(int[] nums){
        HashMap<String,Integer> map = new HashMap<>();

        int count = 0;

        map.put("0#0",1);

        int diffOne = 0; // 1-0
        int diffTwo = 0; // 2-1

        for(int val : nums){
            if(val == 0) diffOne--;

            if(val == 1){
                diffOne++;
                diffTwo--;
            }

            if(val == 2) diffTwo++;


            String code = diffOne + "#" + diffTwo;

            if(map.containsKey(code)){
                int freq = map.get(code);
                count += freq;
                map.put(code,freq+1);
            }else{
                map.put(code,1);
            }
        }

        System.out.println(count);
    }