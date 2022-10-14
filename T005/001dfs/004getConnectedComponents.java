   private static List<List<Integer>> cc(List<Edge>[] graph){
      List<List<Integer>> ans = new ArrayList<>();

      int nvtces = graph.length;

      // We have made a common visited array
      boolean[] vis = new boolean[nvtces];
      /**
       * The main idea is that I will iterate over each vertex of the graph and call the dfs helper method.
       * The dfs method will collect all the vertices in a connected component and mark them as true so that the next time 
       * we wont be able to call the dfs method on the vertices in the same component.
       **/
      for(int i = 0;i < nvtces;i++){
         if(!vis[i]){

            List<Integer> temp = new ArrayList<>(); // collects all the vertices in the same component
            dfs(i, graph, temp, vis);
            ans.add(temp);
         }
      }
      return ans;
   }

   /**
    * Will collect all the vertices in the same component in the temp and mark all the visited vertices as true
    **/
   private static void dfs(int src, List<Edge>[] graph, List<Integer> temp, boolean[] vis){
         vis[src] = true;
         temp.add(src);

         for(Edge e : graph[src]){
            int nbr = e.nbr;
            if(!vis[nbr]){
               dfs(nbr, graph, temp, vis);
            }
         }
   }



   // ROUGH WORK




   