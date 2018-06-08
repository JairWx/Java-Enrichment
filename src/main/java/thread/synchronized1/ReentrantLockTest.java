package thread.synchronized1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 * 默认不公平锁 解锁随机
 * @author wenjie
 *
 */
public class ReentrantLockTest {
	private ReentrantLock lock = new ReentrantLock();
	private Runnable createTask(){
		return new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						if(lock.tryLock(500,TimeUnit.MILLISECONDS)){
							System.out.println("锁定"+Thread.currentThread().getName());
							Thread.sleep(1000);
							lock.unlock();
							System.out.println(Thread.currentThread().getName()+"解锁成功");
						}else{
							System.out.println(Thread.currentThread().getName()+"无法锁定");
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						System.out.println(Thread.currentThread().getName()+"中断");
					}
				}
			}
			
		};
	}
	
	public void test() throws InterruptedException{
		Thread first = new Thread(createTask(),"Thread1");
		Thread second = new Thread(createTask(),"Thread2");
		first.start();
		second.start();
		
		Thread.sleep(600);
		second.interrupt();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new ReentrantLockTest().test();
	}
}
