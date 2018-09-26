package thread.synchronized1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenjie
 *
 */
public class BlockQueueThread2 extends Thread{
	private volatile BlockQueue b = new BlockQueue();
	public BlockQueueThread2(BlockQueue b){
		this.b = b;
	}
	public void run() {
		System.out.println("开始启动线程");
		// TODO Auto-generated method stub
		while(true){
			System.out.println(Thread.currentThread().getName()+"取出"+b.pop());
		}
		
	}
	
	public static void main(String[] args ){
		BlockQueue b = new BlockQueue();
		BlockQueueThread2 thread = new BlockQueueThread2(b);
		thread.setName("firstThread");
		thread.start();
		BlockQueueThread2 thread2 = new BlockQueueThread2(b);
		thread2.setName("secondThread");
		thread2.start();
		int i = 0;
		while(i < 100){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.push(i);
			i++;
		}
	}
	
}
