//Task 1
//Решение квадратного уравнения типа "+-aх^2+-bx+-c"
class QuadraticEquation {
	public static void main(String[] args) { 
		String s = args[0]; 
		String s1 = ""; 
		int i = 0; 
		double a=1.0; 
		double b=1.0; 
		double c=0.0; 
		while ((s.charAt(i) != 'x') && (s.charAt(i) != 'X')) { 
			s1 = s1 + String.valueOf(s.charAt(i)); 
			i++; 
		} 
		if(s1.length()>0){ 
			if ((s1.length() == 1) && ((s1.charAt(0) == '-') || (s1.charAt(0) == '+'))) 
				s1 = s1+"1"; 
			a = Double.valueOf(s1); 
		} 
		s1 = ""; 
		i = i + 3; 
		//s1 = s1 + String.valueOf(s.charAt(i-1)); 
		while ((s.charAt(i) != 'x') && (s.charAt(i) != 'X')) { 
			s1 = s1 + String.valueOf(s.charAt(i)); 
			i++; 
		} 
		if (s1.length()>0){ 
			if ((s1.length() == 1) && ((s1.charAt(0) == '-') || (s1.charAt(0) == '+'))) 
				s1 = s1+"1"; 
			b = Double.valueOf(s1); 
		} 
		s1 = ""; 
		for (i = i+1; i < s.length(); i++) { 
			s1 = s1 + String.valueOf(s.charAt(i)); 
		} 
		if(s1.length()>0) 
			c = Double.valueOf(s1); 
		double d =b*b - 4.0*a*c; 
		if (d >= 0.0) { 
			System.out.println((-b+ Math.sqrt(d))/(2.0*a)); 
			System.out.println((-b- Math.sqrt(d))/(2.0*a)); 
		} 
		else { 
			System.out.println("Нет корней"); 
		} 

	}
}