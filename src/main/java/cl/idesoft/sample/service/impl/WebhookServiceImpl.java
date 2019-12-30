package cl.idesoft.sample.service.impl;

import cl.idesoft.sample.dto.WebhookRequest;
import cl.idesoft.sample.dto.WebhookResponse;
import cl.idesoft.sample.model.Webhook;
import cl.idesoft.sample.repository.WebhookRepository;
import cl.idesoft.sample.service.WebhookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebhookServiceImpl implements WebhookService {

    @Autowired
    private WebhookRepository repository;

    @Override
    public void saveWebhook(WebhookRequest request) {
        Webhook webhook = new Webhook();
        BeanUtils.copyProperties(request, webhook);
        repository.save(webhook);
    }

    @Override
    public void updateWebhook(Long id, WebhookRequest request) {
        Webhook webhook = repository.findOne(id);
        BeanUtils.copyProperties(request, webhook);
        repository.save(webhook);
    }

    @Override
    public List<WebhookResponse> getWebhooks() {
        List<WebhookResponse> webhookResponses = new ArrayList<WebhookResponse>();
        Iterable<Webhook> webhooks = repository.findAll();
        for (Webhook webhook : webhooks) {
            WebhookResponse response = new WebhookResponse();
            BeanUtils.copyProperties(webhook, response);
            webhookResponses.add(response);
        }
        return webhookResponses;
    }

    @Override
    public WebhookResponse getWebhookById(Long id) {
        WebhookResponse response = new WebhookResponse();
        Webhook webhook = repository.findOne(id);
        BeanUtils.copyProperties(webhook, response);
        return response;
    }

    @Override
    public void deleteWebhook(Long id) {
        repository.delete(id);
    }
}
