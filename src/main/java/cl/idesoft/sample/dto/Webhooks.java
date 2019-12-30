package cl.idesoft.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "Webhooks")
public class Webhooks {

    @ApiModelProperty(name = "webhooks", required = true, position = 0)
    @JsonProperty(value = "webhooks", required = true)
    private List<WebhookResponse> webhooks;

    public List<WebhookResponse> getWebhooks() {
        return webhooks;
    }

    public void setWebhooks(List<WebhookResponse> webhooks) {
        this.webhooks = webhooks;
    }

    @Override
    public String toString() {
        return "Webhooks{" +
                "webhooks=" + webhooks +
                '}';
    }
}
