class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp =  new ArrayList<>();

        String s = ".".repeat(n);
        for(int i = 0; i < n; i++){
            temp.add(s);
        }

        int[] upperdia = new int[2*n-1];
        int[] lowerdia = new int[2*n-1];
        int[] leftRow = new int[n];

        helper(0, res, temp, n, upperdia, lowerdia, leftRow);

        return res;
    }

    public void helper(int i, List<List<String>> res, List<String> temp, int n, int[] upperdia, int[] lowerdia,
            int[] leftrow) {

        if (i == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (leftrow[j] == 0 && lowerdia[i + j] == 0 && upperdia[(n - 1) + (j - i)] == 0) {
                char[] arr = temp.get(j).toCharArray();
                arr[i] = 'Q';
                temp.set(j, new String(arr));
                leftrow[j] = 1;
                lowerdia[i + j] = 1;
                upperdia[(n - 1) + (j - i)] = 1;
                helper(i + 1, res, temp, n, upperdia, lowerdia, leftrow);
                arr[i] = '.';
                temp.set(j, new String(arr));
                leftrow[j] = 0;
                lowerdia[i + j] = 0;
                upperdia[(n - 1) + (j - i)] = 0;
            }else{
                continue;
            }
        }
    }
}