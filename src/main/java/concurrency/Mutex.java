package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Mutex implements Lock{

	private static class Sync extends AbstractQueuedSynchronizer{
			public boolean isHeldExclusively() {
				return getState() == 1;
			}

			@Override
			protected boolean tryAcquire(int arg) {
				if(compareAndSetState(0, 1)){
					//设置当前拥有独占访问权限的线程。 null参数表示没有线程拥有访问权限。 此方法不会强加任何同步或易失性字段访问。
					setExclusiveOwnerThread(Thread.currentThread());
					return true;
				}
				return false;
			}
			
			@Override
			protected boolean tryRelease(int arg) {
				//如果状态为0，未取得锁，则报错
				if(getState() == 0){
					throw new IllegalMonitorStateException();
				}
				setExclusiveOwnerThread(null);
				setState(0);
				return true;
			}
			
			
			
	}
	private Sync sync = new Sync();
	//重写的方法
	public void lock() {
		// TODO Auto-generated method stub
		sync.acquire(1);
	}

	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	public void unlock() {
		sync.release(1);
		
	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
