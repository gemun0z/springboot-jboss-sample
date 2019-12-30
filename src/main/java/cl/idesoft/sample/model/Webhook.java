package cl.idesoft.sample.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WEBHOOK")
public class Webhook {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WEBHOOK_SEQ")
    @SequenceGenerator(sequenceName = "WEBHOOK_SEQ", name = "WEBHOOK_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "URL", length = 250, nullable = false)
    private String url;

    @Column(name = "CREATE_USER", length = 20, nullable = false)
    private String createUser;

    @Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP", nullable = false)
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "Webhook{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
