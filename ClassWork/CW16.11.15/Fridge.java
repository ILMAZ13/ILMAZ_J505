import java.util.Calendar;

public class Fridge{
    private final int maxVolume;
    private double volumeNow = 0;
    private int count = 0;
    private Food food[];
    private int money;

    public Fridge(int maxVolume){
        this.maxVolume = maxVolume;
        food = new Food[maxVolume];
    }
    public void add(Food a){
        if (!(a.getVolume() > 0)){
            System.err.println("It`s impossible"); //Защита от выхода за массив
        } else {
            int price = (int) ( a.getFats() * a.getProteins() / 10 + 1);
            if ((a.getVolume() < maxVolume - volumeNow) && (price < money)){
                food[count] = a;
                this.volumeNow += a.getVolume();
                this.money -= price;
                count++;
            } 
        }
    }
    
    public void remove(Food a){
        for (int i = 0; i < count; i++){
            if(a.equals(food[i])){
                this.volumeNow -= a.getVolume();
                this.money += (int) ( a.getFats() * a.getProteins() / 10 + 1);
                if (i == count-1){
                    food[count-1] = null;
                    count--;
                } else {
                    for (int j = i+1; j < count; j++){
                        food[j-1] = food[j];
                    }
                    
                    food[count-1] = null;
                    count--;
                }
            }
            break;
        }
    }
    
    public void addMoney(int money){
        this.money += money;
    }

    public double getVolumeNow() {
        return volumeNow;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }
        
    public Food getMostFat(){
        double max = -100;
        int k = 0;
        for (int i = 0; i < this.count; i++){
            if (food[i].getFats() > max ){
                k = i;
                max = food[i].getFats();
            }
        }
        return food[k];
    }
    
    public Food getMostFresh(){
        int k = 0;
        Calendar a = food[0].getBestUntil();
        for (int i = 1; i < count;i++ ){
            if (a.before(food[i].getBestUntil())){
                a = food[i].getBestUntil();
                k = i;
            }
        }
        return food[k];
    }
    
    public double getTotalProteins(){
        double summ = 0;
        for (int i = 0; i < count; i++){
            summ += food[i].getProteins();
        }
        return summ;
    }
    
    public double getTotalFats(){
        double summ = 0;
        for(int i = 0; i < count; i++){
            summ += food[i].getFats();
        }
        return summ;
    }
    
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(2015, 11, 16);
        Food water = new Food("Water", c, 50, 0, 1);
        Fridge sony = new Fridge(20);
        sony.addMoney(1000);
        sony.add(water);
        Calendar b = Calendar.getInstance();
        b.set(2016, 03, 1);
        Food BonPari = new Food("BonPari", b, 0, 0.5, 10);
        sony.add(BonPari);
        System.out.println(sony.getMoney());
        System.out.println(sony.getCount());
        System.out.println(sony.getVolumeNow());
        System.out.println(sony.getMostFresh());
        System.out.println(sony.getMostFat());
        System.out.println(sony.getTotalFats());
        System.out.println(sony.getTotalProteins());
        sony.remove(water);
        System.out.println(sony.getMoney());
        System.out.println(sony.getVolumeNow());
    }
}