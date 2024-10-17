class Solution {
    public static void dfsSuspecious(int node,List<List<Integer>>adj,Set<Integer>suspecious){
        suspecious.add(node);
        for(int adjNode:adj.get(node)){
            if(!suspecious.contains(adjNode)){
                dfsSuspecious(adjNode,adj,suspecious);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[]edge:invocations){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            // adj.get(v).add(u);
        }
        Set<Integer>suspecious =  new HashSet<>();
        Set<Integer>nonSuspecious = new HashSet<>();
        
            
        dfsSuspecious(k,adj,suspecious);
        for(int[]edge:invocations){
            int u = edge[0];
            int v = edge[1];
            // adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i=0;i<n;i++){
            if(!suspecious.contains(i)){
                dfs(i,adj,suspecious,nonSuspecious);
            }
        }
        List<Integer>res = new ArrayList<>();
        for(int ele:nonSuspecious)res.add(ele);
        return res;
            
        
        
    }
    public static void dfs(int node,List<List<Integer>>adj,Set<Integer>suspecious,Set<Integer>nonSuspecious){
        nonSuspecious.add(node);
        for(int adjNode:adj.get(node)){
            if(!nonSuspecious.contains(adjNode)){
                if(suspecious.contains(adjNode))suspecious.remove(adjNode);
                dfs(adjNode,adj,suspecious,nonSuspecious);
            }
        }
    }
}