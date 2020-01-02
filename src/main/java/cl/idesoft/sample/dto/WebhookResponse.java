package cl.idesoft.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WebhookResponse")
public class WebhookResponse {

    @ApiModelProperty(name = "url", required = true, dataType = "string", position = 0)
    @JsonProperty(value = "url", required = true, index = 0)
    private String url;

    @ApiModelProperty(name = "create_user", required = true, dataType = "string", position = 1)
    @JsonProperty(value = "create_user", required = true, index = 1)
    private String createUser;

    @ApiModelProperty(name = "create_date", required = true, dataType = "string", position = 1)
    @JsonProperty(value = "create_date", required = true, index = 2)
    private String createDate;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "WebhookResponse{" +
                "url='" + url + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
