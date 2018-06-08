package thread.synchronized1;

/**
 * 
 * @author wenjie
 *
 */
public class Wait {
	public synchronized void lock(Object o){
		while(true){//等待条件 
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//some code
		}
	}
}
