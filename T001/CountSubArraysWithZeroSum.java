    public static void main(String[] args) throws IOException{

        // initializeIO();
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] nums = new int[n];

        for(int i = 0;i < n ;i++){
            nums[i] = scn.nextInt();
        }

        run(nums);
    }

    private static void run(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();

        /**
         * The reason for putting this is empty subarray
         **/
        map.put(0,1);

        int count = 0;

        int sum = 0;

        for(int value : nums){
            sum += value;
            Integer freq = map.get(sum);


            if(freq != null){
                /**
                 * The sum is already present
                 **/
                count += freq;
                map.put(sum,freq+1);

            }else{
                /**
                 * This means that sum has ocuured for the first time, so store it in hashmap
                 **/
                map.put(sum,1);
            }
        }

        System.out.println(count);
    }