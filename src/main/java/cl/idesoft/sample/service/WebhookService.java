package cl.idesoft.sample.service;

import cl.idesoft.sample.dto.WebhookRequest;
import cl.idesoft.sample.dto.WebhookResponse;

import java.util.List;

public interface WebhookService {

    void saveWebhook(WebhookRequest request);

    void updateWebhook(Long id, WebhookRequest request);

    List<WebhookResponse> getWebhooks();

    WebhookResponse getWebhookById(Long id);

    void deleteWebhook(Long id);

}
