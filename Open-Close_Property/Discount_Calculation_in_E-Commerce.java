interface Discount {
    double apply(double amount);
}

class FestivalDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.9;
    }
}

class ClearanceDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.5;
    }
}

class LoyaltyDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.85;
    }
}

class DiscountService {
    private Discount discount;

    public DiscountService(Discount discount) {
        this.discount = discount;
    }

    public double getFinalPrice(double amount) {
        return discount.apply(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        DiscountService festival = new DiscountService(new FestivalDiscount());
        System.out.println("Festival Price: " + festival.getFinalPrice(1000));

        DiscountService clearance = new DiscountService(new ClearanceDiscount());
        System.out.println("Clearance Price: " + clearance.getFinalPrice(1000));
    }
}
