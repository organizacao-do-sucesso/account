package store.account;

public enum Permission {

    PRODUCT_READ("product.read"),
    PRODUCT_WRITE("product.write"),
    ORDER_READ("order.read"),
    ORDER_WRITE("order.write"),
    EXCHANGE_READ("exchange.read"),
    ACCOUNT_ADMIN("account.admin");

    private final String value;

    Permission(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}