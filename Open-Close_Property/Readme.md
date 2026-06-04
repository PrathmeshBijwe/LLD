Let’s break down the **“O” in SOLID**, which stands for the **Open/Closed Principle (OCP)**, in detail:

---

## 📖 Definition
**Open/Closed Principle (OCP):**  
*A class should be open for extension but closed for modification.*

This means you should be able to **add new functionality** to a class without changing its existing code. Instead of editing the class directly, you extend it through inheritance, interfaces, or composition.

---

## 🎯 Why OCP Is Used
- To avoid breaking existing code when adding new features.
- To make systems more **flexible and scalable**.
- To reduce the risk of introducing bugs when requirements change.
- To encourage **reuse** of existing tested code while allowing new behaviors.

---

## ⚠️ Problems OCP Solves
1. **Frequent modifications**: If you keep editing the same class for every new feature, it becomes fragile.
2. **Regression bugs**: Changing old code can break existing functionality.
3. **Rigid design**: Hard to adapt to new requirements without rewriting.

---

## ✅ How OCP Solves These Problems
- By designing classes to be **extended** (via interfaces, abstract classes, or polymorphism).
- New behavior is added in **new classes**, not by modifying old ones.
- Existing tested code remains untouched, reducing risk.

---

## 🛠 Example: Payment Service

### ❌ Without OCP (Bad)
```java
class PaymentService {
    public void processPayment(String type) {
        if (type.equals("CreditCard")) {
            System.out.println("Processing credit card payment");
        } else if (type.equals("UPI")) {
            System.out.println("Processing UPI payment");
        } else if (type.equals("Wallet")) {
            System.out.println("Processing wallet payment");
        }
    }
}
```

👉 Problem: Every time you add a new payment type (e.g., PayPal), you must **modify** this class. That violates OCP.

---

### ✅ With OCP (Good)
```java
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
```

---

### 🔎 How This Works
1. `PaymentMethod` is an **interface** → defines the contract.
2. Each payment type (`CreditCardPayment`, `UPIPayment`, `WalletPayment`) implements the interface.
3. `PaymentService` depends only on the **abstraction**, not concrete classes.
4. To add PayPal tomorrow, you just create `PayPalPayment implements PaymentMethod` — no need to touch `PaymentService`.

---

### 🖥️ Output
```
Processing credit card payment
Processing UPI payment
Processing wallet payment
```

---

## 📚 What You Learned
- OCP ensures **extensibility without modification**.
- You design systems around **abstractions** (interfaces, abstract classes).
- Adding new features means writing new classes, not editing old ones.
- This principle makes your code **robust, flexible, and safer to evolve**.

---

✨ In short: The **Open/Closed Principle** teaches you to design code that can grow without breaking. You extend behavior by adding new classes, not by rewriting existing ones.

