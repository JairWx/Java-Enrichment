package classloading;

/**
 * 静态语句块的变量需要在他前面进行初始化
 * @author admin
 *
 */
public class Initialization1 {
	static{
		i = 0;
		//报错
		//System.out.println(i);
	}
	
	static int i =1;
}