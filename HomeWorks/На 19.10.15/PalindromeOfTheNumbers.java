//Task 6
class PalindromeOfTheNumbers {
	public static void main(String[] args) {
		boolean f = false;
		for (int i = 0; i < (args[0].length()+1)/2; i++) {
			if ((args[0].charAt(i) >= '0')&&(args[0].charAt(i) <= '9')&&(args[0].charAt(i) == args[0].charAt(args[0].length()-1-i))) {
				f = true;
			} else {
				f = false;
				break;
			}
		}
		if(f)
			System.out.println("This is palindrome of the numbers");
		else 
			System.out.println("This is NOT palindrome of the numbers");
	}
}