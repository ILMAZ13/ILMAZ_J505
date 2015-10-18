//Task 5
//Проверка на существование не поторяющихся символов
//Если все символы повторяются, то выводится любой
import java.util.HashMap;
import java.util.Map;
class RepeatCharacters {
	public static void main(String[] args) {
        Map<Character, Integer> test = new HashMap<Character,Integer>(); 
        for (int i =0; i<args[0].length();i++) {
            if(!test.containsKey(args[0].charAt(i))) 
                test.put(args[0].charAt(i), 1);
            else test.put(args[0].charAt(i), 2);
        }
        if(test.containsValue(1)) 
            System.out.println("No repeats");
        else
            System.out.println(args[0].charAt(1)); 
	}
}