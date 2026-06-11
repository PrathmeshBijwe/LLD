// ❌ Wrong Approach: One interface for all payment types
/*
interface PaymentGateway {
    void payWithCreditCard();
    void payWithUPI();
    void payWithWallet();
}

class CreditCardGateway implements PaymentGateway {
    public void payWithCreditCard() { System.out.println("Paid with Credit Card"); }
    public void payWithUPI() { throw new UnsupportedOperationException("Not supported"); }
    public void payWithWallet() { throw new UnsupportedOperationException("Not supported"); }
}
*/

// ✅ Correct Approach: Separate interfaces
interface CreditCardPayment {
    void payWithCreditCard();
}

interface UPIPayment {
    void payWithUPI();
}

interface WalletPayment {
    void payWithWallet();
}

class CreditCardGateway implements CreditCardPayment {
    public void payWithCreditCard() { System.out.println("Paid with Credit Card"); }
}

class UPIGateway implements UPIPayment {
    public void payWithUPI() { System.out.println("Paid with UPI"); }
}

class WalletGateway implements WalletPayment {
    public void payWithWallet() { System.out.println("Paid with Wallet"); }
}
