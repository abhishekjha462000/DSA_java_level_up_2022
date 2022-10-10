    public static void allRepeatingExceptTwo(int[] nums){

        int xor = 0 ; // This will be the xor of those two unique numbers

        for(int num : nums){
            xor ^= num;
        }

        // Now let those unique numbers be n1 and n2
        int n1 = 0;
        int n2 = 0;
        int mask = (xor & -xor); // prepare the RSB mask of the xor

        // Let us say that we have 1 at the position j in the RSB mask of the xor.
        // Then at the jth position of n1 and n2 we would have different bits(Since if we had same bits then at the jth pos of the mask we would have got 0 which is a contradiction)


        // The idea is to classify all the numbers into two sets -- one which have 0 at the jth position and one which have 1 at the jth position.
        // Then we will take the xor of both these sets individually and we will get n1 and n2
        for(int num : nums){
            if((num & mask) == 0){
                // This is the set of numbers which have 0 at the jth position
                n1 ^= num;
            }else{
                // This is the set of numbers which have 1 at the jth position
                // In this case (num & mask != 0)
                n2 ^= num;
            }
        }

        System.out.println(n1 + " " + n2);
    }




    // ROUGH WORK





