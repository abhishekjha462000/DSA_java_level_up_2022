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


    // 1. You are given an array of integers(arr) and a number K.

    // 2. You have to find the count of subarrays whose sum equals k.

    // Sample Input

    // 3

    // 1 1 1

    // 2
    // Sample Output

    // 2

