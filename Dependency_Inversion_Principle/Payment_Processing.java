// ❌ Wrong Approach
/*
class CreditCardProcessor {
    public void process(double amount) {
        System.out.println("Processed credit card payment: " + amount);
    }
}

class PaymentService {
    private CreditCardProcessor processor = new CreditCardProcessor();

    public void pay(double amount) {
        processor.process(amount);
    }
}
*/

// ✅ Correct Approach
interface PaymentProcessor {
    void process(double amount);
}

class CreditCardProcessor implements PaymentProcessor {
    public void process(double amount) {
        System.out.println("Processed credit card payment: " + amount);
    }
}

class UPIPaymentProcessor implements PaymentProcessor {
    public void process(double amount) {
        System.out.println("Processed UPI payment: " + amount);
    }
}

class PaymentService {
    private PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void pay(double amount) {
        processor.process(amount);
    }
}
