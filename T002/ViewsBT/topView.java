class Solution{
    static class Pair{
        Node node;
        int level;
        
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    public static List<Integer> topView(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        Queue<Pair> mq = new ArrayDeque<>();
        Queue<Pair> hq = new ArrayDeque<>();
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        mq.add(new Pair(root, 0));
        
        while(mq.size() != 0){
            Pair removed = mq.remove();
            int level = removed.level;
            
            if(hm.containsKey(level) == false){
                hm.put(level, removed.node.data);
            }
            
            if(removed.node.left != null)
                hq.add(new Pair(removed.node.left, level - 1));
            if(removed.node.right != null)
                hq.add(new Pair(removed.node.right, level + 1));
                
            if(mq.size() == 0){
                Queue<Pair> temp = mq;
                mq = hq;
                hq = temp;
            }
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int key : hm.keySet()){
            max = Math.max(max, key);
            min = Math.min(min, key);
        }
        
        for(int i = min; i <= max; i++){
            ans.add(hm.get(i));
        }
        return ans;
    }
}
    
    

    // ROUGH WORK






