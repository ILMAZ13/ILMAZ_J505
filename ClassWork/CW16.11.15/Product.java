

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;


class Product{
    private String name;
    private final String manufacturer;
    private int price;
    private final GregorianCalendar bestUntil;
    private final int weight;
    private final String[] country = {"ru" , "fr", "ch"};
    private boolean legal;
    
    public Product(String name, String manufacturer, int price, GregorianCalendar bestUntil, int weight) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.bestUntil = bestUntil;
        this.weight = weight;
        boolean f = false;
        for (int i = 0; i < this.country.length; i++){
            if(this.country[i].equals(this.manufacturer)){
                f = true;
                break;
            }
        }
        this.legal = f;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public GregorianCalendar getBestUntil() {
        return bestUntil;
    }

    public int getWeight() {
        return weight;
    }
    
    public boolean getFreshStatus(){
        GregorianCalendar now = new GregorianCalendar();
        return (this.bestUntil.after(now));
    }
    
    public boolean getLegalStatus(){
        return this.legal;
    }

    public String toString() {
        return name + " " + manufacturer + " " + price + "r best until " + bestUntil + " " + weight + "kg is legal=" + legal + " is fresh=" + this.getFreshStatus();
    }

    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.manufacturer);
        hash = 13 * hash + this.weight;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.bestUntil, other.bestUntil)) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        return true;
    }
    
    
    
    public static void main(String[] args){
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(2015, 9, 10);
        
        Product a = new  Product("pie","ru", 1000, 35);
		System.out.println(a);
    }
    
    
}


