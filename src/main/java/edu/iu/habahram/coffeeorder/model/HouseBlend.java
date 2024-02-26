package edu.iu.habahram.coffeeorder.model;

public class HouseBlend extends Beverage {
    @Override
    public String getDescription() {
        return "House Blend";
    }

    @Override
    public float cost() {
        return 1.65F;
    }
}