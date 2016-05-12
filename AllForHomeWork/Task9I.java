import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task9I {
    public void start(){
        try(FileWriter fileWriter = new FileWriter("text.txt", true)){
            Scanner sc = new Scanner(System.in);
            String str;
            while ((str = sc.nextLine()).length() > 0){
                fileWriter.write(str + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
