class MyQueue {
    private Deque<Integer>inputstack;
    private Deque<Integer>outputstack;

    public MyQueue() {
        inputstack=new ArrayDeque<>();
        outputstack=new ArrayDeque<>();
        
    }
    
    public void push(int x) {
        inputstack.push(x);
        
    }
    
    public int pop() {
        peek();
        return outputstack.pop();
        
    }
    
    public int peek() {
        if(outputstack.isEmpty()){
            while(!inputstack.isEmpty()){
                outputstack.push(inputstack.pop());
            }
        }
        if(outputstack.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return outputstack.peek();
    }
    
    public boolean empty() {
        return inputstack.isEmpty() && outputstack.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */