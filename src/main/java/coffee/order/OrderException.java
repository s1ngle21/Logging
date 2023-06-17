package coffee.order;

public class OrderException extends RuntimeException {
    public OrderException() {
        super();
    }

    public OrderException(String message) {
        super(message);
    }
}
