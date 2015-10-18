//Task 5
//На повторение символов
import java.util.HashMap;
class RepeatCharacters {
	public static void main(String[] args) {
        Map test = new HashMap<String,Integer>(); //Создаём Map
        for (int i =0; i<args[0].length();i++) {
            if(!test.containsKey(args[0].charAt(i))) //Если такого символа нет в мапе, то создаём метку с ней и присваиваем 1
                test.put(args[0].charAt(i), 1);
            else test.put(args[0].charAt(i), 2); //Если этот символ уже встречался, присваиваем 2
        }
        if(test.containsValue(1)) //Если имеются метки со значением 1, значит есть не повторяющиеся символы
            System.out.println("Есть не повторяющиеся символы");
        else
            System.out.println(args[0].charAt(1)); //Иначе выводим 1-ый символ, он так же считается любым
    }
}