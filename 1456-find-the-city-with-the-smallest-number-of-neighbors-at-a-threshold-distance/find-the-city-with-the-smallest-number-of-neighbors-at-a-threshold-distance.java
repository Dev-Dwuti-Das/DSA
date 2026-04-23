class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int len = n;
      int[] count = new int[len];
      int[][] matrix = new int[len][len];
      for(int i = 0; i < len; i++){
         Arrays.fill(matrix[i], (int)1e9);
         matrix[i][i] = 0;
      }
      for(int[] ed : edges){
        int u  = ed[0];
        int v  = ed[1];
        int w  = ed[2];
        matrix[u][v] = w;
        matrix[v][u] = w;
      }  
      for(int via = 0; via < len; via++){
        for(int i = 0; i < len; i++){
          for(int j = 0; j < len; j++){
            if(matrix[i][j] > matrix[i][via] + matrix[via][j]){
              matrix[i][j] = matrix[i][via] + matrix[via][j];
            }
          }
        }
      }

      for(int i = 0; i < len; i++){
        int temp_count = 0;
        for(int j = 0; j < len; j++){
          if(matrix[i][j] <= distanceThreshold){
            temp_count++; 
          }
        count[i] = temp_count;
        }
      }
      int min = count[len-1];
      int res = len-1;
      for(int k = len-1; k >= 0; k--){
        System.out.println(count[k]);
        if(min > count[k]){
          min = count[k];
          res = k;
        }
      } 
      return res;
    }
  }