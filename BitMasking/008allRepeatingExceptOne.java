public static int allRepeatingExceptOne(int[] nums){
        /**
         * We have been given an array in which every number repeats itself except one.
         * We need to find that unique number
         **/

        /**
         * Concepts used := 
         * 1. n ^ n = 0
         * 2. n ^ 0 = n
         **/

        int ans = 0;
        for(int num : nums) ans ^= num;

        return ans;
    }


    // ROUGH WORK




    