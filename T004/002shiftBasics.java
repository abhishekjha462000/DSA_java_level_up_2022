public static void shifts(){
        /**
         * In JAVA, We have 2 types of shifts. These are signed shifts and unsigned shifts.
         * Signed shifts are of 2 types := signed right shift(>>) and signed left shift(<<).
         * However, There is only one 1 unsigned right shift(>>>).
         **/
}

public static void signedRightShift(){
        /**
         * Let us consider a number N. Then by right shifting it by b bits, 
         * We mean to drop the rightmost b bits and adding b sign bits of this number.
         * 
         * Thus, if N is positive, then we add b 0's on the left and if N is negative, then we add b 1's on the left.
         * 
         * In signed right shift operation, the sign of the number does not change.
         **/

        /**
         * Example := 
         * Consider the number 101. It's binary representation is "00000000 00000000 00000000 01100101".
         * Now when we right shift 101 by 2, we drop the rightmost 2 bits and since 101 is +ve, we add two 0's on the left.
         * Thus 101 >> 2 = 00000000 00000000 00000000 00011001 = (25)₁₀.
         **/
        System.out.println(101 >> 2);


        /**
         * Example := 
         * Slly, Consider the number -101. It's binary representation is "11111111 11111111 11111111 10011011".
         * Now when we right shift -101 by 2, We drop the rightmost 2 bits and since the number is -ve we add 2 1's on the left.
         * Thus, -101 >> 2 = 11111111 11111111 11111111 11100110 = (-26)₁₀.
         **/

        System.out.println(-101 >> 2);


        /**
         * Trivial := 
         * N >> b = (floor(N/(2 ^ b)))₁₀
         **/



}



public static void signedLeftShift(){

        /**
         * Consider the number N. When we left shift it by b bits, then we drop the leftmost b bits and add b 0's on the right.
         **/

        /**
         * No tension of positive and negative in signed left shift.
         **/

        /**
         * 5 = 00000000 00000000 00000000 00000101
         * 5 << 2 = 00000000 00000000 00000000 00010100 = (20)₁₀
         **/


        System.out.println(5 << 2);
}

public static void unsignedRightShift(){
        /**
         * The unsigned right shift operator is denoted by >>>.
         * When we unsign right shift N by b bits, then rightmost b bits are dropped
         * and then b 0's are added at the left irrespective of whether the number is +ve or -ve.
         **/

        System.out.println(5 >>> 2);

}





// ROUGH WORK




