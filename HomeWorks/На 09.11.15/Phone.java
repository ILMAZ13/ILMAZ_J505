public class Phone {
	private String model = "";
	private boolean hasSim = false;
	private boolean turnedOn = false;
	private String color = "";
	
	Phone(String model, String color){
		this.color = color;
		this.model = model;
	}
	
	public void setColor(String color){
		this.color  = color;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public boolean getHasSimStatus(){
		return this.hasSim;
	}
	
	public boolean getTunrnedOnStatus(){
		return this.turnedOn;
	}
	
	public void turnOff(){
		this.turnedOn = false;
	}
	
	public void turnOn(){
		this.turnedOn = true;
	}
	
	public void putSim(){
		this.hasSim = true;
	}
	
	public void removeSim(){
		this.hasSim = false;
	}
	
	
	
	public void callTo(String number){
		boolean f = true;
		for (int i = 0; i < number.length() ; i++){
			if ((number.charAt(i) < '0') || (number.charAt(i) > '9')){
				f = false;
			}
		}
		if (this.getHasSimStatus() && this.getTunrnedOnStatus() && f){
			System.out.println("Calling to the number " + number);
		} else {
			System.out.println("Calling error");
		}
	}
	
	public static void main(String[] args){
		Marker mar = new Marker("red");
		Phone nokia = new Phone("Nokia","blue");
		mar.changeColorOf(nokia);
		System.out.println(nokia.getColor());
		nokia.turnOn();
		nokia.putSim();
		nokia.callTo("7482947234");
		nokia.callTo("1234u");
	}
}