package edu.iu.habahram.coffeeorder.model;

public class Milk extends CondimentDecorator{
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public float cost() {
        return  beverage.cost() + 0.4F;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
