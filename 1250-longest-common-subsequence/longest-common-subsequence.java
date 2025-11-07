class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1 = text1.length();
        int idx2 = text2.length();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for(int i = 0; i < text1.length(); i++){
            dp.add(new ArrayList<>());
            for(int j = 0 ; j < text2.length(); j++){
                dp.get(i).add(-1);
            }
        }
        return customLcs(idx1-1, idx2-1, text1, text2 ,dp);
        
    }

    public int customLcs(int id1, int id2, String s1, String s2, ArrayList<ArrayList<Integer>> dp){
        int count;
        if(id1 < 0 || id2 < 0){
            return 0;
        }

        if(dp.get(id1).get(id2) != -1){
            return dp.get(id1).get(id2);
        }

        if(s1.charAt(id1) == s2.charAt(id2)){
            int val =  1 + customLcs(id1-1, id2-1,s1, s2,dp);
            dp.get(id1).set(id2,val);
            return val;
        }
        int val = Math.max(customLcs(id1, id2-1, s1, s2, dp),customLcs(id1-1, id2, s1, s2, dp)); 
        dp.get(id1).set(id2, val);
        return val;  
    }
}