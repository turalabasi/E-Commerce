package enums;

public enum ExceptionEnums {
    BRAND_NOT_FOUND("brand not found"),
    WRONG_FIN_EXCEPTION("wrong fin number"),
    PRODUCT_NOT_FOUND("product not found"),
    WRONG_EMAIL_FORMAT_EXCEPTION("wrong email format"),
    WEAK_PASSWORD_EXCEPTION("weak password"),
    PRODUCT_HAS_NOT_BEEN_SELECTED("product has not been selected"),
    FORMAT_EXCEPTION("format exception: "),
    WRONG_BIRTHDATE_EXCEPTION("Wrong birthdate"),
    CATEGORY_NOT_FOUND("category not found"),
    USER_NOT_FOUND("user not found"),
    FIN_NOT_FOUND("fin not found"),
    WRONG_USERNAME_OR_PASSWORD_EXCEPTION("wrong username or password"),
    INVALID_OPTION_EXCEPTION("invalid option"),
    LOW_MONEY_EXCEPTION("low money");




    ExceptionEnums(String message) {
        this.message = message;
    }
    private final String message;

    public String getMessage() {
        return message;
    }
}
