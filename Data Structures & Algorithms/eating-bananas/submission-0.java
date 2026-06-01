class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h<piles.length) return -1;//impossible to finish
        int maxRate=-1;
        for(int bananas: piles){
            maxRate = Math.max(bananas,maxRate);
        }

        int l=1, r=maxRate;
        int res = r;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(canFinish(piles,h,mid)){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return res;
    }


    private boolean canFinish(int[] piles, int h, int r){
        long hours = 0;

        for(int bananas: piles){
            hours += (bananas+r-1)/r;
        }

        return hours<=h;
    }
}
