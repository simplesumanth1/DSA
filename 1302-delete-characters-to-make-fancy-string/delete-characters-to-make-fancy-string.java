class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb1 = new StringBuilder();
        int n = s.length();
        
        if (n < 3) return s;  
        
        sb1.append(s.charAt(0));
        sb1.append(s.charAt(1));
        
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            }
            sb1.append(s.charAt(i));
        }
        
        return sb1.toString();
    }
}
