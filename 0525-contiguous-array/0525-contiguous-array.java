class Solution {
    public int findMaxLength(int[] nums) {
        int maxlength=0;
        int currsum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                currsum+=-1;
            }
            else{
                currsum+=1;
            }
            if(map.containsKey(currsum)){
                int previndex=map.get(currsum);
                int currentlength=i-previndex;
                maxlength=Math.max(maxlength,currentlength);
            }
            else{
                map.put(currsum,i);
            }
        }
        return maxlength;
        
    }
}