public static void basics(){

        /**
         * There are four basic bitwise operations := 
         * 1. Bitwise OR -- 1 dominates
         *      (a) 1 OR 1 == 1
         *      (b) 0 OR 1 == 1
         *      (c) 1 OR 0 == 1
         *      (d) 0 OR 0 == 0    
         *  
         * 2. Bitwise AND -- 0 dominates
         *      (a) 1 AND 1 == 1
         *      (b) 0 AND 1 == 0
         *      (c) 1 AND 0 == 0
         *      (d) 0 AND 0 == 0 
         * 3. Bitwise XOR -- when bits match we get 0
         *      (a) 1 XOR 1 == 0
         *      (b) 0 XOR 1 == 1
         *      (c) 1 XOR 0 == 1
         *      (d) 0 XOR 0 == 0 
         * 4. Bitwise Negation -- flips all the individual bits
         *      (a) ~1 == 0
         *      (b) ~0 == 1
         **/

        int a = 5; // 101
        int b = 3; // 011

        System.out.println("Bitwise OR " + (a | b)); // 111 == 7
        System.out.println("Bitwise AND " + (a & b)); // 001 == 1
        System.out.println("Bitwise XOR " + (a ^ b)); // 110 == 6
        System.out.println("Negation " + (~a)); // -6
    }