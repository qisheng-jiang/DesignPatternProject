package farm.facade;

import Filter.Fields;
import WH.Warehouse;

/*
 * Facade Pattern
 * Plant seeds with a seeder
 * param name is the type of the seed,count is the quality of the seed to be sown(per 100).
 */
public class SeederFacade {
	private Tank tank;
	private double battery;

	
	//Create seeder.
	public SeederFacade(){
		battery=100;
		tank=new Tank();
	}
	
	//The seeder works.
	public boolean sow(Fields f,String s,int count) {
		String seed=s+"S";
		Warehouse w= Warehouse.getInstance();

		if(!w.reduceItem(seed,count)){//get seeds failed.
			System.out.println("get seeds failed");
			return false;
		}
		if(f.plant(s,count)){//have enough fields to sow plants.
			tank.takeWater(count);
			consumpt(count);
			return true;
		}else{
			System.out.println("sow seeds failed");
			w.addItem(seed,count);//return the seed.
			return false;
		}

	}
	
	//The seeder needs to consume electric power when it works.
	private boolean consumpt(int count) {
		double used=count*1.5;
		if(used<=0) {
			System.out.println("Invalid Quantity!");
			return false;
		}
		if(used>battery) {
			System.out.println("Seeder is only "+String.format("%.1f",battery)+"% power left.Charge it please.");
			charge();
		}
		battery-=used;
		return true;
	}
	
	//charge the seeder.
	public void charge() {
		System.out.println("SeederFacade is charging...");
		try{
			Thread.sleep(400);
			battery=100;
			System.out.println("SeederFacade is fully charged.");
		}catch(Exception e){
			System.out.println("Charge Fail.");
		}
	}
}