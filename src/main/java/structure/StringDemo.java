package structure;

public class StringDemo {
	
	public  static void main(String[] args) {
		char value[] = {'a','b'};
		
		String str = new String("ab");
		//1.String 的地址问题
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String(s2);
		
		System.out.println();
	}
	
}
