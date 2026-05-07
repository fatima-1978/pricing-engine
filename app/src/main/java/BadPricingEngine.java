public class BadPricingEngine {

    public double calc(double[] prices, int[] qty, String type, String code) {

        double total = 0;

        for (int i = 0; i < prices.length; i++) {
            total = total + prices[i] * qty[i];
        }

        if (type == "VIP") {
            total = total - (total * 0.20);
        } else if (type == "REGULAR") {
            total = total - (total * 0.05);
        }

        if (code == "SAVE10") {
            total = total - (total * 0.10);
        }

        if (code == "SAVE20") {
            total = total - (total * 0.20);
        }

        double tax = total * 0.18;

        total = total + tax;

        return total;
    }
}