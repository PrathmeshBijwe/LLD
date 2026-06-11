# Strategy Design Pattern

## Definition

Strategy is a behavioral design pattern that defines a family of algorithms, encapsulates each one in a separate class, and makes them interchangeable at runtime. The client can switch between algorithms without changing the code that uses them.

## Why It Is Used

In real systems, you often have multiple ways to perform the same task — different sorting algorithms, different payment methods, different compression techniques, different pricing rules. Without Strategy, developers tend to write a giant if-else or switch block to pick the right behavior. This works initially but becomes a maintenance nightmare as new variations get added.

Strategy is used to:
- Avoid bloated conditional logic
- Make algorithms swappable at runtime
- Follow Open/Closed Principle — add new strategies without touching existing code
- Isolate algorithm-specific code so it can be tested and changed independently

## Problem It Solves

Imagine a `PaymentService` class with a method `pay()` that has:

```java
if (type.equals("CREDIT_CARD")) { ... }
else if (type.equals("UPI")) { ... }
else if (type.equals("WALLET")) { ... }
```

Problems with this:
1. Every time a new payment method is added, you modify this class (violates Open/Closed Principle)
2. The class grows huge and becomes hard to test
3. Logic for different algorithms gets tangled together
4. Hard to reuse a single payment strategy elsewhere

Strategy fixes this by extracting each `if` branch into its own class implementing a common interface, and the context class just delegates to whichever strategy is plugged in.

## Structure

1. **Strategy Interface** – declares the common method all algorithms must implement
2. **Concrete Strategies** – actual implementations of the algorithm
3. **Context** – holds a reference to a Strategy object and delegates work to it

## Example: Payment System

```java
// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

class UpiPayment implements PaymentStrategy {
    private String upiId;
    
    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }
    
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI: " + upiId);
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678"));
        cart.checkout(500);
        
        cart.setPaymentStrategy(new UpiPayment("user@upi"));
        cart.checkout(200);
    }
}
```

Notice that `ShoppingCart` doesn't know or care how payment happens — it just calls `pay()` on whatever strategy is currently set.

## Other Things You Should Add to Your Post

**Real-world examples** – mention familiar use cases so readers connect with it:
- `Comparator` in Java's `Collections.sort()` — different sorting strategies
- Compression algorithms (ZIP vs RAR vs 7z)
- Navigation apps choosing route algorithms (fastest, shortest, avoid tolls)
- Validation strategies for different input types

**Strategy vs State Pattern** – this is a common interview question. Both have similar structure (context delegating to an interchangeable object), but:
- Strategy: client explicitly chooses the algorithm; strategies don't usually know about each other
- State: the object's internal state changes the behavior, and states often transition between each other automatically

**Advantages**
- Open/Closed Principle compliance
- Eliminates conditional complexity
- Algorithms can be tested in isolation
- Easy to add new strategies

**Disadvantages**
- Increases number of classes
- Client must be aware of different strategies to choose the right one
- If strategies are stateless, you might create unnecessary objects (can be mitigated using enums or singletons for stateless strategies)

**UML Diagram** – a simple diagram showing Context → Strategy interface ← Concrete Strategies tends to get good engagement on LinkedIn/GitHub posts since people grasp it visually.

**When NOT to use it** – if you only have 2 algorithms and they're unlikely to grow, a simple if-else might be simpler and Strategy could be over-engineering. Worth mentioning since "knowing when not to apply a pattern" shows maturity.

