package edu.iu.habahram.coffeeorder.model;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public float cost() {
        return beverage.cost() + 0.25F;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
