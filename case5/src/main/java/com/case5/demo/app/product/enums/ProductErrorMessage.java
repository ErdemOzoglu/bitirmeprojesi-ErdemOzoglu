package com.case5.demo.app.product.enums;

import com.case5.demo.app.gen.enums.BaseErrorMessage;

public enum ProductErrorMessage implements BaseErrorMessage {
    PRODUCT_NOT_FOUND("Product not found!"),
    ;

    private String message;
    ProductErrorMessage(String message) {
        this.message = message;
    }



    @Override
    public String getMessage() {
        return null;
    }
}
