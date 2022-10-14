private static boolean isCyclic(List<Edge>[] graph){
      int nvtces = graph.length;

      boolean[] vis = new boolean[nvtces]; // common visited array

      for(int src = 0; src < nvtces;src++){
         if(!vis[src]){
            // run bfs on it and see if we find a cycle
            Queue<Integer> queue = new ArrayDeque<>();

            queue.add(src);

            while(!queue.isEmpty()){
               int removed = queue.remove(); // remove

               if(!vis[removed]){

                  vis[removed] = true; // mark*

                  // no work to do

                  for(Edge e : graph[removed]){
                     int nbr = e.nbr;

                     if(!vis[nbr]){ // add*
                        queue.add(nbr);
                     }
                  }else{
                     // a vertex has been visited twice from src
                     // that means we have a cycle
                     return true;
                  }
               }
            }
         }

      return false;
}



// ROUGH WORK








