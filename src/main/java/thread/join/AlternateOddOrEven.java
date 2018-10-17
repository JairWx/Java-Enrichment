package thread.join;

import java.awt.datatransfer.StringSelection;

import oj.MainClass;

/**
 * 交替打印奇偶数
 * @author admin
 *
 */
public class AlternateOddOrEven {
	public static int num = 0;
	//boolean flag = true;
	public static void main(String[] args){
		 int num = 0;
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				while (AlternateOddOrEven.num < 10000) {
					synchronized(AlternateOddOrEven.class) {
						AlternateOddOrEven.num ++;
						System.out.println(AlternateOddOrEven.num);
					}
					
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				while (AlternateOddOrEven.num < 10000) {
					synchronized(AlternateOddOrEven.class) {
						AlternateOddOrEven.num ++;
						System.out.println(AlternateOddOrEven.num);
					}
					
				}
				
			}
		});
		
		t1.start();
		t2.start();
	}	

}

