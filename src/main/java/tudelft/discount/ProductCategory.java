package tudelft.discount;

import java.util.function.DoubleBinaryOperator;

public enum ProductCategory {
    HOME(0.9, (x, y) -> x * y),
    BUSINESS(1.1, (x, y) -> x * y),
    OTHER(1.0, (x, y) -> x * y);

    private final double discount;
    private final DoubleBinaryOperator operator;

    ProductCategory(double discount, DoubleBinaryOperator calc) {
        this.discount = discount;
        this.operator = calc;
    }

    public double applyDiscount(double price) {
        if (price < 0) {
            return operator.applyAsDouble(OTHER.discount, price);
        }
        return operator.applyAsDouble(this.discount, price);
    }
}
