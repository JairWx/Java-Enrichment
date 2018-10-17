package thread.join;

import javax.net.ssl.SSLException;

import com.sun.javafx.font.t2k.T2KFactory;

/**
 * 现在有线程 T1、T2 和 T3。你如何确保 T2 线程在 T1 之后执行，并且 T3 线程在 T2 之后执行
 * @author admin
 *
 */
public class JoinThread {
	
	public static void main(String[] args){
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);//代替业务逻辑处理时间
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t1 end");
			}
		});
		try {
			t1.start();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);//代替业务逻辑处理时间
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t2 end");
			}
		});
try {
	t2.start();
	t2.join();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Thread t3 = new Thread(new Runnable() {
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);//代替业务逻辑处理时间
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("t3 end");
	}
});
		try {
			t3.start();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
