package thread.volatile1;

/**
 * 没有volatile 修饰 
 * MyThread不再去读取未曾发生改变的且未标记为volatile 通俗讲就是变量修改线程间不可见
 * @author wenjie
 *
 */
public class MyThread extends Thread{
	
	private boolean stop = false;
	
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
			Thread.sleep(1000);//如果没有延时，则子线程则会立即关闭 输出Thread is stop:0
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.stopMe();
	}
	
}
