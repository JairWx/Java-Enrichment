package structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 最小栈
 * 遗漏，误以为top是删除元素
 * min的初始值不应该是0，而是push的第一个值
 * @author wenjie
 *
 */
public class MinStack {
	
	private List<Integer> list = new ArrayList();
	private int min = 0;
	 public MinStack() {
	        
	}
	    
    public void push(int x) {
    	if(list.size() == 0) {
    		min = x;
    	}
    	if(min > x) {
    		min = x;
    	}
    	list.add(x);
    }
    
    public void pop() {
    	if(list.size() > 0){
    		int num = list.get(list.size() - 1);
    		list.remove(list.size() - 1);
    		if(num == min){
    			sort();
    		}
    	}
    }
    
    private void sort() {
    	if(list.size() > 0) {
    		min = list.get(0);
    		for(Integer i : list){
    			if(min > i) {
    				min = i;
    			}
    		}
    	}else{
    		min = 0;
    	}
    	
    }
    /**
     * top只是取值不需要删除
     * @return
     */
    public int top() {
    	int num = 0;
    	if(list.size() > 0){
    		 num = list.get(list.size() - 1);
    		//list.remove(list.size() - 1);
    		//sort();
    	}
    	return num;
    }
    
    public int getMin() {
        return min;
    }
    
    public static void main() {
    	new Stack();
    }
	
	
	}
