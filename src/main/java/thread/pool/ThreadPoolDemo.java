package thread.pool;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 无边界的线程池
 * @author jairwx
 *
 */
public class ThreadPoolDemo {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Map map = new HashMap<Integer,String>();
		final NumTest numTest = new NumTest();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 50, 0L, TimeUnit.DAYS, new PriorityBlockingQueue<Runnable>());
		for(int i = 0 ;i<1000;i++) {
			//Thread.sleep(1000);
			pool.execute(new TaskDemo(numTest));
		}
	}

}
class NumTest{
	 int num = 0;
}
class TaskDemo implements Comparable,Runnable{
	private NumTest numTest;
	public TaskDemo(NumTest numTest) {
		this.numTest = numTest;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
			numTest.num += 1;
			System.out.println(numTest.num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
