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
