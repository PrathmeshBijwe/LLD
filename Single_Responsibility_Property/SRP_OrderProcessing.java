// Handles only calculations
class OrderCalculator {
    public void calculate(String orderId) {
        System.out.println("Calculating total for order " + orderId);
    }
}

// Handles only persistence
class OrderRepository {
    public void save(String orderId) {
        System.out.println("Saving order " + orderId + " to database");
    }
}

// Handles only notifications
class NotificationService {
    public void sendConfirmation(String orderId) {
        System.out.println("Sending confirmation for order " + orderId);
    }
}

// Coordinates the workflow
class OrderService {
    private OrderCalculator calculator;
    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderCalculator calculator,
                        OrderRepository repository,
                        NotificationService notification) {
        this.calculator = calculator;
        this.repository = repository;
        this.notification = notification;
    }

    public void processOrder(String orderId) {
        calculator.calculate(orderId);
        repository.save(orderId);
        notification.sendConfirmation(orderId);
    }
}

// Main runner
public class SRP_OrderExample {
    public static void main(String[] args) {
        OrderCalculator calculator = new OrderCalculator();
        OrderRepository repository = new OrderRepository();
        NotificationService notification = new NotificationService();

        OrderService orderService = new OrderService(calculator, repository, notification);
        orderService.processOrder("ORD123");
    }
}
