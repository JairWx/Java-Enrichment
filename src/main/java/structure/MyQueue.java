package structure;

import java.util.Stack;

/**
 * 用栈实现队列
 * 易错点是push
 * 当元素大于两个时，则需要两个栈
 * @author wenjie
 *
 */
public class MyQueue {
	
	private Stack stack = new Stack();
	
	 /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if(this.stack.size() == 1){
    		Stack stack2 = new Stack();
    		stack2.push(x);	
    		stack2.push(this.stack.peek());
    		this.stack = stack2;
    	}else if(this.stack.size() > 1){
    		//还原
    		Stack resetS = new Stack();
    		Stack retS = new Stack();
    		while(!this.stack.isEmpty()) {
    			resetS.push(this.stack.peek());
        		this.stack.pop();
        	}
    		resetS.push(x);
    		//颠倒
    		while(!resetS.isEmpty()) {
    			retS.push(resetS.peek());
    			resetS.pop();
        	}
    		this.stack = retS;
    	}else{
    		this.stack.push(x);
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	int num = (Integer) this.stack.peek();
    	this.stack.pop();
    	return num;
    }
    
    /** Get the front element. */
    public int peek() {
        return (Integer) this.stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack.empty();
    }
    
    public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.peek());
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
