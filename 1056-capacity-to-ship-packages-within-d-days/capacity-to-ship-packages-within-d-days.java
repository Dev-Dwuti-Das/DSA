class Solution {
    public int shipWithinDays(int[] w, int days) {
        int min = 0, max = 0;
        for (int c : w) {
            min = Math.max(min, c);   
            max += c;
        }

        
        while (min < max) {
            int cap = (max + min) / 2;
            int d = days;
            int i = 0;
            
            while (i < w.length) {
                int amt = 0;
                while (i < w.length && amt + w[i] <= cap ) {
                    amt += w[i];
                    i++;
                }
                d--;
            }
            if (d >= 0) {
                max = cap;
            } else {
                min = cap+1;
            }
        }
        return min;
    }
}