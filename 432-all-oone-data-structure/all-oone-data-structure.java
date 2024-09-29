import java.util.*;

class AllOne {
    static class Pair implements Comparable<Pair> {
        String s;
        int freq;

        public Pair(String s, int freq) {
            this.s = s;
            this.freq = freq;
        }

        public int compareTo(Pair o) {
            if (this.freq != o.freq) {
                return this.freq - o.freq;
            }
            return this.s.compareTo(o.s);
        }

        public String getKey() {
            return this.s;
        }
    }

    HashMap<String, Integer> map;
    TreeSet<Pair> set;

    public AllOne() {
        this.map = new HashMap<>();
        this.set = new TreeSet<>();
    }

    public void inc(String key) {
        int freq = map.getOrDefault(key, 0);
        if (freq > 0) {
            set.remove(new Pair(key, freq)); // Remove the old pair
        }
        map.put(key, freq + 1); // Update the frequency
        set.add(new Pair(key, freq + 1)); // Add the new pair with updated frequency
    }

    public void dec(String key) {
        if (!map.containsKey(key)) return;

        int freq = map.get(key);
        set.remove(new Pair(key, freq)); // Remove the current pair

        if (freq == 1) {
            map.remove(key); // Remove the key entirely if freq becomes 0
        } else {
            map.put(key, freq - 1); // Decrease the frequency
            set.add(new Pair(key, freq - 1)); // Add the updated pair
        }
    }

    public String getMaxKey() {
        if (set.isEmpty()) return "";
        return set.last().getKey(); // Get the key with max frequency
    }

    public String getMinKey() {
        if (set.isEmpty()) return "";
        return set.first().getKey(); // Get the key with min frequency
    }
}
