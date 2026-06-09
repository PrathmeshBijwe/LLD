
---

## 📖 Definition
**Interface Segregation Principle (ISP):**  
*Clients should not be forced to depend on methods they do not use.*

This means instead of designing one large, “fat” interface with many methods, you should split it into smaller, more specific interfaces. Each client should only know about the methods that are relevant to them.

---

## 🎯 Why ISP Is Used
- To avoid **bloated interfaces** that force classes to implement unnecessary methods.
- To make systems more **modular and flexible**.
- To reduce **coupling** between unrelated functionalities.
- To ensure **clean contracts** between classes and interfaces.

---

## ⚠️ Problems ISP Solves
1. **Unnecessary implementation**: Classes forced to implement methods they don’t need.
2. **Fragile design**: Changes in one part of a large interface can break many classes.
3. **Poor readability**: Interfaces with too many methods are hard to understand.
4. **Violation of SRP**: A large interface often mixes multiple responsibilities.

---

## ✅ How ISP Solves These Problems
- By splitting large interfaces into **smaller, role-specific interfaces**.
- Classes implement only what they need.
- Clients depend only on relevant contracts.
- This keeps code **clean, modular, and easy to extend**.

---

## 🛠 Example 1: Bad Design (Violating ISP)
```java
interface Machine {
    void print();
    void scan();
    void fax();
}

class OldPrinter implements Machine {
    public void print() { System.out.println("Printing..."); }
    public void scan() { throw new UnsupportedOperationException("Scan not supported"); }
    public void fax() { throw new UnsupportedOperationException("Fax not supported"); }
}
```

👉 Problem: `OldPrinter` is forced to implement `scan()` and `fax()` even though it doesn’t support them.

---

## 🛠 Example 2: Good Design (Following ISP)
```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class SimplePrinter implements Printer {
    public void print() { System.out.println("Printing..."); }
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    public void print() { System.out.println("Printing..."); }
    public void scan() { System.out.println("Scanning..."); }
    public void fax() { System.out.println("Faxing..."); }
}
```

👉 Now `SimplePrinter` only implements `Printer`, while `MultiFunctionPrinter` implements all three. Each class depends only on what it needs.

---

## 🛠 Example 3: Real-World Analogy
Think of a **restaurant menu**:
- Bad design: One giant menu with food, drinks, desserts, and chef specials all mixed together.
- Good design: Separate menus for drinks, food, and desserts. Customers only look at what they want.

---

## 📚 What You Learned
- ISP prevents **fat interfaces**.
- Classes should only implement methods they actually need.
- Splitting interfaces improves **clarity, modularity, and flexibility**.
- ISP often works hand-in-hand with SRP (both aim to reduce unnecessary responsibilities).

---

✨ In short: The **Interface Segregation Principle** teaches you to design **small, focused interfaces** so that clients only depend on what they truly use.

