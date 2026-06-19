class Solution {
    public int largestAltitude(int[] gain) {
      int max = 0;
      int sum = 0;
      List<Integer> temp = new ArrayList<>();
      for(int i = 0; i < gain.length; i++){
        max = Math.max(sum + gain[i], max);
        temp.add(sum);
        sum += gain[i];
      }
      System.out.print(temp);
    return max;
    }
}