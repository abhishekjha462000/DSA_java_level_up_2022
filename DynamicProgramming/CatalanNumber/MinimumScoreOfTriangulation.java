// problem -- https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
class Solution {
    public int minScoreTriangulation(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        // This is GAP DP
        // Along the row we consider the start index of the array and along the column we consider the end point of the array
        // so dp[i][j] would mean minimum score of triangulation formed by polygon from the index arr[i] to arr[j] (both inclusive)
        for(int gap = 0; gap < arr.length;gap++){
          for(int i = 0, j = gap; j < arr.length;i++,j++){
            // When gap = 0, this means that we have only 1 point and thus no triangulation is possible and thus the minimum score would be 0.
            // When gap = 1, this means that we have only 2 points and thus no triangulation is possible and thus the minimum score would be 0.
            if(gap == 0 || gap == 1){
              dp[i][j] = 0;
            }else if(gap == 2){
              // When gap = 2, this means that we have 3 points and thus we are dealing with a triangle and thus there is no need of triangulation. The minimum score would be the product of the vertices of this triangle.
              dp[i][j] = arr[i] * arr[i+1] *  arr[j];
            }else{
              int min = Integer.MAX_VALUE;

              // we are dealing with a polygon whose side is > 3, thus we need to do some possible triangulation.
              // We keep the base fixed at the arr[i] and arr[j]. The third vertex of the triangle would be chosen by iterating over the remaining vertices of the array
              // This trianguation would divide the polygon into 3 parts, one on the left side of the triangle under consideration and one on the right side of the triangle under consideration.
              // It might be possible that we do not have any polygon on the left side of the triangle and sometimes we might also not have a polygon on the right side of the triangle.
              for(int k = i+1; k < j ;k++){
                int base = arr[i] * arr[j] * arr[k];

                int left = dp[i][k]; // The left part would always be on the base arr[i] and arr[k]
                int right = dp[k][j]; // The right part would always be on the base arr[k] and arr[j]

                min = Math.min(min, base + left + right);
              }

              dp[i][j] = min;
            }
          }
        }


        return dp[0][arr.length-1];
    }
}




// ROUGH WORK







