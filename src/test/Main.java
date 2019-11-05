package test;

import BuildFarm.CommonFarmBuilder;
import BuildFarm.Director;
import BuildFarm.Farm;
import Filter.Field;
import Filter.Fields;
import PurchaseHistory.PurchaseHistory;
import Shop.Shop;
import Tools.*;
import Visitor.FieldVisitor;
import WH.Warehouse;
import Weather.WeatherToday;
import farm.Owner;
import frontController.FrontController;
import interceptingFilter.AuthenticationFilter;
import interceptingFilter.Client;
import interceptingFilter.DebugFilter;
import interceptingFilter.FilterManager;
import theme.Theme;
import theme.ThemeFactory;
import Service.*;


public class Main {

    public static void main(String[] args) {
        //test login and logout service
        System.out.println("\n------Service Locator Pattern-------\n");
        Service service = ServiceLocator.getService("LoginService");
        service.execute();
        service = ServiceLocator.getService("LogoutService");
        service.execute();
        service = ServiceLocator.getService("LoginService");
        service.execute();

        //Processing the request is scene switching, so frontcontroller is used as the target object to process the request
        //test Front Controller and interceptingFilter
        System.out.println("\n------Front Controller Pattern and Intercepting Filter Pattern-------\n");
        FilterManager filterManager = new FilterManager(new FrontController());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        Client client = Client.getInstance();
        client.setFilterManager(filterManager);
        //Make initial page request (front controller mode)
        client.sendRequest("HOME");
        //initial
        System.out.println("Welcome to the Harmonious Farm!");
        FieldVisitor fieldVisitor = new FieldVisitor();
        WeatherToday weatherToday = new WeatherToday();
        System.out.println("Choose where you go:1 farm 2 ranch 3 staff");
        System.out.println("1");

        //Make farm page request (front controller mode)
        client.sendRequest("FARM");

        //test Factory Pattern
        System.out.println("\n------Factory Pattern------\n");
        System.out.println("Please select the theme of the farm(Manor,Rainforest,Snowfield):");
        System.out.println("Manor");
        ThemeFactory themeFactory = new ThemeFactory();
        Theme t = themeFactory.getTheme("Manor");
        t.loadTheme();

        //test Builder Pattern
        System.out.println("\n------Builder Pattern------\n");
        System.out.println("Choose the farm construction type:");
        System.out.println("1 common 2 super");
        System.out.println("1");
        Farm farm;
        Director directorC = new Director(new CommonFarmBuilder());
        farm = directorC.construct();
        farm.showDetails();
        //initial
        Warehouse w = Warehouse.getInstance();
        Fields f = farm.getFields();
        Owner owner = new Owner();
        //Composite pattern prepare
        Bag myBag = new Bag(new Hoe(), new Bag(new Shovel(), new Bag(new Sickle())));

        //test Observer
        System.out.println("\n------Observer Patten------\n");
        for (Field field : f.fields) {
            weatherToday.attach(field);
        }
        weatherToday.setWeather("rainy");
        //test Prototype Pattern&Abstract Factory Pattern
        System.out.println("\n------Prototype Pattern&Abstract Factory Pattern------\n");
        System.out.println("Your funds：" + Shop.fund);
        System.out.println("Please enter your choice number!");
        System.out.println("1 Shop 2 View warehouse 3 Sell crop 4 Sell all crop \n" +
                "5 Plant 6 Harvest 7 Harvest all 8 View fields 9 Upgrade field \n" +
                "10 Apply fertilizer 11 Show tool bag 12 Hire farmer 13 View purchase History \n" +
                "0 Exit");
        System.out.println("1");
        Shop.showCatalogue();
        System.out.println("Please enter the name of the product you want to buy.");
        System.out.println("Cabbage");
        System.out.println("Please enter the quantity of goods to buy.");
        System.out.println("3");
        owner.buy("Cabbage", 3);
        //test Flyweight Pattern&Abstract Factory Pattern
        System.out.println("\n------Flyweight Pattern&Abstract Factory Pattern------\n");
        System.out.println("Your funds：" + Shop.fund);
        System.out.println("Please enter your choice number!");
        System.out.println("1");
        Shop.showCatalogue();
        System.out.println("Please enter the name of the product you want to buy.");
        System.out.println("SuperF");
        System.out.println("Please enter the quantity of goods to buy.");
        System.out.println("1");
        owner.buy("SuperF", 1);
        //test Composite Entity
        System.out.println("\n------Composite Entity Pattern------\n");
        System.out.println("Purchase History:");
        PurchaseHistory.getPurchaseHistory();
        //test Facade Pattern&Command Pattern
        System.out.println("\n------Facade Pattern&Command Pattern------\n");
        System.out.println("Please enter your choice number!");
        System.out.println("5");
        System.out.println("Please enter the name of the crop to be planted.");
        System.out.println("Cabbage");
        System.out.println("Please input the number of seeds.");
        System.out.println("3");
        owner.sow(f, "Cabbage", 3);
        //test Facade Pattern&Command Pattern
        System.out.println("\n------Facade Pattern&Command Pattern------\n");
        System.out.println("Please enter your choice number!");
        System.out.println("10");
        System.out.println("Please enter the type of fertilizer.(NormalF AdvancedF SuperF)");
        System.out.println("SuperF");
        System.out.println("Please input the field number to be fertilized.");
        System.out.println("1");
        owner.applyFertilizer(f, "SuperF", 1);
        //test State Pattern
        System.out.println("\n------State Pattern------\n");
        System.out.println("In fact, plant growth is a task of new threads. \n" +
                "The main interface can continue to operate normally. \n" +
                "However, in order to show the state mode, let the main program sleep until the plant matures, \n" +
                "you will find the effect of fertilization or not.");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //test Filter Pattern
        System.out.println("\n------Filter Pattern------\n");
        System.out.println("Please enter your choice number!");
        System.out.println("8");
        f.showDetail();
        //test Visitor Patten
        System.out.println("\n------Visitor Patten-------\n");
        for (Field field : Fields.fields) {
            //Visitor Patten
            field.accept(fieldVisitor);
        }
        //test Facade Pattern&Command Pattern
        System.out.println("\n------Facade Pattern&Command Pattern------\n");
        System.out.println("Please enter your choice number!");
        System.out.println("7");
        owner.harvestAll(f);
        //test Singleton Pattern
        System.out.println("\n------Singleton Pattern------\n");
        System.out.println("Please enter your choice number!");
        System.out.println("2");
        w.showItems();
        //test Singleton Pattern
        System.out.println("\n------Singleton Pattern------\n");
        System.out.println("Please enter your choice number!");
        System.out.println("4");
        owner.sellAll();
        System.out.println("Your funds：" + Shop.fund);
        //test Composite Pattern
        System.out.println("\n------Composite Pattern------\n");
        System.out.println("Please enter your choice number!");
        System.out.println("11");
        System.out.println("Tool bag contains:");
        myBag.show(0);

        System.out.println("\n------Service Locator Pattern-------\n");
        service = ServiceLocator.getService("LogoutService");
        service.execute();
    }
}