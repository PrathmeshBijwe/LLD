
---

## 📖 Definition
**Dependency Inversion Principle (DIP):**  
*High-level modules should not depend on low-level modules. Both should depend on abstractions.*  

In simpler terms: Instead of directly depending on concrete classes, your code should depend on **interfaces or abstract classes**. This makes systems flexible, testable, and easier to extend.

---

## 🎯 Why DIP Is Used
- To reduce **tight coupling** between classes.  
- To make code more **flexible** when requirements change.  
- To allow **easy swapping** of implementations (e.g., Email vs SMS notifier).  
- To improve **testability** (you can mock interfaces in unit tests).  

---

## ⚠️ Problems DIP Solves
1. **Rigid design**: High-level classes break when low-level classes change.  
2. **Hard to test**: Direct dependencies make mocking difficult.  
3. **Poor scalability**: Adding new implementations requires editing high-level code.  

---

## ✅ How DIP Solves These Problems
- By introducing **abstractions** (interfaces).  
- High-level modules depend on abstractions, not concrete implementations.  
- Low-level modules implement those abstractions.  
- This allows swapping implementations without touching high-level logic.  

---

## 🛠 Example 1: Notification Service

```java
// ❌ Wrong Approach: High-level depends directly on low-level
/*
class EmailNotifier {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class NotificationService {
    private EmailNotifier emailNotifier = new EmailNotifier();

    public void notify(String message) {
        emailNotifier.send(message);
    }
}
*/

// ✅ Correct Approach: Depend on abstraction
interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotifier implements Notifier {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class NotificationService {
    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(String message) {
        notifier.send(message);
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService service1 = new NotificationService(new EmailNotifier());
        service1.notify("Welcome to SOLID!");

        NotificationService service2 = new NotificationService(new SMSNotifier());
        service2.notify("Your OTP is 1234");
    }
}
```

👉 Now `NotificationService` depends only on the `Notifier` interface, not on `EmailNotifier` directly.

---

## 📚 Key Takeaways
- DIP ensures **high-level modules depend on abstractions, not concrete classes**.  
- It reduces coupling and makes systems **flexible, testable, and scalable**.  
- Interfaces are the backbone of DIP.  
- DIP often works together with OCP (open for extension, closed for modification).  

---

✨ In short: The **Dependency Inversion Principle** teaches you to design systems where **abstractions connect high-level and low-level modules**, making your code robust and adaptable.  

