package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
/**
 * vm argument
 * -Xmx8M
 * @author HP
 *
 */
public class SoftReferenceTest {
	public static void main(String[] args) {
		MyObject obj = new MyObject();
		ReferenceQueue queue = new ReferenceQueue<MyObject>();
		SoftReference softRef = new SoftReference<MyObject>(obj,queue);
		obj = null;
		System.gc();
		System.out.println("After GC:Soft Get= " + softRef.get());
		System.out.println("分配大内存");
		byte[] b = new byte[8*1024*503];
		System.out.println("After new byte[]:Soft Get= " + softRef.get());
	}
}
class MyObject{

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("MyObject function finalize called");
	}
	
	public String toString() {
		return "I am Objects";
	}
	
}
