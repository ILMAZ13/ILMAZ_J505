import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        String s = sc.nextLine();
        while (s.length() > 0){
            try {
                integerArrayList.add(Integer.parseInt(s));
            } catch (NumberFormatException e){
                System.out.println("Not a Number");
            }
            s = sc.nextLine();
        }
        Object[] a = integerArrayList.toArray();
        Arrays.sort(a);
        try(FileWriter fileWriter = new FileWriter("text.csv",true)) {
            int temp = 0;
            for(int i = 0; i < a.length; i++){
                if(temp == 2){
                    fileWriter.write(a[i].toString());
                    fileWriter.write("\r\n");
                    temp = 0;
                } else {
                    fileWriter.write(a[i] + ",");
                    temp++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileReader fileReader = new FileReader("text.csv")) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){
                String ss = scanner.nextLine();
                String te[] = new String[3];
                te = ss.split(",");
                for(int i = 0; i < 3; i++){
                        System.out.println(te[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
