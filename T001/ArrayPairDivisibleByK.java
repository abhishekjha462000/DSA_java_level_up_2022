    private static void run(int[] nums,int k){
        int len = nums.length;

        if(len % 2 == 1){
            System.out.println(false);
            return ;
        }

        /**
         * This hashmap would store the remainder of the elements of the array and their frequency
         **/
        HashMap<Integer,Integer> rem = new HashMap<>();

        for(int i : nums){
            int remainder = i % k;

            if(remainder < 0) remainder += k;

            rem.put(remainder,rem.getOrDefault(remainder,0)+1);
        }


        // System.out.println(rem);

        for(Integer key : rem.keySet()){
            int freq = rem.get(key);

            if(key == 0 || 2 * key == k){
                if(freq % 2 != 0){
                    System.out.println(false);
                    return ;
                }
            }else{

                Integer freqOfCounterPart = rem.get(k-key);

                if(freqOfCounterPart == null || freqOfCounterPart != freq){
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }




    // 1. You are given an array(arr) of integers and a number K.

    // 2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.
    // Constraints

    // 1 <= N <= 10^6

    // 1 <= arr[i] <= 10^4

    // 1 <= K <= 10^4

    // Sample Input

    // 4

    // 9 7 5 3

    // 6
    // Sample Output

    // true


