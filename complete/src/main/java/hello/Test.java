package hello;


public class Test {
	Calculator cal=new Calculator();
	
	
	public void m( ) {
		System.out.println(cal.base);
		System.out.println(cal.new MinusButtonListenerImpl().innerClass);
		
	}
	
	public static void main(String[] args) {
		Test test=new Test();
		test.m();
	}
	


}
