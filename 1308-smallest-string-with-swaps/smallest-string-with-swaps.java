class Solution {
    public void f(int node,Set<Integer>set,HashMap<Integer,List<Integer>>adj,List<Character>chars,List<Integer>ind,StringBuilder sb){
        chars.add(sb.charAt(node));
        ind.add(node);
        set.add(node);
        if(adj.containsKey(node))
        for(int adjNode:adj.get(node)){
            if(!set.contains(adjNode))f(adjNode,set,adj,chars,ind,sb);
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer,List<Integer>>adj = new HashMap<>();
        for(List<Integer>edge:pairs){
            int u = edge.get(0);
            int v = edge.get(1);
            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        StringBuilder sb = new StringBuilder(s);
        Set<Integer>vis = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(!vis.contains(i)){
                List<Character>chars = new ArrayList<>();
                List<Integer>ind = new ArrayList<>();
                f(i,vis,adj,chars,ind, sb);
                Collections.sort(chars);
                Collections.sort(ind);
                for(int j=0;j<chars.size();j++){
                    sb.setCharAt(ind.get(j),chars.get(j));
                }
            }
        }
        return sb.toString();
        
    }
}