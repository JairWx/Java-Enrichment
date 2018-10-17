package thread.join;

import java.awt.datatransfer.StringSelection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.sun.javafx.stage.EmbeddedWindow;

import oj.MainClass;

/**
 * 交替打印奇偶数
 * 特定打印奇偶数
 * 使用重入锁
 * @author admin
 *
 */
public class AlternateOddOrEven3 {
	public static int num = 0;
	public static  boolean flag = true;
	//boolean flag = true;
	public static void main(String[] args){
		
		final Lock lock = new ReentrantLock();
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				while (AlternateOddOrEven3.num < 10000) {
					if(flag){
						lock.lock();
						try {
							AlternateOddOrEven3.flag = false;
							AlternateOddOrEven3.num ++;
							System.out.println("打印奇数"+AlternateOddOrEven3.num);
						} finally {
							lock.unlock();
						}
					}
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				while (AlternateOddOrEven3.num < 10000) {
					if(!flag){
						lock.lock();
						try {
							AlternateOddOrEven3.flag = true;
							AlternateOddOrEven3.num ++;
							System.out.println("打印偶数"+AlternateOddOrEven3.num);
						} finally {
							lock.unlock();
						}
					}
				}
				
			}
		});
		
		t1.start();
		t2.start();
	}	

}

