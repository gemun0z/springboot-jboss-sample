package cl.idesoft.sample.controller;

import cl.idesoft.sample.dto.WebhookRequest;
import cl.idesoft.sample.dto.WebhookResponse;
import cl.idesoft.sample.dto.Webhooks;
import cl.idesoft.sample.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WebkookController {

    @Autowired
    private WebhookService service;

    @PostMapping(path = "/webhook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveWebhook(@RequestBody WebhookRequest request) {
        try {
            service.saveWebhook(request);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/webhook/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateWebhook(@PathVariable(value = "id") Long id, @RequestBody WebhookRequest request) {
        try {
            service.updateWebhook(id, request);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/webhook", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Webhooks> getWebhooks() {
        try {
            List<WebhookResponse> webhookResponses = service.getWebhooks();
            Webhooks webhooks = new Webhooks();
            webhooks.setWebhooks(webhookResponses);
            return new ResponseEntity<Webhooks>(webhooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Webhooks>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/webhook/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebhookResponse> getWebhookById(@PathVariable(value = "id") Long id) {
        try {
            WebhookResponse response = service.getWebhookById(id);
            return new ResponseEntity<WebhookResponse>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<WebhookResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/webhook/{id}")
    public ResponseEntity<Void> deleteWebhook(@PathVariable(value = "id") Long id) {
        try {
            service.deleteWebhook(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
