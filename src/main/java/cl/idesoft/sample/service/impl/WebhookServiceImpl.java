package cl.idesoft.sample.service.impl;

import cl.idesoft.sample.dto.WebhookRequest;
import cl.idesoft.sample.dto.WebhookResponse;
import cl.idesoft.sample.exception.WebhookNotFoundException;
import cl.idesoft.sample.model.Webhook;
import cl.idesoft.sample.repository.WebhookRepository;
import cl.idesoft.sample.service.WebhookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class WebhookServiceImpl implements WebhookService {

    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

    @Autowired
    private WebhookRepository repository;

    @Override
    public void saveWebhook(WebhookRequest request) {
        Webhook webhook = new Webhook();
        BeanUtils.copyProperties(request, webhook);
        webhook.setCreateDate(new Date());
        repository.save(webhook);
    }

    @Override
    public void updateWebhook(Long id, WebhookRequest request)  throws WebhookNotFoundException {
        Webhook webhook = repository.findOne(id);
        if(webhook == null) {
            throw new WebhookNotFoundException(id);
        }
        BeanUtils.copyProperties(request, webhook);
        repository.save(webhook);
    }

    @Override
    public List<WebhookResponse> getWebhooks() throws WebhookNotFoundException {
        List<WebhookResponse> webhookResponses = new ArrayList<WebhookResponse>();
        Iterable<Webhook> webhooks = repository.findAll();
        if(((Collection<?>) webhooks).size() == 0) {
            throw new WebhookNotFoundException();
        }
        for (Webhook webhook : webhooks) {
            WebhookResponse response = new WebhookResponse();
            BeanUtils.copyProperties(webhook, response, "createDate");
            response.setCreateDate(df.format(webhook.getCreateDate()));
            webhookResponses.add(response);
        }
        return webhookResponses;
    }

    @Override
    public WebhookResponse getWebhookById(Long id) throws WebhookNotFoundException {
        WebhookResponse response = new WebhookResponse();
        Webhook webhook = repository.findOne(id);
        if(webhook == null) {
            throw new WebhookNotFoundException(id);
        }
        BeanUtils.copyProperties(webhook, response, "createDate");
        response.setCreateDate(df.format(webhook.getCreateDate()));
        return response;
    }

    @Override
    public void deleteWebhook(Long id) throws WebhookNotFoundException {
        Webhook webhook = repository.findOne(id);
        if(webhook == null) {
            throw new WebhookNotFoundException(id);
        }
        repository.delete(id);
    }
}
