    // kernighan's algorithm

    public static int countSetBits(int n){
        int count = 0;

        while(n != 0){
            int mask = (n & -n); // This is the right set bit mask
            count++;
            n -= mask;
        }
        return count;
    }



    // ROUGH WORK



    