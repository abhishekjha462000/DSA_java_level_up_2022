// problem -- https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/russian-doll-envelopes-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

    private static class RussianDoll implements Comparable<RussianDoll> {
        int width;
        int height;

        RussianDoll(){}
        RussianDoll(int width, int height){
            this.width = width;
            this.height = height;
        }

        RussianDoll(RussianDoll other){
            this.width = other.width;
            this.height = other.height;
        }

        @Override
        public String toString(){
            return width + "@" + height;
        }

        @Override
        public int compareTo(RussianDoll other){
            if(this.width != other.width)
                return this.width - other.width;
            return this.height - other.height;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        RussianDoll[] dolls = new RussianDoll[n];

        for(int i = 0; i < n;i++){
            int width = scn.nextInt();
            int height = scn.nextInt();

            dolls[i] = new RussianDoll(width, height);
        }

        Arrays.sort(dolls);

        int ans = 0 ;

        int[] dp = new int[n];

        for(int i = 0; i < dolls.length;i++){
            dp[i] = 1;

            for(int j = 0; j < i;j++){
                if(dolls[j].width < dolls[i].width && dolls[j].height < dolls[i].height && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}


// ROUGH WORK




