    public static void main(String[] args) throws IOException{

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] nums = new int[n];

        for(int i = 0; i < n;i++){
            nums[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        run(nums,k);

    }

    private static void run(int[] nums,int k){
        int len = nums.length;

        if(len % 2 == 1){
            System.out.println(false);
            return ;
        }

        /**
         * This hashmap would store the remainder of the elements of the array and their frequency
         **/
        HashMap<Integer,Integer> rem = new HashMap<>();

        for(int i : nums){
            int remainder = i % k;

            if(remainder < 0) remainder += k;

            rem.put(remainder,rem.getOrDefault(remainder,0)+1);
        }


        System.out.println(rem);

        for(Integer key : rem.keySet()){
            int freq = rem.get(key);

            if(key == 0 || 2 * key == k){
                if(freq % 2 != 0){
                    System.out.println(false);
                    return ;
                }
            }else{

                Integer freqOfCounterPart = rem.get(k-key);

                if(freqOfCounterPart == null || freqOfCounterPart != freq){
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }