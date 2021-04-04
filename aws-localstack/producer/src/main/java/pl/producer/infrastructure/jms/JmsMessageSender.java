package pl.producer.infrastructure.jms;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;

@RequiredArgsConstructor
public class JmsMessageSender {

    private final JmsTemplate template;
    private final String queueName;

    public void send(String message) {
        template.convertAndSend(queueName, message);
    }
}
