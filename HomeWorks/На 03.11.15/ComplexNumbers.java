public class ComplexNumbers {
	private int a = 0;
	private int b = 0;
	
	public ComplexNumbers(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public int getA(){
		return this.a;
	}
	
	public int getB(){
		return this.b;
	}
	
	public void summ(int a, int b){
		this.a += a;
		this.b += b;
	}
	
	public void summ(ComplexNumbers cl){
		this.a += cl.getA();
		this.b += cl.getB();
	}
	
	public void subtruct(int a, int b){
		this.a -= a;
		this.b -= b;
	}
	
	public void subtruct(ComplexNumbers cl){
		this.a -= cl.getA();
		this.b -= cl.getB();
	}
	
	public void multiplication(int a, int b){
		this.a = (this.a * a) - (this.b * b);
		this.b = (this.a * b) + (this.b * a);
	}
	
	public void multiplication(ComplexNumbers cl){
		int aa = (this.a * cl.getA()) - (this.b * cl.getB());
		this.b = (this.a * cl.getB()) + (this.b * cl.getA());
		this.a = aa;
	}
	
	public void printComplex(){
		System.out.println(this.a + "+" + this.b + "i");
	}
	
	public static void main(String[] args){
		ComplexNumbers num1 = new ComplexNumbers(1,2);
		ComplexNumbers num2 = new ComplexNumbers(2,3);
		num1.printComplex();
		num2.printComplex();
		num1.multiplication(num2);
		num1.printComplex();
	}
}