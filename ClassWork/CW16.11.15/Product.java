

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
	
	public String getDate(){
        int i = this.getBestUntil().toString().indexOf("DAY_OF_MONTH=") + 13;
		String s = this.getBestUntil().toString().substring(i + 1, i + 2);
		if (('0' <= s.charAt(0)) && ('9' >= s.charAt(0))){
			return this.getBestUntil().toString().substring(i, i+2);
		} else {
			return this.getBestUntil().toString().substring(i, i+1);
		}
        
    }
	
	public String getMonth(){
		int i = this.getBestUntil().toString().indexOf("MONTH=") + 6;
        String s = this.getBestUntil().toString().substring(i + 1, i + 2);
		if (('0' <= s.charAt(0)) && ('9' >= s.charAt(0))){
			return this.getBestUntil().toString().substring(i, i+2);
		} else {
			return this.getBestUntil().toString().substring(i, i+1);
		}
	}
	
	public String getYear(){
		int i = this.getBestUntil().toString().indexOf("YEAR=") + 5;
			return this.getBestUntil().toString().substring(i, i+4);
	}

    public String toString() {
        return name + "; " + manufacturer + "; " + price + "rubls; best until:" + getDate() + "." + getMonth() + "." + getYear() + "; " + weight + "kg; is legal=" + legal + "; is fresh=" + this.getFreshStatus();
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
        cal.set(2015, 11, 1);
		GregorianCalendar cal1 = new GregorianCalendar();
        cal1.set(2015,9,14);
        Product a = new  Product("pie","ru", 1000, cal, 35);
		Product b = new  Product("MEAT","kh", 5000, cal1, 35);
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.equals(b));
    }
    
    
}


