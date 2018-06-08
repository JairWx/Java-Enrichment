package thread.volatile1;

/**
 * volatile 修饰符 
 * @author wenjie
 *
 */
public class MyThread2 extends Thread{
	
	private volatile boolean stop = false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(!stop){
			i++;
		}
		System.out.println("Thread is stop:"+i);
	}
	
	public void stopMe(){
		this.stop = true;
	}
	
	public static void main(String[] args) {
		MyThread2 t = new MyThread2();
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.stopMe();
	}
	
}
