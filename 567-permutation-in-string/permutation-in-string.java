class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character,Integer>s1Freq =  new HashMap<>();
        HashMap<Character,Integer>s2Freq = new HashMap<>();
        for(char ch : s1.toCharArray())
         s1Freq.put(ch,s1Freq.getOrDefault(ch,0)+1);
        for(int i=0;i<s1.length();i++){
            char ch = s2.charAt(i);
            s2Freq.put(ch,s2Freq.getOrDefault(ch,0)+1);
        }
        if(s1Freq.equals(s2Freq))return true;
        for(int i = s1.length();i<s2.length();i++){
            char removed = s2.charAt(i-s1.length());
            s2Freq.put(removed,s2Freq.get(removed)-1);
            if(s2Freq.get(removed)==0)s2Freq.remove(removed);
            char toAdded = s2.charAt(i);
            s2Freq.put(toAdded,s2Freq.getOrDefault(toAdded,0)+1);
            if(s1Freq.equals(s2Freq))return true;
        }
        return false;
        
    }
}