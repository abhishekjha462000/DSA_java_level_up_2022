    private static void kDistanceAway(Node node, int value, int k){
        List<Node> path = NTRP(node, value);
      
        for(int i = 0;i < path.size(); i++){
            int distance = k - i;

            Node blocker = (i == 0) ? (null) : (path.get(i-1));
            printKLevelsDown(path.get(i), blocker, distance);
        }
    }

    private static void printKLevelsDown(Node node, Node blocker, int k){

        if(node == null)
            return;
        
        if(k < 0 || node == blocker)
            return ;

        if(k == 0)
        {
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, blocker, k - 1);
        printKLevelsDown(node.right, blocker, k - 1);
    }

    private static List<Node> NTRP(Node node, int value){
        if(node == null)
            return new ArrayList<>();

        if(node.data == value){
            List<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        
        List<Node> leftAns = NTRP(node.left, value);

        if(leftAns.size() > 0){
            leftAns.add(node);
            return leftAns;
        }

        List<Node> rightAns = NTRP(node.right, value);

        if(rightAns.size() > 0){
            rightAns.add(node);
            return rightAns;
        }
        
        return new ArrayList<>();
    }



    // ROUGH WORK






