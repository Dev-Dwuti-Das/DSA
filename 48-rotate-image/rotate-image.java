class Solution {
  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i >= j)
          continue;
        swap(i, j, matrix);
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      reverse(matrix[i]);
    }
  }

  public void swap(int i, int j, int[][] matrix) {
    int temp = matrix[j][i];
    matrix[j][i] = matrix[i][j];
    matrix[i][j] = temp;
  }

  public void reverse(int[] row){
    int i = 0;
    int j = row.length-1;
    while(i < j){
      int temp = row[i];
      row[i] = row[j];
      row[j] = temp;
      i++;
      j--;
    }
  }
}