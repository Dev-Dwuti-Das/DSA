class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    String st = ".".repeat(n);
    for (int i = 0; i < n; i++) {
      temp.add(st);
    }
    System.out.print(temp);

    int[] lowerdia = new int[2 * n + 1];
    int[] upperdia = new int[2 * n + 1];
    int[] col = new int[2 * n + 1];
    helper(0, n, upperdia, lowerdia, col, res,  temp);

    return res;
  }

  public void helper(int i, int n, int[] upper, int[] lower, int[] col, List<List<String>> res, List<String> temp){
      if(i == n){
        res.add(new ArrayList<>(temp));
        return;
      } 
      for(int j = 0; j < n; j++){ //rows
      char[] arry = temp.get(j).toCharArray();
        if(col[j] == 0 && lower[i+j] == 0 && upper[(j-i)+(n-1)] == 0){
          arry[i] = 'Q';
          temp.set(j, new String(arry));
          lower[i+j] = 1;
          col[j] = 1;
          upper[(j-i)+(n-1)] = 1;
          helper(i+1, n, upper, lower, col, res, temp);
          arry[i] = '.';
          temp.set(j, new String(arry));
          lower[i+j] = 0;
          col[j] = 0;
          upper[(j-i)+(n-1)] = 0;
        }
      }
    }
}