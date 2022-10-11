    // This is incomplete

    private static boolean isCyclic(List<Edge>[] graph){
        /**
         * I will run bfs from 0 as the starting point and see if I have two distinct paths to reach a vertex.
         * If that is the case then there are two ways to reach that vertex from the source and thus it forms a cycle.
         **/

        /**
         * To prove : If a vertex has already been marked as true and then the same vertex comes so cycle exists?
         * But then how do you know that when we will add the vertex the second time it would have been marked as true.
         * In other words, What I am trying to say is that if a vertex has been repeated then it would be found at different levels.
         * That means 
         **/

        int src = 0;
        Queue<Integer> mq = new ArrayDeque<>();
        boolean[] vis = new boolean[graph.length];


        mq.add(src);

        while(!mq.isEmpty()){
            int removed = mq.remove();

            if(!vis[removed]){
                vis[removed] = true;
                for(Edge e : graph[removed]){
                    mq.add(e.nbr);
                }
            }else{
                // If the removed is being 
                return true;
            }
        }

        return false;

    }



    // ROUGH WORK










    // CORRECT CODE


    private static boolean isCyclic(List<Edge>[] graph){
      int src = 0;
      boolean[] vis =  new boolean[graph.length];

      while(src < graph.length){

         if(!vis[src]){
               Queue<Integer> mq = new ArrayDeque<>();

         mq.add(src);

         while(!mq.isEmpty()){
            int removed = mq.remove();

            if(!vis[removed]){
               vis[removed] = true;
               // System.out.println(Arrays.toString(vis));
               for(Edge e: graph[removed]){
                  int nbr = e.nbr;
                  
                  if(!vis[nbr])
                     mq.add(nbr);
               }
            }else{
               return true;
            }
         }
         }
         src++;
      }
      return false;
   }