import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Main{
    
    private static class Edge{
        int src;
        int nbr;

        Edge(){}
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
        Edge(Edge other){
            this.src = other.src;
            this.nbr = other.nbr;
        }

        @Override
        public String toString(){
            return src + "->" + nbr;
        }
    }
    
    public static void main(String[] args) throws IOException{
        // initializeIO();
        Scanner scn = new Scanner(System.in);

        int nvtces = scn.nextInt();
        int nedges = scn.nextInt();

        List<Edge>[] graph = new ArrayList[nvtces];

        for(int i = 0;i < nvtces;i++){
            graph[i] = new ArrayList<>();
        }

        while(nedges-- != 0){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        boolean[] vis = new boolean[nvtces]; // common visited array

        List<Integer> sizes = new ArrayList<>(); // This will store the sizes of all the connected components
        for(int i = 0; i < nvtces;i++){
            if(!vis[i]){
                dfs(i, graph, vis);

                sizes.add(temp);
                temp = 0;
            }
        }

        int count = 0 ;

        for(int i = 0;i < sizes.size();i++){
            for(int j = i+1;j < sizes.size();j++){
                count += sizes.get(i) * sizes.get(j);
            }
        }
        
        return count;
    }

    private static int temp = 0; // stores the number of vertices in a single dfs

    private static void dfs(int src, List<Edge>[] graph, boolean[] vis){
        vis[src] = true;
        temp++;

        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                dfs(e.nbr, graph, vis);
            }
        }
    }

    private static void initializeIO(){
        try 
        {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
}