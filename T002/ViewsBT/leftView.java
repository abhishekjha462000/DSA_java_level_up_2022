
// link -- https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
private static List<Integer> leftView(Node root){
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

            if(removed.left != null)
                hq.add(removed.left);

            if(removed.right != null)
                hq.add(removed.right);

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






