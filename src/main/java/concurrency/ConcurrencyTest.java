package concurrency;

public class ConcurrencyTest {
	
	private static final long count = 10000000000000l;
	
	public static void main(String[] args) throws InterruptedException{
		concurrency();
	}
	
	/**
	 * 并行运行
	 * @throws InterruptedException 
	 */
	private static void concurrency() throws InterruptedException{
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			
			public void run() {
				int a = 0;
				for(long i =0; i< count ;i++){
					a+=5;
				}
				
			}
		});
		thread.start();
		int b = 0;
		for(long i = 0; i< count ;i++){
			b--;
		}
		
		long time = System.currentTimeMillis() - start;
		thread.join();
		System.out.println("concurrency:"+time+"ms,b="+b);
	}
	
}
