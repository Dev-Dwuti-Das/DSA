class Solution {
    public long minTime(int[] skill, int[] mana) {
     int n = skill.length;
     int m = mana.length;
     int max_sum = 0;
     long[] ls = new long[n+1];
     for(int i = 0; i < m; i++){
        for(int j = 0; j < n; ++j){
            ls[j + 1] = Math.max(ls[j + 1], ls[j]) +(long)skill[j]*mana[i];
        }
        for(int j = n-1; j > 0; j--){
            ls[j] = ls[j+1] - (long)skill[j]*mana[i];
        }
     }
    return ls[n];
    }
}