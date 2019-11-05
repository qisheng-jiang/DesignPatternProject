package patternTest;

import Adapter.CowAdapter;
import Adapter.Stone;
import farm.strategy.Cow;
import farm.strategy.Donkey;

public class AdapterTest {
    public static void adaptertest(){
        System.out.println("\nadapterTest (Adapter Pattern)\n");

        Stone stone=new Stone(400);
        Donkey donkey=new Donkey();
        Cow cow=new Cow();

        if(stone.move(donkey)){
            System.out.println("Stone is moved by Donkey");
        }

        CowAdapter cowAdapter=new CowAdapter(cow);
        if(stone.move(cowAdapter)){
            System.out.println("Stone is moved by Cow");
        }
    }
}
