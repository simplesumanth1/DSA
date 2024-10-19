class Solution {
    public StringBuilder invert(StringBuilder s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')sb.append("0");
            else sb.append("1");
        }
        return sb.reverse();
    }
    public StringBuilder f(int n){
        if(n==1)return new StringBuilder("0");
        StringBuilder temp = f(n-1);
        StringBuilder inversion = invert(temp);
        // StringBuilder reverse = new StringBuilder(String.valueOf(inversion));
        // StringBuilder srev = reverse.reverse();
        return temp.append("1"+inversion);
    }
    public char findKthBit(int n, int k) {
        StringBuilder res = f(n);
        return res.charAt(k-1);
        
    }
}