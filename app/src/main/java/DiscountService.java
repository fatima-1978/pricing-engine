public class DiscountService {

    public double applyCustomerDiscount(double total, CustomerType type) {

        switch (type) {

            case VIP:
                return total * 0.80;

            case REGULAR:
                return total * 0.95;

            default:
                return total;
        }
    }

    public double applyCodeDiscount(double total, String code) {

        if (code == null) {
            return total;
        }

        switch (code) {

            case "SAVE10":
                return total * 0.90;

            case "SAVE20":
                return total * 0.80;

            default:
                return total;
        }
    }
}