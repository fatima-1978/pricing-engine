import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BadPricingEngineTest {

    @Test
    public void testRegularCustomerWithoutDiscountCode() {

        BadPricingEngine engine = new BadPricingEngine();

        double[] prices = {100, 200};
        int[] qty = {1, 1};

        double result = engine.calc(prices, qty, "REGULAR", "NONE");

        assertTrue(result > 0);
    }

    @Test
    public void testVipCustomerWithSave10() {

        BadPricingEngine engine = new BadPricingEngine();

        double[] prices = {100};
        int[] qty = {2};

        double result = engine.calc(prices, qty, "VIP", "SAVE10");

        assertTrue(result > 0);
    }
}