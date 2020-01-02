package cl.idesoft.sample.service;

import cl.idesoft.sample.dto.WebhookRequest;
import cl.idesoft.sample.dto.WebhookResponse;
import cl.idesoft.sample.exception.WebhookNotFoundException;

import java.util.List;

public interface WebhookService {

    void saveWebhook(WebhookRequest request);

    void updateWebhook(Long id, WebhookRequest request) throws WebhookNotFoundException;

    List<WebhookResponse> getWebhooks()  throws WebhookNotFoundException;

    WebhookResponse getWebhookById(Long id)  throws WebhookNotFoundException;

    void deleteWebhook(Long id)  throws WebhookNotFoundException;

}
