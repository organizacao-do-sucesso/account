package store.account;

import java.util.Arrays;
import java.util.Set;

public enum Role {

    CUSTOMER("customer", Set.of(
        Permission.PRODUCT_READ,
        Permission.ORDER_READ,
        Permission.ORDER_WRITE,
        Permission.EXCHANGE_READ
    )),

    PRODUCT_MANAGER("product-manager", Set.of(
        Permission.PRODUCT_READ,
        Permission.PRODUCT_WRITE
    )),

    ACCOUNT_MANAGER("account-manager", Set.of(
        Permission.PRODUCT_READ,
        Permission.ACCOUNT_ADMIN
    )),

    ADMINISTRATOR("administrator", Set.of(
        Permission.PRODUCT_READ,
        Permission.PRODUCT_WRITE,
        Permission.ORDER_READ,
        Permission.ORDER_WRITE,
        Permission.EXCHANGE_READ,
        Permission.ACCOUNT_ADMIN
    ));

    private final String value;
    private final Set<Permission> permissions;

    Role(String value, Set<Permission> permissions) {
        this.value = value;
        this.permissions = Set.copyOf(permissions);
    }

    public String value() {
        return value;
    }

    public Set<Permission> permissions() {
        return permissions;
    }

    public static Role fromValue(String value) {
        return Arrays.stream(values())
            .filter(role -> role.value.equals(value))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Invalid role: " + value));
    }
}