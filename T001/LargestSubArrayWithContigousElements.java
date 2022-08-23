private static void run(int[] nums){

        Set<Integer> set = new HashSet<>();

        int maxLength = 1;

        for(int i = 0;i<nums.length;i++){

            set = new HashSet<>();
            set.add(nums[i]);
            int min = nums[i];
            int max = nums[i];
            
            for(int j = i+1;j <nums.length;j++){
                set.add(nums[j]);

                if(set.size() != j-i+1)
                    break;

                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);

                if(max-min == j-i){
                    maxLength = Math.max(maxLength,j-i+1);
                }

            }


        }

        System.out.println(maxLength);

    }




    // 1. You are given an array(arr) of integers. Values may be duplicated.

    // 2. You have to find the length of the largest subarray with contiguous elements.
    // Note -> The contiguous elements can be in any order(not necessarily in increasing order).
    // Constraints

    // 1 <= N <= 10^4

    // 1 <= arr[i] <= 10^3




    // Sample Input

    // 3
    // 10 12 11
    
    // Sample Output

    // 3

