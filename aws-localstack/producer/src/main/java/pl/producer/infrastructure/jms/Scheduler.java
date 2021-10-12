package pl.producer.infrastructure.jms;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.producer.infrastructure.service.LocalTimeService;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final JmsMessageSender sender;
    private final LocalTimeService localTimeService;

    @Scheduled(cron = "0/1 * * * * *")
    public void sendMessage() {
        sender.send(localTimeService.now().toString());
    }
}
