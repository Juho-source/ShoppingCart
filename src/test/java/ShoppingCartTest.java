import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void sumPricesArrayList() {
        ArrayList<Double> costs1 = new ArrayList<>(Arrays.asList(2.00, 3.00, 5.00));
        assertEquals(10.00, ShoppingCart.sumPrices(costs1), 0.01);

        ArrayList<Double> costs2 = new ArrayList<>();
        assertEquals(0.00, ShoppingCart.sumPrices(costs2), 0.01);

        ArrayList<Double> costs3 = new ArrayList<>(Arrays.asList(5.00));
        assertEquals(5.00, ShoppingCart.sumPrices(costs3), 0.01);
    }
}