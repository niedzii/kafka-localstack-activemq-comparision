package pl.producer.integration.activemq;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import pl.producer.service.LocalTimeService;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class Scheduler {

  private final Producer producer;
  private final LocalTimeService localTimeService;

  @Scheduled(cron = "0/1 * * * * *")
  public void sendMessage() {
    producer.sendMessage(localTimeService.now().toString());
  }
}
