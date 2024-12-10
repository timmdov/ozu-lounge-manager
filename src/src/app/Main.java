package app;
import decorators.*;
import interfaces.*;
import models.*;
import factories.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        Ticket ticket = new EconomyTicket();
        System.out.println("Ticket Description: " + ticket.getDescription());
        System.out.println("Ticket Price: $" + ticket.getPrice());
        System.out.println(" ");

        ticket = new ExtraLegRoom(ticket);
        System.out.println("Ticket Description: " + ticket.getDescription());
        System.out.println("Ticket Price: $" + ticket.getPrice());
        System.out.println(" ");

        ticket = new EmergencyExit(ticket);
        System.out.println("Ticket Description: " + ticket.getDescription());
        System.out.println("Ticket Price: $" + ticket.getPrice());
        System.out.println(" ");

        ticket = new TheOzuExperience(ticket);
        System.out.println("Ticket Description: " + ticket.getDescription());
        System.out.println("Ticket Price: $" + ticket.getPrice());
        System.out.println(" ");

        ProductFactory pizzaFactory = new PizzaFactory();
        Product pizza = pizzaFactory.createProduct();
        System.out.println("Pizza Description: " + pizza.getDescription());
        System.out.println("Pizza Price" + " - $" + pizza.getPrice());
        System.out.println(" ");

        pizza = new Salami(pizza);
        System.out.println("Pizza Description: " + pizza.getDescription());
        System.out.println("Pizza Price" + " - $" + pizza.getPrice());
        System.out.println(" ");

        pizza = new Jalapeno(pizza);
        System.out.println("Pizza Description: " + pizza.getDescription());
        System.out.println("Pizza Price" + " - $" + pizza.getPrice());
        System.out.println(" ");

        ProductFactory coffeeFactory = new CoffeeFactory();
        Product coffee = coffeeFactory.createProduct();
        System.out.println("Coffee Description: " + coffee.getDescription());
        System.out.println("Coffee Price" + " - $" + coffee.getPrice());
        System.out.println(" ");

        coffee = new ExtraEspressoShot(coffee);
        System.out.println("Coffee Description: " + coffee.getDescription());
        System.out.println("Coffee Price" + " - $" + coffee.getPrice());
        System.out.println(" ");

        coffee = new ExtraEspressoShot(coffee);
        System.out.println("Coffee Description: " + coffee.getDescription());
        System.out.println("Coffee Price" + " - $" + coffee.getPrice());
        System.out.println(" ");

        IceCreamFactory iceCreamFactory = new IceCreamFactory();
        Product iceCream = iceCreamFactory.createProduct();
        System.out.println("Ice Cream Description: " + iceCream.getDescription());
        System.out.println("Ice Cream Price" + " - $" + iceCream.getPrice());
        System.out.println(" ");

        iceCream = new VanillaScoop(iceCream);
        System.out.println("Ice Cream Description: " + iceCream.getDescription());
        System.out.println("Ice Cream Price" + " - $" + iceCream.getPrice());
        System.out.println(" ");

        iceCream = new VanillaScoop(iceCream);
        System.out.println("Ice Cream Description: " + iceCream.getDescription());
        System.out.println("Ice Cream Price" + " - $" + iceCream.getPrice());
        System.out.println(" ");

        iceCream = new ChocolateScoop(iceCream);
        System.out.println("Ice Cream Description: " + iceCream.getDescription());
        System.out.println("Ice Cream Price" + " - $" + iceCream.getPrice());
        System.out.println(" ");

        System.out.println("Processing Pizza Order:");
        OrderProcess pizzaOrder = new PizzaOrder();
        pizzaOrder.processOrder();
        System.out.println();
        System.out.println(" ");

        System.out.println("Processing Coffee Order:");
        OrderProcess coffeeOrder = new CoffeeOrder();
        coffeeOrder.processOrder();
        System.out.println();
        System.out.println(" ");

        System.out.println("Processing Ice Cream Order:");
        OrderProcess iceCreamOrder = new IceCreamOrder();
        iceCreamOrder.processOrder();
        System.out.println(" ");

        Product pizzaCompOrder = new PizzaFactory().createProduct();
        Product coffeeCompOrder = new CoffeeFactory().createProduct();
        Product iceCreamCompOrder = new IceCreamFactory().createProduct();

        CompositeProduct compOrder = new CompositeProduct();
        compOrder.addProduct(pizzaCompOrder);
        compOrder.addProduct(coffeeCompOrder);
        compOrder.addProduct(iceCreamCompOrder);

        System.out.println("Meal Package Description: " + compOrder.getDescription());
        System.out.println("Meal Package Price: $" + compOrder.getPrice());
        System.out.println(" ");

        LoungeService loungeService = LoungeService.getInstance();

        Ticket ticket1 = new EconomyTicket();
        ticket1 = new ExtraLegRoom(ticket1);
        ticket1 = new EmergencyExit(ticket1);
        loungeService.addTicket(ticket1);

        Ticket ticket2 = new EconomyTicket();
        ticket2 = new ExtraLegRoom(ticket2);
        loungeService.addTicket(ticket2);

        Product pizzaLounge = new PizzaFactory().createProduct();
        pizzaLounge = new Salami(pizzaLounge);
        loungeService.addOrder(pizzaLounge);

        Product coffeeLounge = new CoffeeFactory().createProduct();
        coffeeLounge = new ExtraEspressoShot(coffeeLounge);
        coffeeLounge = new ExtraEspressoShot(coffeeLounge);
        loungeService.addOrder(coffeeLounge);

        Product iceCreamLounge = new IceCreamFactory().createProduct();
        iceCreamLounge = new VanillaScoop(iceCreamLounge);
        iceCreamLounge = new VanillaScoop(iceCreamLounge);
        iceCreamLounge = new ChocolateScoop(iceCreamLounge);
        loungeService.addOrder(iceCreamLounge);

        CompositeProduct mealPackage = new CompositeProduct();
        mealPackage.addProduct(pizzaLounge);
        mealPackage.addProduct(coffeeLounge);
        mealPackage.addProduct(iceCreamLounge);
        loungeService.addOrder(mealPackage);

        loungeService.displaySummary();
    }
}