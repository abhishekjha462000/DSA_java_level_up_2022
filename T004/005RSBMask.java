        public static int rightSetBitMask(int n){
                // The right set bit mask of 101000 would be 001000
                int mask = (n & (-n));
                return mask;

        }

        // To convert the returned number into binary string we can use Integer.toBinaryString() method