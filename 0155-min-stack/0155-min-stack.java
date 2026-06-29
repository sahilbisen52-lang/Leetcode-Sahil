class MinStack {
    private Stack<Integer> mainstack;
    private Stack<Integer> minstack;

    public MinStack() {
        mainstack=new Stack<>();
        minstack=new Stack<>();
        
    }
    
    public void push(int val) {
        mainstack.push(val);
        if(minstack.isEmpty() || val<=minstack.peek()){
            minstack.push(val);
        }

    }
    
    public void pop() {
        if(mainstack.peek().equals(minstack.peek())){
            minstack.pop();
        }
        mainstack.pop();
    }
    
    public int top() {
        return mainstack.peek();
        
    }
    
    public int getMin() {
        return minstack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */