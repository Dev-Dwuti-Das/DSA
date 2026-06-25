class pair {
  String st;
  int level;

  pair(String st, int lvl) {
    this.st = st;
    this.level = lvl;
  }
}

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>();
    Queue<pair> q = new LinkedList<>();
    for (String st : wordList) {
      set.add(st);
    }
    q.offer(new pair(beginWord, 1));

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        pair item = q.poll();
        String word = item.st;
        int lvl = item.level;
        if (word.equals(endWord))
          return lvl;

        for (int j = 0; j < word.length(); j++) {
          char[] original = word.toCharArray();
          for (char ch = 'a'; ch <= 'z'; ch++) {
            original[j] = ch;
            String newstring = new String(original);
            if (set.contains(newstring)) {
              q.offer(new pair(newstring, lvl + 1));
              set.remove(newstring);
            }
          }

        }
      }
    }
    return 0;
  }
}