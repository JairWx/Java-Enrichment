package thread_4_4;

import concurrency.SleepUtils;

public class ThreadState {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new TimeWaiting(),"TimeWaitingThread").start();
		new Thread(new Waiting(),"WaitingThread").start();
		SleepUtils.second(5);
		System.out.println("===");
		new Thread(new Blocked(),"BlockedThread").start();
	}
	
	//该线程不断地进行睡眠
	//如果不用static修饰则不能在main方法初始化
	static class TimeWaiting implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				SleepUtils.second(100);
			}
		}
		
	}
	
	static class Waiting implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				synchronized (Waiting.class) {
					try {
						//必须获取锁才能调用wait()
						SleepUtils.second(50);
						Waiting.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	static class Blocked implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				System.out.println("wait");
				synchronized (Waiting.class) {
					SleepUtils.second(50);
					System.out.println("sss");
				}
			}
		}
		
	}

}
