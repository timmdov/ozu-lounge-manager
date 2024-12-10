package factories;
import interfaces.Product;
import models.Coffee;

public class CoffeeFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Coffee();
    }
}