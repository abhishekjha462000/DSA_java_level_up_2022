// link -- https://practice.geeksforgeeks.org/problems/burning-tree/1
public static int minTime(Node root, int target) 
    { 
        List<Node> path = NTRP(root, target);
        
        // If target is not in the tree, then return Infinity
        if(path.size() == 0){
            return Integer.MAX_VALUE;
        }
        
        int time = height(path.get(0))-1;
        
        for(int i = 1;i < path.size();i++){

            Node myNode = path.get(i);
            Node blocker = path.get(i-1);
            int myTime = i; // Time to reach the "node"
            
            if(blocker == myNode.right){
                myTime += height(myNode.left);
            }
            
            if(blocker == myNode.left){
                myTime += height(myNode.right);
            }

            time = Math.max(time, myTime);

        }
        return time;
        
    }

    /**
     * This function gives "height" in terms of "node"
     **/
    private static int height(Node root){
        if(root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * classic node to root path algorithm
     **/
    private static List<Node> NTRP(Node root, int target){
        if(root == null)
            return new ArrayList<>();
        
        if(root.data == target){
            List<Node> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        
        List<Node> leftAns = NTRP(root.left, target);
        if(leftAns.size() > 0)
        {
            leftAns.add(root);
            return leftAns;
        }
        
        List<Node> rightAns = NTRP(root.right, target);
        if(rightAns.size() > 0){
            rightAns.add(root);
            return rightAns;
        }
        
        return new ArrayList<>();
    }



    // ROUGH WORK








