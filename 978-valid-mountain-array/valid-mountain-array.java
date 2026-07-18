class Solution {
    public boolean validMountainArray(int[] arr) {
    int i = 0;
    int n = arr.length;

    while(i + 1 < n && arr[i] < arr[i+1]){
      i++;
    }

    if(i == 0 || i == arr.length - 1) return false;
    System.out.print("peak" + arr[i]);

    while(i + 1 < n && arr[i] > arr[i+1]){
      i++;
    }

    return i == n-1;
    }
}