package pl.consumer.integration.kafka;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.consumer.service.LocalTimeService;

import java.time.Duration;
import java.time.LocalTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class Consumer {

  private static final String TOPIC_NAME = "test";

  private final LocalTimeService timeService;

  @KafkaListener(topics = TOPIC_NAME)
  public void listen(String message) {
    log.info(
        String.format(
            "Received message on topic %s: %s, delay is %s milliseconds",
            TOPIC_NAME, message, calculateDelay(message)));
  }

  private Long calculateDelay(String message) {
    LocalTime messageTime = LocalTime.parse(message);
    LocalTime now = timeService.now();
    return Duration.between(messageTime, now).toMillis();
  }
}
