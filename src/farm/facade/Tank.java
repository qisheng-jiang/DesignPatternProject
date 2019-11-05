package farm.facade;

//The seeder comes with a water tank when it works
public class Tank {
	private double capacity;//up to 500 L

	//initialize
	Tank(double c){
		capacity=c;
	}
	
	Tank(){
		this(500);
	}
	
	//Seeder need to consume water every time it works
	public boolean takeWater(int c) {
		double used=c*2.5;
		if(used<=0) {
			System.out.println("Invalid Quantity!");
			return false;
		}
		while(used>capacity) {
			System.out.println("There is "+String.format("%.1f",capacity)+"L water left.");
			fill();
		}
		capacity-=used;
		return true;
	}
	
	//Fill the tank
	public void fill() {
		System.out.println("Tank is filling...");
		try{
			Thread.sleep(300);
			capacity=500;
			System.out.println("Tank is filled.");
		}catch(Exception e){
			System.out.println("Addition Fail.");
		}

	}
}
