package thread.synchronized1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenjie
 *
 */
public class BlockQueueThread extends Thread{
	//这个不用volatile修饰也行
	private BlockQueue b = new BlockQueue();
	public BlockQueueThread(BlockQueue b){
		this.b = b;
	}
	public void run() {
		System.out.println("开始启动线程");
		// TODO Auto-generated method stub
			System.out.println(b.pop());
		
	}
	
	public static void main(String[] args ){
		BlockQueue b = new BlockQueue();
		BlockQueueThread thread = new BlockQueueThread(b);
		thread.start();
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.push("测试");
	}
	
}
