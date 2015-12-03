
import java.util.InputMismatchException;
import java.util.Scanner;


public class GetXY {
    private Scanner sc = new Scanner(System.in);
    
    public int[] getXY(){
        String s;
        boolean f = false;
        int[] a = {-1,-1};
        while (!f){
            try{
                a[0] = sc.nextInt();
                a[1] = sc.nextInt();
                if (a[0]>0 && a[0]<4 && a[1]>0 && a[1]<4){
                    f = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch(InputMismatchException ex){
                System.out.println("Error!!! Invalid enter!!! Repeat please!!!");
                s = sc.nextLine();
                f = false;
            }
        }
        return a;
    }
}
