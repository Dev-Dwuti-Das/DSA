class Solution {
    int[] par;
    Map<String, Integer> map = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        int n = acc.size();
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < acc.get(i).size(); j++) {
                String email = acc.get(i).get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    union(i, map.get(email));
                }
            }
        }
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String key = it.getKey();
            int value = it.getValue();
            int ultimate_par = find(value);
            mergedMail[ultimate_par].add(key); 
        }
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
          if(mergedMail[i].isEmpty()) continue;
          Collections.sort(mergedMail[i]);
          List<String> temp = new ArrayList<>();
          temp.add(acc.get(i).get(0));
          temp.addAll(mergedMail[i]);
          res.add(temp);
        }
        return res;
    }

    public int find(int u) {
        if (par[u] == u) return u;
        par[u] = find(par[u]);
        return par[u];
    }

    public void union(int u, int v) {
        par[find(u)] = find(v); 
    }
}