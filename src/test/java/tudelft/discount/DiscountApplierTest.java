package tudelft.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DiscountApplierTest {

    private final ProductDao productDao = Mockito.mock(ProductDao.class);
    private final DiscountApplier discountApplier = new DiscountApplier(productDao);
    Product home = new Product("Bottle", 22.0, ProductCategory.HOME);
    Product business = new Product("Phone", 102.0, ProductCategory.BUSINESS);

    @BeforeEach
    public void before() {
        home.setPrice(22.00);
        business.setPrice(102.0);
    }

    @Test
    public void testApplyDiscount() {
        when(productDao.all())
                .thenReturn(Arrays.asList(home, business));

        discountApplier.setNewPrices();

        assertEquals(19.8, home.getPrice());
        assertEquals(112.2, business.getPrice());
    }

    @Test
    public void testApplyDiscount_negativePrice() {
        home.setPrice(-123.9);
        when(productDao.all())
                .thenReturn(Arrays.asList(home, business));

        discountApplier.setNewPrices();

        assertEquals(-123.9, home.getPrice());
        assertEquals(112.2, business.getPrice());

    }
}
