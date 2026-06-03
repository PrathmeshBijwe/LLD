// Handles only validation
class PaymentValidator {
    public boolean validate(String user, double amount) {
        System.out.println("Validating payment for " + user);
        return amount > 0; // simple rule
    }
}

// Handles only processing
class PaymentProcessor {
    public void process(String user, double amount) {
        System.out.println("Processing payment of " + amount + " for " + user);
    }
}

// Handles only logging
class TransactionLogger {
    public void log(String user, double amount) {
        System.out.println("Logging transaction: " + user + " paid " + amount);
    }
}

// Coordinates the workflow
class PaymentService {
    private PaymentValidator validator;
    private PaymentProcessor processor;
    private TransactionLogger logger;

    public PaymentService(PaymentValidator validator,
                          PaymentProcessor processor,
                          TransactionLogger logger) {
        this.validator = validator;
        this.processor = processor;
        this.logger = logger;
    }

    public void makePayment(String user, double amount) {
        if (validator.validate(user, amount)) {
            processor.process(user, amount);
            logger.log(user, amount);
        } else {
            System.out.println("Payment failed: invalid amount");
        }
    }
}

// Runner
public class SRP_PaymentExample {
    public static void main(String[] args) {
        PaymentValidator validator = new PaymentValidator();
        PaymentProcessor processor = new PaymentProcessor();
        TransactionLogger logger = new TransactionLogger();

        PaymentService paymentService = new PaymentService(validator, processor, logger);

        paymentService.makePayment("Prathmesh", 500.0);
        paymentService.makePayment("Prathmesh", -100.0); // invalid
    }
}
