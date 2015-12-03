
import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
        GetXY get = new GetXY();//returns int[]
        Playground pg = new Playground();
        HardLogic mi = new HardLogic();
        Tester te = new Tester(get,pg,mi);
        EasyGamer robo = new EasyGamer(get,pg,mi,te);
        HardGamer term = new HardGamer(get,pg,mi,te);
        
//        JFrame window = new JFrame(get,pg);
//        window.setVisible(true);
        System.out.println("Play Hard or Easy?(h/e)");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.equals("h")){
            System.out.println("<<Hard mode>>");
            System.out.println("You play for |X|");
            pg.printPlaygrounnd();
            term.playHard();
        } else {
            if (s.equals("e")){
                System.out.println("<<Easy mode>>");
                System.out.println("You play for |X|");
                pg.printPlaygrounnd();
                robo.playEasy();
            } else {
                System.out.println("Invalid enter!!!");
            }
        }
        
        
    }   
}
