package thread.synchronized1;

/**
 * 其他对象锁
 * @author wenjie
 *
 */
public class ObjectLock2 {
	private Object o = new Object();
	
	private  void lock(){
		synchronized(o){
			// todo 逻辑
		}
	}
	
	/**
	 * ? 不知道这个跟之前的一样不一样
	 * 同步块，代码有效剥离，减少竞争
	 * @param o2
	 */
	private  void lock2(Object o2){
		//some code
		synchronized(o2){
			// todo 逻辑
		}
		//other code 
	}
}
