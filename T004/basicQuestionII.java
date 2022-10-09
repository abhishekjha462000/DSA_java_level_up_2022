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


    // ROUGH WORK




    