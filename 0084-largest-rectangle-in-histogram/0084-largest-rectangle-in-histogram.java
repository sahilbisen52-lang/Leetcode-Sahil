class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int currentheight=(i==n)?0:heights[i];
            while(!stack.isEmpty() && currentheight<heights[stack.peek()]){
                int h=heights[stack.pop()];
                int w;
            if(stack.isEmpty()){
                w=i;
            }
            else{
                w=i-stack.peek()-1;
            }
            maxArea=Math.max(maxArea,h*w);
            }
             stack.push(i);
        }
        return maxArea;
        
    }
}