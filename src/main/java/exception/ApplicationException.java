package exception;

import enums.ExceptionEnums;

public class ApplicationException extends RuntimeException {
    private String message;


    public ApplicationException(ExceptionEnums exceptionEnums) {
        super(exceptionEnums.getMessage());
        this.message = exceptionEnums.getMessage();

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
