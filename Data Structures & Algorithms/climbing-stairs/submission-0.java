class Solution {
    // n=1 : 1 ; n=2 : 2; n=3 : 3 ; n=4 : 
    //fibonacci sequence: 0,
    public int climbStairs(int n) {
        if(n<=2) return n;
        int prev1 = 2;
        int prev2 = 1;
        int curr = 0;
        for(int i=3; i<=n; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
