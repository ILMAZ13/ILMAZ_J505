//Task 2
//Сортировка строк по длине
import java.util.Arrays;

class SortingWordsInLength {
	//Сортировка уже разделенного на части массива
	public static String[] merge(String[] arr_1, String[] arr_2) {
	int len_1 = arr_1.length, len_2 = arr_2.length;
	int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
	String[] result = new String[len];
	for (int i = 0; i < len; i++) {
		if (b < len_2 && a < len_1) {
			if (arr_1[a].length() > arr_2[b].length()) result[i] = arr_2[b++];
			else result[i] = arr_1[a++];
		} else if (b < len_2) {
			result[i] = arr_2[b++];
		} else {
			result[i] = arr_1[a++];
		}
	}
	return result;
}
    //Разбиение массива и вызов сортировки
    public static String[] sortMerge(String[] arr) {
	int len = arr.length;
	if (len < 2) return arr;
	int middle = len / 2;
	return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
	             sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }
    
    public static void main(String[] args) {
        //Сортировка методом слияния за n*log(n)
        System.out.println(Arrays.asList(sortMerge(args)));
    }
}