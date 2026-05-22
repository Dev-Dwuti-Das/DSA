class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     int row = 0;
     int col = matrix[0].length-1;
     boolean flag = true;
     while(row < matrix.length && col >= 0){
      if(matrix[row][col] == target) return true;
      if(matrix[row][col] > target){
        col--;
      }else{
        row++;
      }
     }
    return false;
    }
}