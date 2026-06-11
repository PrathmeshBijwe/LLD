interface Notifier {
    void notify(String message);
}

class EmailNotifier implements Notifier {
    public void notify(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotifier implements Notifier {
    public void notify(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotifier implements Notifier {
    public void notify(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

class NotificationService {
    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.notify(message);
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService service1 = new NotificationService(new EmailNotifier());
        service1.send("Welcome to our app!");

        NotificationService service2 = new NotificationService(new SMSNotifier());
        service2.send("Your OTP is 1234");
    }
}
