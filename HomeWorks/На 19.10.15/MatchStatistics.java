//Task 3
//Статистика матча типа "Рубин-Спартак 0:1 3:2 1:3 итд"
import java.util.Arrays;
class MatchStatistics {
	public static int goals(String res, int kn) {
        int pos = res.indexOf(":");
        if(kn == 0) {
            return Integer.valueOf(res.substring(0, pos));
        } else {
            return Integer.valueOf(res.substring(pos+1));
        }
    }
    
    public static void main(String[] args) {
            int n = args.length;
            int k1s = 0;
            int k2s = 0;
            int pos = args[0].indexOf("-");
            String k1 = args[0].substring(0, pos);
            String k2 = args[0].substring(pos+1);
            for (int i = 1; i < n; i++) {
                k1s += goals(args[i],0);
                k2s += goals(args[i],1);
            }
            System.out.println(k1+": "+String.valueOf(k1s));
            System.out.println(k2+": "+String.valueOf(k2s));
	}
}