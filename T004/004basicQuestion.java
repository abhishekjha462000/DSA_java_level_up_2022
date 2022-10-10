    public static int firstSetBitFromRight(int n){

        int pos = 0;
        while(pos <= 31){
            int mask = (1 << pos);
            if((n & mask) != 0) return pos;
            pos++;
        }

        return 32; // This means that no bit is set
    }

    public static int firstBitSetFromLeft(int n){
        int pos = 31;

        while(pos >= 0){
            int mask = (1 << pos);
            if((n & mask) != 0) return pos;
            pos--;
        }

        return 32; // This means that no bit is set
    }

    public static int flipsRequiredToMakeNumberEqual(int n1, int n2){
        int count = 0;

        for(int pos = 0; pos <= 31; pos++){
            int mask = 1 << pos;

            // find the digit of n1 at this pos
            int d1 = (n1 & mask) == 0 ? 0 : 1;

            // find the digit of n2 at this pos
            int d2 = (n2 & mask) == 0 ? 0 : 1;


            if(d1 != d2) count++; // Since digits are not same, we need to flip one bit from one of them.
        }
        return count;
    }


    // ROUGH WORK




