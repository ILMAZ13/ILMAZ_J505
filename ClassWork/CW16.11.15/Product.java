class Product {
	public static void main(String[] args){ 
			int kr = 0;
			int kv = 0;
			int fi = 0;
		for (int i = 0; i < args[0].length(); i++) {
			
			if (args[0].charAt(i) == '('){
				kr++;
			}
			if (args[0].charAt(i) == ')'){
				if ((kv != 0) || (fi != 0)) {
					System.out.println("Error");
					break;
				}
				kr--;
			}
			if (args[0].charAt(i) == '['){
				kv++;
			}
			if (args[0].charAt(i) == ']'){
				if ((kr != 0) || (fi != 0)) {
					System.out.println("Error");
					break;
				}
				kv--;
			}
			if (args[0].charAt(i) == '{'){
				fi++;
			}
			if (args[0].charAt(i) == '}'){
				if ((kv != 0) || (fi != 0)) {
					System.out.println("Error");
					break;
				}
				fi--;
			}
		}
		if ((kr == 0) && (kv == 0) && (fi == 0)){
			System.out.println("OK");
		} else 
			System.out.println("Error");
	}
}