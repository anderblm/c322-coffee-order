package edu.iu.habahram.coffeeorder.model;

import java.util.List;

public record OrderData(String beverage, List<String> condiments) {
}
