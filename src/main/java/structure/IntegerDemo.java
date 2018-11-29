package structure;


public class IntegerDemo {
	
	/**
	 * Integer类与int的自动拆箱
	 */
	@Test
	public void buildDemo(){
		Integer int1 = 11;
		Integer int2 = new Integer(11);
		System.out.println(int1 == int2);//false
	}
	
	
	/**
	 * 重点一:
	 * 自动装箱其实就是valueOf()的过程
	 * 而valueOf()对 -128<x<127的数进行了缓存，从而导致int1 = int2
	 */
	@Test
	public void integerCache(){
		Integer int1 = 127;
		Integer int2 = 127;
		Integer int3 = 128;
		Integer int4 = 128;
		Integer int5 = Integer.valueOf(127);
		System.out.println(int1 == int2);//true
		System.out.println(int3 == int4);//false
		System.out.println(int1 == int5);//true
	}
	
	
}
