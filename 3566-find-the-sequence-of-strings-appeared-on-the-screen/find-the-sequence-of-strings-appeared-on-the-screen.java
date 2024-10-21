class Solution {
    public List<String> stringSequence(String target) {
        int n = target.length();
        int i=0;
        List<String>ds = new ArrayList<>();
        StringBuilder curr = new StringBuilder("a");
        while(i<n){
            if(curr.toString().equals(target.substring(0,i+1))){
                ds.add(curr.toString());
                String curr2 = ds.get(ds.size()-1);
                StringBuilder c2 = new StringBuilder(curr2);
                curr = c2;
               curr= curr.append("a");
                i++;
                
            }else{
                ds.add(curr.toString());
                String last = ds.get(ds.size()-1);
                char l = last.charAt(last.length()-1);
                if(l=='z'){
                    l='a';
                }else{
                    l=(char)(l+1);
                }
                curr.setCharAt(i,l);

            }




        }
        return ds;
    }
}