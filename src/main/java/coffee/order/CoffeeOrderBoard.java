package coffee.order;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CoffeeOrderBoard {

private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private Queue<Order> orderQueue;
    private long maxOrderNum = 1;

    public CoffeeOrderBoard() {
        this.orderQueue = new LinkedList<>();
    }

    public void add(String customerName) {
        Order order = new Order(maxOrderNum, customerName);
        maxOrderNum = order.getOrderNumber();
        orderQueue.add(order);
        LOGGER.info("Order with NUMBER: [" + maxOrderNum + "] has been added to the name: " + customerName);
        maxOrderNum++;
    }

    public void deliver() {
        if (orderQueue.isEmpty()) {
            throw new OrderException("No orders in queue");
        }
        Order order = orderQueue.poll();
        LOGGER.info("Order with NUMBER: [" + order.getOrderNumber() + "] has been placed to " + order.getCustomerName());
    }

    public void deliver(final int orderNum) {
        LOGGER.info("Received order number for delivery is: " + orderNum);
        if (orderNum < 0) {
            throw new OrderException("Order number must be above 0!");
        }
        Order order = orderQueue.stream()
                .filter(o -> o.getOrderNumber() == orderNum)
                .findFirst()
                .orElseThrow(() -> new OrderException("There is no order with such order number: " + orderNum));
        orderQueue.remove(order);
        LOGGER.info("Order with NUMBER: [" + order.getOrderNumber() + "] has been placed to " + order.getCustomerName());
    }


    public String draw() {
        String res = "Num | Name\n";
        String ordersString = "";
        for (Order order : orderQueue) {
            ordersString = order.getOrderNumber() + " | " + order.getCustomerName() + "\n";
            res = res + ordersString;
        }
        return res;
    }
}
