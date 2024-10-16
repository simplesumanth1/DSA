class Solution {
    static class Pair implements Comparable<Pair>{
        char c;
        int freq;
        public Pair(char c,int freq){
            this.c = c;
            this.freq = freq;
        }
        public int compareTo(Pair o){
           return o.freq - this.freq;
            // return this.c - o.c;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        if(a>0)
        pq.offer(new Pair('a',a));
        if(b>0)
        pq.offer(new Pair('b',b));
        if(c>0)
        pq.offer(new Pair('c',c));
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
           Pair top = pq.poll();
           char ch = top.c;
           int freq = top.freq;
           if(res.length()>=2 && res.charAt(res.length()-1)==ch && res.charAt(res.length()-2)==ch){
            if(pq.isEmpty())return res.toString();
            Pair stop = pq.poll();
            char sc =stop.c;
            int sf = stop.freq;
            res.append(sc);
            if(sf>1)pq.offer(new Pair(sc,sf-1));
            pq.offer(top);
           }else{
            res.append(ch);
            if(freq>1){
                pq.offer(new Pair(ch,freq-1));
            }
           }
          
        }
        return res.toString();

        
    }
}