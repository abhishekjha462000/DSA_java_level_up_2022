// 0 means that there is a camera at that node
// 1 means that the node is covered
// -1 means that the node is not covered
private static int minCameras(Node root){
        int[] ans = new int[1]; // This will store the number of cameras

        int status = helper(root, ans);

        /**
         * This extra condition is for the root node. If the root node is uncovered then we also need to place a camera at the root node as well.
         **/
        if(status == -1)
            ans[0]++;
        return ans[0];
    }

    private static int helper(Node node, int[] ans){
        if(node == null)
            return 1; // Obvious

        int leftStatus = helper(node.left, ans);
        int rightStatus = helper(node.right, ans);

        if(leftStatus == -1 || rightStatus == -1)
        {
            // If the leftStatus is -1 or rightStatus is -1, then that means we need to place a camera at the "node".
            ans[0]++;
            return 0; // Install the camera at the node
        }

        if(leftStatus == 0 || rightStatus == 0) // If either of the left or right node has a camera then our node is covered
            return 1; // Since the node is covered so return 1

        return -1;
    }



    // ROUGH WORK





    