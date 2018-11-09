package concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

import oj.MainClass;

public class WaitNotify {
	static boolean flag = true;
	//因为内部类调用所以使用static修饰
	static Object lock = new Object();
	/**
	 * 通知线程
	 * @author admin
	 *
	 */
	 static class Notify implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread()+"线程开始");
			synchronized(lock){
				System.out.println(Thread.currentThread()+"取得对象锁");
					lock.notify();
					System.out.println("调用notify后，休眠3秒");
					SleepUtils.second(3);
			}
			System.out.println(Thread.currentThread()+"释放锁");
			synchronized(lock){
				System.out.println(Thread.currentThread()+"取得对象锁"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
			//逻辑
			System.out.println(Thread.currentThread()+"线程执行完毕");
		}
		
	}
	 
	 /**
	  * 等待线程
	  * @author admin
	  *
	  */
	  static class Wait implements Runnable{

	 	public void run() {
	 		// TODO Auto-generated method stub
	 		System.out.println(Thread.currentThread()+"线程开始");
	 		synchronized(lock){
	 			System.out.println(Thread.currentThread()+"取得对象锁"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
	 			try {
	 				lock.wait();
	 				System.out.println("调用wait后...");
	 				//SleepUtils.second(5);
	 			} catch (InterruptedException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	 		}
	 		System.out.println(Thread.currentThread()+"释放锁"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
			//逻辑
	 		System.out.println(Thread.currentThread()+"线程执行完毕");
	 	}
	 	
	 }
	
	public static void main(String[] args){
		/**
		 * No enclosing instance of type WaitNotify is accessible. 
		 * Must qualify the allocation with an enclosing instance of type WaitNotify 
		 * (e.g. x.new A() where x is an instance of WaitNotify).
		 */
		Thread waitThread = new Thread(new Wait(),"WaitThread");
		waitThread.start();
		Thread notifyThread = new Thread(new Notify(),"NotifyThread");
		notifyThread.start();
	}
}


