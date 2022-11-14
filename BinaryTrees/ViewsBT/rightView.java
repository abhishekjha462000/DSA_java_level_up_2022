/**
 * This is the code for rightView of a binary tree.
 * We just copy pasted the code of leftView and interchanged the insertion order for left and right childs.
 **/
private static List<Integer> rightView(Node root) {
        if(root == null)
            return new ArrayList<>();


        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> hq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        mq.add(root);
        ans.add(root.data);

        // perform the level order on the tree
        while(mq.size() > 0){
            Node removed = mq.remove();

            if(removed.right != null)
                hq.add(removed.right);

            if(removed.left != null)
                hq.add(removed.left);

            if(mq.size() == 0){
                if(hq.size() > 0) ans.add(hq.peek().data); // add the front of the helper queue

                // swap the mq and hq
                Queue<Node> temp = mq;
                mq = hq;
                hq = temp;
            }
        }
        return ans;
    }




    

    // ROUGH WORK










