private static void run(int[] nums){

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        int count = 0;

        int diff = 0;

        for(int val : nums){
            if(val == 0) diff--;
            if(val == 1) diff++;

            if(map.containsKey(diff)){

                int freq = map.get(diff);

                count += freq;

                map.put(diff,freq+1);

            }else{

                map.put(diff,1);

            }
        }
        
        System.out.println(count);
    }