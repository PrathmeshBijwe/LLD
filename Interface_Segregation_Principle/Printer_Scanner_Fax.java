// ❌ Wrong Approach: Fat interface forces all methods
/*
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
*/

// ✅ Correct Approach: Split into smaller interfaces
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
