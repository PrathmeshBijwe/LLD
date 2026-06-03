
class EmailService {
    public void sendEmail(String name) {
        // logic to send email
        System.out.println("Email sent to " + name);
    }
}
class UserService {
    private EmailService emailService;

    // Constructor: inject EmailService when creating UserService
    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void addUser(String name) {
        // logic to add user
        System.out.println("User " + name + " added.");
        // delegate email responsibility
        emailService.sendEmail(name);
    }
}


public class Main {
    public static void main(String[] args) {
        // Create an EmailService object
        EmailService emailService = new EmailService();

        // Inject EmailService into UserService
        UserService userService = new UserService(emailService);
        userService.addUser("Prathmesh");
    }
}
