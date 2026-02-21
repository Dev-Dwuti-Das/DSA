class Solution {
    public int countPrimeSetBits(int left, int right) {
        int res_count = 0;
        for(int i = left; i <= right; i++){
            String binary = Integer.toBinaryString(i);
            int temp = 0;
            for(Character c: binary.toCharArray()){
                if(c == '1'){
                    temp++;
                }
            }
            if(isprime(temp)){
                res_count++;
            } 

        }
    return res_count;  
    }
    public static boolean isprime(int n) {
        if (n <= 1) return false;   

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;       
            }
        }
        return true;                
    }
}