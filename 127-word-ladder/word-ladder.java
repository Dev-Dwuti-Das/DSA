class pair {
    String st;
    int steps;

    public pair(String st, int steps) {
        this.st = st;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (String st : wordList) {
            set.add(st);
        }
        if (!set.contains(endWord))
            return 0;
        q.offer(new pair(beginWord, 1));

        while (!q.isEmpty()) {
            pair item = q.poll();
            String word = item.st;
            int steps = item.steps;
            char[] word_char = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char original = word_char[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    word_char[i] = ch;
                    String newstring = new String(word_char);
                    if (newstring.equals(endWord)) {
                        return steps + 1;
                    }
                    if (set.contains(newstring)) {
                        q.offer(new pair(newstring, steps + 1));
                        set.remove(newstring);
                    }
                }
                word_char[i] = original;
            }
        }
        return 0;
    }
}