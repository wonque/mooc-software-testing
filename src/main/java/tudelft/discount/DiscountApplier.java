package tudelft.discount;

import java.util.List;

public class DiscountApplier {

    private ProductDao dao;

    public DiscountApplier(ProductDao dao) {
        this.dao = dao;
    }

    public void setNewPrices() {
        List<Product> products = dao.all();
        double currentPrice;

        for (Product product : products) {
            currentPrice = product.getPrice();
            if (product.getCategory().equals(ProductCategory.HOME)) {
                product.setPrice(ProductCategory.HOME.applyDiscount(currentPrice));
            }
            if (product.getCategory().equals(ProductCategory.BUSINESS)) {
                product.setPrice(ProductCategory.BUSINESS.applyDiscount(currentPrice));
            }
        }
    }
}
