// Common interface
interface PaymentMethod {
    void pay();
}

// Different implementations
class CreditCardPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Processing credit card payment");
    }
}

class UPIPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Processing UPI payment");
    }
}

class WalletPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Processing wallet payment");
    }
}

// Service depends on abstraction
class PaymentService {
    private PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment() {
        paymentMethod.pay();
    }
}

// Runner
public class Main {
    public static void main(String[] args) {
        PaymentService service1 = new PaymentService(new CreditCardPayment());
        service1.processPayment();

        PaymentService service2 = new PaymentService(new UPIPayment());
        service2.processPayment();

        PaymentService service3 = new PaymentService(new WalletPayment());
        service3.processPayment();
    }
}
