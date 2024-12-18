package decorators.pizzaDecorators;
import interfaces.Product;


public class Jalapeno extends PizzaDecorator {
    public Jalapeno(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + ", Jalapeno";
    }

    @Override
    public double getPrice() {
        return product.getPrice() + 0.50;
    }
}