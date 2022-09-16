private static List<Integer> inOrder(Node node){
        List<Integer> ans = new ArrayList<>();

        while(node != null){

            if(node.left == null){
                // just add to the "ans" and move to the right
                ans.add(node.data);
                node = node.right;
            }else{
                Node nodep1 = node.left;

                // Move to the rightmost node
                while(nodep1.right != null && nodep1.right != node){
                    nodep1 = nodep1.right;
                }

                if(nodep1.right == null){
                    nodep1.right = node;
                    node = node.left;
                }else if(nodep1.right == node){
                    ans.add(node.data); // In preorder this line was in the "null" code, for inorder we just removed it from there and put it here.
                    nodep1.right = null;
                    node = node.right;
                }

            }
        }
        return ans;
    }




    // ROUGH WORK








    