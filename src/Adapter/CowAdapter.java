package Adapter;

import farm.strategy.Cow;
import farm.strategy.Donkey;

public class CowAdapter extends Donkey {
    private Cow alternative;

    public CowAdapter(Cow cow){
        this.alternative=cow;
    }

    @Override
    public int getStrength(){
        return alternative.getStrength();
    }
}
