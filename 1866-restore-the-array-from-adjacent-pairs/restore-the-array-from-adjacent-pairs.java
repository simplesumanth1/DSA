class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,List<Integer>>adj = new HashMap<>();
        HashMap<Integer,Integer>freq = new HashMap<>();

        for(int[]edge:adjacentPairs){
            int u = edge[0];
            int v = edge[1];
            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
            freq.put(u,freq.getOrDefault(u,0)+1);
            freq.put(v,freq.getOrDefault(v,0)+1);
        }
        int startNode = -1;
        for(Map.Entry<Integer,Integer>m:freq.entrySet()){
            if(m.getValue()==1){
                startNode = m.getKey();
                break;
            }
        }
        Set<Integer>vis = new HashSet<>();
        List<Integer>ds = new ArrayList<>();
        f(startNode,vis,adj,ds);
        int[]res = new int[freq.size()];
        for(int i=0;i<res.length;i++){
            res[i]=ds.get(i);
        }
        return res;

        
    }
    public void f(int startNode,Set<Integer>vis,HashMap<Integer,List<Integer>>adj,List<Integer>ds){
        vis.add(startNode);
        for(int adjNode:adj.get(startNode)){
            if(!vis.contains(adjNode)){
                f(adjNode,vis,adj,ds);
            }
        }
        ds.add(startNode);
    }
}