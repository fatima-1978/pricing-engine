import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PricingEngineTest {

    @Test
    public void testVipCustomerWithDiscountCode() {

        PricingEngine engine = new PricingEngine();

        double[] prices = {100};
        int[] qty = {2};

        double result = engine.calculate(
                prices,
                qty,
                CustomerType.VIP,
                "SAVE10"
        );

        assertTrue(result > 0);
    }

    @Test
    public void testRegularCustomerWithoutCode() {

        PricingEngine engine = new PricingEngine();

        double[] prices = {50, 100};
        int[] qty = {1, 2};

        double result = engine.calculate(
                prices,
                qty,
                CustomerType.REGULAR,
                null
        );

        assertTrue(result > 0);
    }
}