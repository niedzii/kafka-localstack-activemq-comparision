package pl.producer.infrastructure.jms;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final JmsMessageSender sender;

    @Scheduled(cron = "0/1 * * * * *")
    public void sendMessage() {
        sender.send(LocalTime.now().toString());
    }
}
