package Adapter;

import farm.strategy.Donkey;

public class Stone {
    private double weight;

    public Stone(double weight){
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }

   public boolean move(Donkey donkey){
        boolean result;
        result=(this.getWeight()<=donkey.getStrength());
        return result;
    }
}
