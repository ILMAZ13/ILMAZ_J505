//Task 4
//Алфавитный порядок
class AlphabeticalOrder {
	public static void main(String[] args) {
		boolean f = true;
		for (int i = 0; i < args[0].length()-1; i++) {
			if (args[0].charAt(i) > args[0].charAt(i+1))
				f = false;
		}
		if (f)
			System.out.println("True");
		else
			System.out.println("False");
	}
}