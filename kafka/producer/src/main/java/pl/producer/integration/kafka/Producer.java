package pl.producer.integration.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

  private static final String topicName = "test";

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    this.kafkaTemplate.send(topicName, message);
  }
}
