package thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 无边界的线程池
 * @author jairwx
 *
 */
public class ThreadPoolDemo2 {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Map map = new HashMap<Integer,String>();
		final NumTest numTest = new NumTest();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 50, 0L, TimeUnit.DAYS, new ArrayBlockingQueue<Runnable>(10));
		for(int i = 0 ;i<1000;i++) {
			Thread.sleep(1000);
			pool.execute(new TaskDemo(numTest));
		}
	}

}