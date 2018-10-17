package thread.final1;

public class FinalExample {
	
	int i;//普通变量
	
	final int j;//如果不在构造函数赋值，则会报错Description	Resource	Path	Location	Type

	static FinalExample obj;
	
	public FinalExample() {
		i = 1;
		j = 2;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
