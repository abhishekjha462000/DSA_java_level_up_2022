private static void dfsFromPoint(int src, List<Edge>[] graph){
        int nvtces = graph.length;
        boolean[] vis = new boolean[nvtces];

        dfsFromPointHelper(src, graph, vis, "");
    }

    private static void dfsFromPointHelper(int src, List<Edge>[] graph, boolean[] vis, String psf){
        
        vis[src] = true;
        psf += src + " ";

        boolean flag = true;
        for(Edge e : graph[src]){
            int nbr = e.nbr;

            if(!vis[nbr]){
                flag = false;
                dfsFromPointHelper(nbr, graph, vis, psf);
            }
        }

        if(flag){
            /**
             * if flag is true, this means that we are not able to move any further as all the vertices has been marked. Thus, We have completed a tour of the graph.
             **/

            System.out.println(psf);
        }
    }
    
/**

7
8
0 1
1 2
2 3
0 3
3 4
4 5
5 6
4 6

0 -- 1, 3
1 -- 0, 2
2 -- 1, 3
3 -- 2, 0, 4
4 -- 3, 5, 6
5 -- 4, 6
6 -- 5, 4
0----3-----4
|    |     |\
|    |     | \
1----2     5--6

**/

// Output


// 1 0 3 2 
// 1 0 3 4 5 6 // But I want only this, How do I do this???????











//////////////////////////////////////////// I TRIED THIS ////////////////////////////////////////////////

    private static void dfsFromPoint(int src, List<Edge>[] graph){
        int nvtces = graph.length;
        boolean[] vis = new boolean[nvtces];
        String[] ans = new String[1];
        ans[0] = "";
        dfsFromPointHelper(src, graph, vis, ans);
        System.out.println(ans[0]);
    }

    private static void dfsFromPointHelper(int src, List<Edge>[] graph, boolean[] vis, String[] ans){
        
        vis[src] = true;
        ans[0]  += src + " ";

        for(Edge e : graph[src]){
            int nbr = e.nbr;

            if(!vis[nbr]){
                dfsFromPointHelper(nbr, graph, vis, ans);
            }
        }
    }


    // This works but that not a path, However give me the vertices in the graph in a connected component
    // 1 0 3 2 4 5 6 
