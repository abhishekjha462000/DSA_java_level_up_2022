    private static Node recursiveCreateTree(Scanner scn){
        int data = scn.nextInt();

        if(data == -1){
            return null;
        }

        Node root = new Node(data);

        root.left = recursiveCreateTree(scn);
        root.right = recursiveCreateTree(scn);

        return root;
    }


    // Method 2
  
    static int idx = 0;

    private static Node recursiveCreateTreeTwo(int[] nums){
        if(nums[idx] == -1)
            return null;

        Node root = new Node(nums[idx]);
        idx++;

        root.left = recursiveCreateTreeTwo(nums);
        idx++;

        root.right = recursiveCreateTreeTwo(nums);

        return root;
    }




    // ROUGH WORK







