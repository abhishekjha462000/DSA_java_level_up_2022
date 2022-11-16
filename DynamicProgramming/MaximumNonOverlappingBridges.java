// problem -- https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/max-non-overlapping-bridges-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

    private static class Bridge implements Comparable<Bridge> {
        int north;
        int south;

        Bridge(){}
        Bridge(int north, int south){
            this.north = north;
            this.south = south;
        }

        @Override
        public String toString(){
            return north + "@" + south;
        }

        @Override
        public int compareTo(Bridge other){
            if(this.north != other.north)
                return this.north - other.north;
            return this.south - other.south;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Bridge[] bridges = new Bridge[n];

        for(int i = 0; i < n;i++){
            int north = scn.nextInt();
            int south = scn.nextInt();

            Bridge b = new Bridge(north, south);
            bridges[i] = b;
        }

        Arrays.sort(bridges);

        int ans = 0;
        int[] dp = new int[n];

        for(int i = 0; i < n;i++){
            dp[i] = 1;

            for(int j = 0; j < i;j++){
                if(bridges[j].south < bridges[i].south && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}




// ROUGH WORK





