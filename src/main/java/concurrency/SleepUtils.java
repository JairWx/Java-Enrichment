package concurrency;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
	public static final void second(long seconds){
		try{
			//这个方式与Thread.sleep(seconds)差不多
			TimeUnit.SECONDS.sleep(seconds);
		}catch(InterruptedException e){
			
		}
	}
}
