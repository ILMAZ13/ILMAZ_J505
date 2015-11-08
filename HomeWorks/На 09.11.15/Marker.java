class Marker{
	private String color = "";
	
	Marker(String color){
		this.color = color;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void changeColorOf(Phone a){
		a.setColor(this.getColor());
	}
	
	public void write(String s){
		System.out.println(s);
	}
	
}