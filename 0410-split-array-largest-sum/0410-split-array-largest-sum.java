class Solution {
    public int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;
        for(int num:nums){
            start=Math.max(start,num);
            end+=num;
        }
        int ans=end;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(canSplit(nums,k,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    private boolean canSplit(int[] nums,int k,int maxallowedsum){
        int subarraycount=1;
        int currentsum=0;
        for(int num:nums){
            if(currentsum+num<=maxallowedsum){
                currentsum+=num;
            }
            else{
                subarraycount++;
                currentsum=num;
            }
        }
        return subarraycount<=k;
    }

}