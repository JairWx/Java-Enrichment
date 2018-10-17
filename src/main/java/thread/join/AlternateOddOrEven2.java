package thread.join;

import java.awt.datatransfer.StringSelection;

import oj.MainClass;

/**
 * 交替打印奇偶数
 * 错误的范例
 * @author admin
 *
 */
public class AlternateOddOrEven2 {
	public static int num = 0;
	public static  boolean flag = true;
	//boolean flag = true;
	public static void main(String[] args){
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				while (AlternateOddOrEven2.num < 10000) {
					synchronized(AlternateOddOrEven2.class) {
						if(AlternateOddOrEven2.flag == true){
							AlternateOddOrEven2.flag = false;
							AlternateOddOrEven2.num ++;
							System.out.println("打印奇数"+AlternateOddOrEven2.num);
							AlternateOddOrEven2.class.notify();
						}else{
							try {
								AlternateOddOrEven2.class.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				while (AlternateOddOrEven2.num < 10000) {
					synchronized(AlternateOddOrEven2.class) {
						if(AlternateOddOrEven2.flag == true){
							AlternateOddOrEven2.flag = false;
							AlternateOddOrEven2.num ++;
							System.out.println("打印奇数"+AlternateOddOrEven2.num);
							AlternateOddOrEven2.class.notify();
						}else{
							try {
								AlternateOddOrEven2.class.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				}
				
			}
		});
		
		t1.start();
		t2.start();
	}	

}

