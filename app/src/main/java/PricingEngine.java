public class PricingEngine {

    private final DiscountService discountService = new DiscountService();

    private static final double TAX_RATE = 0.18;

    public double calculate(
            double[] prices,
            int[] qty,
            CustomerType type,
            String code
    ) {

        double subtotal = calculateSubtotal(prices, qty);

        double afterCustomerDiscount =
                discountService.applyCustomerDiscount(subtotal, type);

        double afterCodeDiscount =
                discountService.applyCodeDiscount(afterCustomerDiscount, code);

        double tax = afterCodeDiscount * TAX_RATE;

        return afterCodeDiscount + tax;
    }

    private double calculateSubtotal(double[] prices, int[] qty) {

        double total = 0;

        for (int i = 0; i < prices.length; i++) {
            total += prices[i] * qty[i];
        }

        return total;
    }
}