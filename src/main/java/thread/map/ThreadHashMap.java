package thread.map;

import java.util.HashMap;
import java.util.UUID;

public class ThreadHashMap {
	public static void main(String[] args) throws InterruptedException {
		final HashMap<String,String> map = new HashMap<String,String>(2);
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0 ; i< 10000 ;i++) {
					new Thread(new Runnable() {
						
						public void run() {
							// TODO Auto-generated method stub
							map.put(UUID.randomUUID().toString(), "");
						}
					}).start();
				}
			}
		});
		t.start();
		t.join();
	}
}
