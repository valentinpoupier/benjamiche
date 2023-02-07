package be.technifutur.benjamiche.exceptions;

public class FormValidationException extends RuntimeException {
    public FormValidationException(String message) {
        super(message);
    }
}
