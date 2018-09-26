package thread.synchronized1;

import java.util.ArrayList;
import java.util.List;

/**
 * 阻塞队列
 * 用于模拟wait,notify
 * 增加pop(),push()
 * @author wenjie
 *
 */
public class BlockQueue {
	private List list = new ArrayList();
	
	public synchronized Object pop(){
		while(list.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list.remove(0);
	}
	
	/**
	 * 没有synchronized则会报错:java.lang.IllegalMonitorStateException
	 * @param o
	 */
	public synchronized void push(Object o){
		list.add(o);
		this.notify();
	}
	
}
