package pl.producer.integration.activemq;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.producer.service.LocalTimeService;

import java.time.Duration;
import java.time.LocalTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {

  private final LocalTimeService timeService;

  @JmsListener(destination = "test")
  public void receiveMessage(String message) {
    log.info(
            String.format(
                    "Received message on topic %s: %s, delay is %s milliseconds",
                    "test", message, calculateDelay(message)));
  }

  private Long calculateDelay(String message) {
    LocalTime messageTime = LocalTime.parse(message);
    LocalTime now = timeService.now();
    return Duration.between(messageTime, now).toMillis();
  }
}
