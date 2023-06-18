package coffee.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Yoda");
        coffeeOrderBoard.add("Obi-Wan");
        coffeeOrderBoard.add("Vader");
        coffeeOrderBoard.add("Luke");

        LOGGER.info(coffeeOrderBoard.draw());

        coffeeOrderBoard.deliver();

        LOGGER.info(coffeeOrderBoard.draw());

        coffeeOrderBoard.deliver(3);

    }
}
