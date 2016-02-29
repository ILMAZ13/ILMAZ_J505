import java.util.Calendar;

public class Food {
    String name;
    private Calendar bestUntil;
    private double fats;
    private double proteins;
    private double volume;

    public Food(String name, Calendar bestUntil, double fats, double proteins, double volume) {
        this.name = name;
        this.bestUntil = bestUntil;
        this.fats = fats;
        this.proteins = proteins;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }
    
    public int getDate(){
      int i = this.getBestUntil().toString().indexOf("DAY_OF_MONTH=") + 13;
      String s = this.getBestUntil().toString().substring(i+1, i+2);
      if (('0' <= s.charAt(0)) && ('9' >= s.charAt(0))){
        return Integer.parseInt(this.getBestUntil().toString().substring(i, i+2));
      } else 
        { 
        return Integer.parseInt(this.getBestUntil().toString().substring(i, i+1));
      }
    }
 
    public int getMonth(){
      int i = this.getBestUntil().toString().indexOf("MONTH=") + 6;
      String s = this.getBestUntil().toString().substring(i+1, i+2);
      if (('0' <= s.charAt(0)) && ('9' >= s.charAt(0))){
        return Integer.parseInt(this.getBestUntil().toString().substring(i, i+2));
      } else     
        { 
        return Integer.parseInt(this.getBestUntil().toString().substring(i, i+1));
      }
    }
    
    public int getYear(){
       int i = this.getBestUntil().toString().indexOf("YEAR=") + 5;
        return Integer.parseInt(this.getBestUntil().toString().substring(i, i+4));
    }
        
    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBestUntil() {
        return bestUntil;
    }

    public double getFats() {
        return fats;
    }

    public double getProteins() {
        return proteins;
    }

    public double getVolume() {
        return volume;
    }
    public boolean fresh() {
        Calendar now = Calendar.getInstance();
        return this.bestUntil.after(now);
    }

    public boolean healthy() {
        if (this.fats <= this.proteins) return true;
        else return false;
    }
    
      public String toString() {
        return this.name + ";  Fats: " + this.fats + "; Best until:" + this.getDate() + "." + this.getMonth() + "." + this.getYear() +  ";  Proteins: " + this.proteins + ";  Volume: " + this.volume + ";  Fresh: "  + fresh() + ";  Healthy: " + healthy();
    }
    
   @Override
    public boolean equals(Object obj) {
        Food other = (Food) obj;
        if (this.getClass() != other.getClass()) return false;
        if (this.bestUntil != other.getBestUntil()) return false;
        if (this.fats != other.getFats()) return false;
        if (this.proteins != other.getProteins()) return false;
        if (this.volume != other.getVolume()) return false;
        return true;
    }
    
        /*public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2015, 11, 16);
        Food water = new Food("Water", c, 0, 0, 0.1);
        System.out.println(water.toString());
        System.out.println(water.getDate());
        System.out.println(water.getMonth());
        System.out.println(water.getYear());
        Calendar b = Calendar.getInstance();
        b.set(2016, 03, 1);
        Food BonPari = new Food("BonPari", b, 0, 0.5, 98);
        System.out.println(BonPari.toString());
        System.out.println(BonPari.getDate());
        System.out.println(BonPari.getMonth());
        System.out.println(BonPari.getYear());

    }*/

}

 