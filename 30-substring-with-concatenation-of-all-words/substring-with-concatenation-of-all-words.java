class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        Map<String, Integer> map_w = new HashMap<>();

        for(String word : words){
            map_w.put(word, map_w.getOrDefault(word, 0) + 1);
        }

        int len = words[0].length();
        int total = len * words.length;

        int left = 0;
        int right = 0;

        while(right <= s.length() - total){

            Map<String, Integer> map_s = new HashMap<>();

            while(right - left < total){

                String sub = s.substring(right, right + len);

                map_s.put(sub, map_s.getOrDefault(sub, 0) + 1);

                right += len;
            }

            if(map_s.equals(map_w)){
                res.add(left);
            }

            left++;
            right = left;
        }

        return res;
    }
}