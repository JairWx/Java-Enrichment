package structure;

import java.util.LinkedList;

class MyStack {
	
	private LinkedList list = new LinkedList();//是一个队列
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	list.push(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	return (Integer) list.pop();
    }
    
    /** Get the top element. */
    public int top() {
        return (Integer) list.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return list.isEmpty();
    }
    
    public static void main(String[] args) {
    	MyStack obj = new MyStack();
    	obj.push(1);
    	obj.push(2);
    	obj.push(3);
    	System.out.println(obj.pop());
    	System.out.println(obj.top());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */