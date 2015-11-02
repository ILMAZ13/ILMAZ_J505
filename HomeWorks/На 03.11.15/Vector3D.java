public class Vector3D {
	private int x = 0;
	private int y = 0;
	private int z = 0;
	
	public Vector3D(int x, int y, int z){ //Конструктор
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getVectorModule(){ //Модуль вектора
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public void subtractVector(int x, int y, int z){ //Вычитание вектора
		this.x -= x;
		this.y -= y;
		this.z -= z;
	}
	
	public void subtractVector(Vector3D vec){ //Вычитание вектора(перегружена)
		this.x -= vec.getX();
		this.y -= vec.getY();
		this.z -= vec.getZ();
	}
	
	public void addVector(int x, int y, int z){ //Сложение вектора
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void addVector(Vector3D vec){ //Сложение вектора(перегружена)
		this.x += vec.getX();
		this.y += vec.getY();
		this.z += vec.getZ();
	}
	
	public double getVectorMultiplicationModule(int x, int y, int z){ //Модуль векторного произведения (площадь параллелограмма)
		return Math.sqrt(Math.pow(this.x * y - this.y * x, 2) + Math.pow(this.y * z - this.z * y, 2) + Math.pow(this.z * x - this.x * z, 2));
	}
	
	public double getVectorMultiplicationModule(Vector3D vec){ //Модуль векторного произведения (площадь параллелограмма)(перегружена)
		return Math.sqrt(Math.pow(this.x * vec.getY() - this.y * vec.getX(), 2) + Math.pow(this.y * vec.getZ() - this.z * vec.getY(), 2) + Math.pow(this.z * vec.getX() - this.x * vec.getZ(), 2));
	}
	
	public double getVectorScalarMultiplication(int x, int y, int z){ //Скалярное произведение
		return this.x * x + this.y * y + this.z * z; 
	}
	
	public double getVectorScalarMultiplication(Vector3D vec){ //Скалярное произведение(перегружена)
		return this.x * vec.getX() + this.y * vec.getY() - this.z * vec.getZ(); 
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getZ() {
		return this.z;
	}
	
	public void printVector(){
		System.out.println(this.x + " " + this.y + " " + this.z);
	}
	
	
	public static void main(String[] args){
		Vector3D vec1 = new Vector3D(3,4,5);
		Vector3D vec2 = new Vector3D(2,2,2);
		System.out.println("Vector Module");
		vec1.printVector();
		System.out.println(vec1.getVectorModule());
		System.out.println("Subtract Vector");
		vec1.printVector();
		vec2.printVector();
		vec1.subtractVector(vec2);
		vec1.printVector();
		System.out.println("Sum Vector");
		vec1.printVector();
		vec2.printVector();
		vec2.addVector(vec1);
		vec2.printVector();
		System.out.println("Vector Multiplication Module");
		vec1.printVector();
		vec2.printVector();
		System.out.println(vec1.getVectorMultiplicationModule(vec2));
		System.out.println("Vector Scalar Multiplication");
		vec1.printVector();
		vec2.printVector();
		System.out.println(vec1.getVectorScalarMultiplication(vec2));
	}

}
