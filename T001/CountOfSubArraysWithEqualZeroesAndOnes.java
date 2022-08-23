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




    // 1. You are given an array that contains only 0s and 1s.

    // 2. You have to find the count of subarrays with equal number of 0s and 1s.
    // Constraints

    // 1 <= N <= 10^5

    // 0 <= arr[i] <= 1



    // Sample Input

    // 6

    // 0 1 1 0 1 1
    // Sample Output

    // 4

