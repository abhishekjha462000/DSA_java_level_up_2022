    public static void main(String[] args) throws IOException{

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] nums = new int[n];

        for(int i = 0;i < n ;i++){
            nums[i] = scn.nextInt();
        }

        run(nums);
    }

    private static void run(int[] nums){
        int n = nums.length;

        int[] prefixSumArray = new int[n+1];

        /**
         * This is not the standard way to create prefix sum array
         **/
        
        prefixSumArray[0] = 0;

        for(int i = 1; i <= n;i++){
            prefixSumArray[i] = nums[i-1]+prefixSumArray[i-1];
        }

        HashMap<Integer,Integer> sumFreq = new HashMap<>();

        int count = 0;

        for(int i = 0;i < prefixSumArray.length;i++){
            int value = prefixSumArray[i];

            if(sumFreq.containsKey(value)){
                int freq = sumFreq.get(value);
                count += freq;

                sumFreq.put(value,freq+1);
            }else{
                sumFreq.put(value,1);
            }
        }

        System.out.println(count);
    }