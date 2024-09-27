class Solution {
    public int[] nextGreaterElements(int[] a) {
         int n=a.length;
        int[]ans = new int[n];

        Stack<Integer>stack = new Stack<>();

        for(int i=(2*n);i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=a[i%n]){
            stack.pop();
            }

            if(!stack.isEmpty()){
                ans[i%n]=stack.peek();

            }
            else{
                ans[i%n] = -1;
            }
            stack.push(a[i%n]);
        }
        return ans;
        
    }
}