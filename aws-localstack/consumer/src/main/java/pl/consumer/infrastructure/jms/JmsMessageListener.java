package pl.consumer.infrastructure.jms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.consumer.infrastructure.service.LocalTimeService;

import java.time.Duration;
import java.time.LocalTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class JmsMessageListener {

  private final LocalTimeService localTimeService;

  @JmsListener(destination = "${jms.queue.name}")
  void receiveMessage(String message) {
    log.info(
            String.format(
                    "Received message %s, delay is %s milliseconds",
                    message, calculateDelay(message)));
  }

  private Long calculateDelay(String message) {
    LocalTime messageTime = LocalTime.parse(message);
    LocalTime now = localTimeService.now();
    return Duration.between(messageTime, now).toMillis();
  }
}
