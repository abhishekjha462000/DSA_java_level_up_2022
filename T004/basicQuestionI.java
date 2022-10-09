    public static boolean isEven(int n){
        /**
         * A number N is even if and only if the rightmost bit of N is 0
         **/

        /**
         * If the rightmost bit of n is 0, then n & 1 = 0
         **/
        
        return (n & 1) == 0;    
    }

    public static int setBits(int n){

        // METHOD 1
        // int count = 0;
        // while(n != 0){
        //     count += (n & 1);
        //     n = n >> 1;
        // }

        // return count;

        // METHOD 2 -- MASK METHOD
        int count = 0;
        for(int pos = 0; pos <= 31; pos++){
            int mask = 1 << pos;

            if((n & mask) != 0) count++;
        }
        return count;
    }

    public static boolean isKthBitSet(int n, int k){
        
        // METHOD 1
        // while(k-- != 0) n = n >> 1;
        // return (n & 1) == 1;

        // METHOD 2
        int mask = 1 << k;

        if((n & mask) != 0){
            // This means that n has 1 at the kth position 
            // Thus k th bit is set
            return true;
        }else{
            return false;
        }
    }

    public static boolean isKthBitUnSet(int n, int k){
        // METHOD 1
        // while(k-- != 0) n = n >> 1;
        // return (n & 1) == 0;

        // METHOD 2
        int mask = 1 << k;

        if((n & mask) == 0){
            // This means that we had 0 at the kth position
            return true;
        }else{
            return false;
        }
    }



    // ROUGH WORK






    