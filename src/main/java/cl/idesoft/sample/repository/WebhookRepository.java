package cl.idesoft.sample.repository;

import cl.idesoft.sample.model.Webhook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookRepository extends CrudRepository<Webhook, Long> {
}
