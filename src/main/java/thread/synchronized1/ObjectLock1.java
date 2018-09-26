package thread.synchronized1;

/**
 * 自身对象锁
 * 两种方式 其本质是一样的
 * @author wenjie
 *
 */
public class ObjectLock1 {
	private synchronized void lock(){
		// todo 逻辑
	}
	
	private  void lock2(){
		synchronized(this){
			// todo 逻辑
		}
	}
}
