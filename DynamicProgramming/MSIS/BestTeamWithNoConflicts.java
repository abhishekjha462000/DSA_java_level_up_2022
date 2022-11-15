// variation of maximum increasing subsequence and greedy
// problem -- https://leetcode.com/problems/best-team-with-no-conflicts/
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        Pair[] pairs = new Pair[scores.length];
        
        for(int i = 0; i < ages.length;i++){
            Pair p = new Pair(scores[i], ages[i]);
            pairs[i] = p;
        }
        
        // System.out.println(Arrays.toString(pairs));
        
        Arrays.sort(pairs);
        
        // System.out.println(Arrays.toString(pairs));
        
        int[] sum = new int[scores.length];
        
        int ans = 0;
        
        for(int i = 0; i < pairs.length;i++){
            sum[i] = pairs[i].score;
            
            for(int j = i-1; j >= 0; j--){
                // decide whether to include the score of the jth player
                
                // This means that player at jth index is younger and better than player at ith index, so nikaalo saale ko
                if(pairs[j].age < pairs[i].age && pairs[j].score > pairs[i].score) continue;
                
                if(pairs[j].age == pairs[i].age && pairs[i].score + sum[j] > sum[i]) {
                    sum[i] = pairs[i].score + sum[j];
                    continue;
                }
                
                // If you are here then that means pairs[j].age < pairs[i].age and pairs[j].score <= pairs[i].score
                sum[i] = Math.max(sum[i], pairs[i].score+sum[j]);
            }
            
            ans = Math.max(ans, sum[i]);
        }
        
        // System.out.println(Arrays.toString(sum));
        
        return ans;
    }
    
    private static class Pair implements Comparable<Pair> {
        int score;
        int age;
        
        Pair(int score, int age){
            this.score = score;
            this.age = age;
        }
        
        Pair(Pair other){
            this.score = other.score;
            this.age = other.age;
        }
        
        Pair(){}
        
        @Override
        public String toString(){
            return score + "@" + age;
        }
        
        @Override
        public int compareTo(Pair other){
            if(this.age != other.age) return this.age - other.age;
            
            return this.score - other.score;
        }
    }
}


// ROUGH WORK





