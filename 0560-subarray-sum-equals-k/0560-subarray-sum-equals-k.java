class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int currsum=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            int pasttarget=currsum-k;

            if(map.containsKey(pasttarget)){
                count+=map.get(pasttarget);
            }
            map.put(currsum,map.getOrDefault(currsum,0)+1);
        }
        return count;
        
    }
}