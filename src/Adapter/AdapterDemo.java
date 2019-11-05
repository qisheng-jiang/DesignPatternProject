package Adapter;

import farm.strategy.Cow;
import farm.strategy.Donkey;

public class AdapterDemo {
    public static void main(String[] args){
        Stone stone=new Stone(400);
        Donkey donkey=new Donkey();
        Cow cow=new Cow();

        if(stone.move(donkey)){
            System.out.println(donkey.getStrength()+"Stone is moved by Donkey");
        }

        CowAdapter cowAdapter=new CowAdapter(cow);
        if(stone.move(cowAdapter)){
            System.out.println(cowAdapter.getStrength()+"Stone is moved by Cow");
        }
    }
}
