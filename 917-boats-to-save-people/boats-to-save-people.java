class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;
        int count = 0;
        while(l <= r){
            int remaining = limit;
            remaining -= people[r];
            r--;
            count++;
            if(l <= r && remaining >= people[l]){
                l++;
            }

        }
       
    return count;
    }
}