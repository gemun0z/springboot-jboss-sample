package cl.idesoft.sample.exception;

public class WebhookNotFoundException extends RuntimeException {

    public WebhookNotFoundException() {
        super("Not found");
    }

    public WebhookNotFoundException(Long id) {
        super("Id not found : " + id);
    }

}
