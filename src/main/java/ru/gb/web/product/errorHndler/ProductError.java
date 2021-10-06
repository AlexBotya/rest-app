package ru.gb.web.product.errorHndler;

public class ProductError {
    private final int statusCode;
    private final String message;

    public ProductError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
