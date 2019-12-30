package cl.idesoft.sample.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "WebhookRequest")
public class WebhookRequest {

    @ApiModelProperty(name = "url", required = true, dataType = "string", position = 0)
    @JsonProperty(value = "url", required = true, index = 0)
    private String url;

    @ApiModelProperty(name = "create_user", required = true, dataType = "string", position = 1)
    @JsonProperty(value = "create_user", required = true, index = 1)
    private String createUser;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date createDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "WebhookRequest{" +
                "url='" + url + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
