// OrderRepository.java
package edu.iu.habahram.coffeeorder.repository;

import org.springframework.stereotype.Component;
import edu.iu.habahram.coffeeorder.model.OrderData;
import edu.iu.habahram.coffeeorder.model.Receipt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class OrderRepository {
    private final AtomicInteger idCounter = new AtomicInteger(0);

    public Receipt add(OrderData order) throws IOException {
        int orderId = idCounter.incrementAndGet();
        float totalCost = calculateTotalCost(order);

        // Write order to the database
        writeOrderToDatabase(orderId, totalCost, order);

        return new Receipt(orderId, order.beverage(), totalCost);
    }

    private float calculateTotalCost(OrderData order) {
        float totalCost = switch (order.beverage()) {
            case "DarkRoast" -> 1.99F;
            case "HouseBlend" -> 1.65F;
            case "Espresso" -> 1.34F;
            case "Decaf" -> 1.28F;
            default -> throw new IllegalArgumentException("Invalid beverage: " + order.beverage());
        };

        for (String condiment : order.condiments()) {
            totalCost += switch (condiment) {
                case "Milk" -> 0.4F;
                case "Mocha" -> 0.3F;
                case "Whip" -> 0.25F;
                case "Soy" -> 0.27F;
                default -> throw new IllegalArgumentException("Invalid condiment: " + condiment);
            };
        }

        return totalCost;
    }

    private void writeOrderToDatabase(int orderId, float totalCost, OrderData order) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("db.txt", true))) {
            writer.write(orderId + ", " + totalCost + ", " + order.beverage());
            for (String condiment : order.condiments()) {
                writer.write(", " + condiment);
            }
            writer.newLine();
        }
    }
}

