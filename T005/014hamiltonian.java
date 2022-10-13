class Hamiltonian{

   private static int trues = 0; // count how many vertices have been visited

   // Would print the hamitonian paths and cycles starting from a source vertex
   private static void hamiltonian(int src, List<Edge>[] graph){
      int nvtces = graph.length;
      boolean[] vis = new boolean[nvtces];

      hamiltonianHelper(src, graph, vis, "");
   }

   private static void hamiltonianHelper(int src, List<Edge>[] graph, boolean[] vis, String psf){
      psf += src + "";

      vis[src] = true;
      trues++; // src has been visited, so increased the trues.


      /**
       * If all the vertices have been visited, then trues = graph.length
       **/

      // Base case
      if(trues == graph.length){
         /**
          * Now we need to print the path that we have collected so far
          **/

         int start = Integer.parseInt(psf.charAt(0) + ""); // shows the start of the hamitonian path/cycle
         int end  = Integer.parseInt(psf.charAt(psf.length()-1) + ""); // end == src (just an observation)


         /**
          * Now we need to check if there is an edge joining start and end.
          * If there exists such an edge, then we get a hamiltonian cycle.
          * Otherwise, we get a hamiltonian path
          **/
         boolean isHamCycle = false;
         for(Edge e : graph[start]){
            int nbr = e.nbr;

            if(nbr == end) isHamCycle = true;
         }

         if(isHamCycle){
            // we denote a Hamiltonian cycle by terminating it with a * and a Hamiltonian path by terminating it with a .
            System.out.println(psf + "*");
         }else{
            System.out.println(psf + ".");
         }

         vis[src] = false; // since we also marked the end point, thus we should also unmark it
         trues--; // since we unmarked a point, so decrease the number of trues

      }

      for(Edge e : graph[src]){
         int nbr = e.nbr;

         if(!vis[nbr]){
            hamiltonianHelper(nbr, graph, vis, psf);
         }
      }

      vis[src] = false; // unmark the src as we can also have other H.cycles and H.paths which have src in them
      trues--; // since we unmark the src, we should also decrease the trues
   }

}