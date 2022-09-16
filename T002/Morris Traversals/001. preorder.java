private static List<Integer> preOrder(Node node){
        List<Integer> ans = new ArrayList<>();

        while(node != null){
            /**
             * If the left of the node is null, then that means this node cannot be visited twice(why?)
             * So we just add it to the "ans" and move to the right of this node
             **/

            if(node.left == null){
                // just add to the "ans" and move to the right
                ans.add(node.data);
                node = node.right;
            }else{
                // Here "node" has non-null left.
                /**
                 * Now here we can have two cases
                 * We go to the rightmost node of the left subtree and check if it is already connected to the node or not.
                 * If it is, then we need to disconnect it and move to the right subtree.
                 * If it is not connected already, then we need to connect it to the "node" and then we move to the left of the "node"
                 **/

                Node nodep1 = node.left; // This is the left of the "node"

                // Move to the rightmost node
                while(nodep1.right != null && nodep1.right != node){
                    nodep1 = nodep1.right;
                }

                if(nodep1.right == null){
                    // This means that we are visiting "node" for the first time
                    nodep1.right = node;
                    node = node.left;
                }else if(nodep1.right == node){
                    ans.add(node.data);
                    nodep1.right = null; // disconnect
                    node = node.right; // move to the right
                }

            }
        }
        return ans;
    }



    // ROUGH WORK

    /**
     * If you want reverse preorder just flip left and right in the above code.
     * 
     * That is replace "left" with "right" and "right" with "left".
     **/








    