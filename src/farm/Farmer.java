package farm;


import Filter.Fields;
import PurchaseHistory.PurchaseHistory;
import Shop.Shop;
import WH.Warehouse;
import farm.facade.SeederFacade;

//A person who work in a farm 
public class Farmer extends Employee{
	SeederFacade seeder;

	//Initialize
	public Farmer(String n){
		name=n;
		cost=3000;
	}
	
	public Farmer(){
		this("farmer");
	}	
	
	@Override	
	public boolean isNil() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}


	//Plant a certain amount(param count) of a certain crops(param name)
	public void sow(Fields f, String n, int c){
		if(f==null||n==""||c<=0){
			System.out.println("Type Error.");
			return;
		}
		if(seeder==null) {
			seeder=new SeederFacade();
		}
		System.out.println("Farmer "+name+" is sowing "+n+".");
		if(seeder.sow(f,n, c)){
  			work();
		}else
			System.out.println("Sow Fail.");
	}

	//Sell a certain amount(param count) of products(param name)
	public void sell(String n,int c){
		Warehouse wh= Warehouse.getInstance();
		System.out.println("Farmer "+ name+" is selling "+n+".");
		if(wh.sellProduct(n,c)){
			work();
		}else
			System.out.println("Sell Fail.");

	}

	//Buy a certain amount(param count) of objects(param name)
	public void buy(String n,int c){
		System.out.println("Farmer "+ name+" is buying "+n+".");
		if(Shop.purchase(n,c)){
			work();
			//Add purchase info to PurchaseHistory
			PurchaseHistory.setPurchaseHistory(name, n, String.valueOf(c));
		}else
			System.out.println("Purchase Fail.");

	}

	//Apply certain type(param c) of Fertilizer in Field numbered praram k
	public void applyFertilizer(Fields f, String c, Integer k){
		Warehouse wh= Warehouse.getInstance();
		if(wh.reduceItem(c,1)){
			System.out.println("Farmer "+ name+" is fertilizing "+c+" in field"+k+".");
			if(f.applyFertilizer(c,k))
				work();
			else
				System.out.println("Apply Fertilizer Fail.");
		}
	}

	//Charge seeder.
	public void chargeSeeder(){
		seeder.charge();
	}

	//Sell all products
	public void sellAll(){
		Warehouse wh= Warehouse.getInstance();
		System.out.println("Farmer "+ name+" is selling all products.");
		if(wh.sellAll())
			work();
		else
			System.out.println("Sell All Fail.");
	}

	//Harvest crops growing on Field numbered praram k
	public void harvest(Fields f, Integer k){
		System.out.println("Farmer "+ name+" is harvesting crops in field"+k+".");
		if(f.harvest(k)){
			work();
		}else
			System.out.println("Harvest Fail.");

	}

	//Harvest all crops
	public void harvestAll(Fields f){
		System.out.println("Farmer "+ name+" is harvesting all crops.");
		if(f.harvestAll()){
			work();
		}else
			System.out.println("Harvest All Fail.");

	}

	//To show this farmer is decorated(equipped) with what tools
	public void showDecoration(){}
	//Do something with the tools a farmer has
	public void doMower(){}
	public void doWateringPot(){}
	public void doShovel(){}
}
